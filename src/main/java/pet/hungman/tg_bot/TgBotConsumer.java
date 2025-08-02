package pet.hungman.tg_bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import pet.hungman.service.LogService;

import java.io.IOException;
import java.util.List;

@Component
public class TgBotConsumer implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;
    private final LogService logService;

    public TgBotConsumer(LogService logService) {
        this.logService = logService;
        this.telegramClient = new OkHttpTelegramClient("7957920891:AAFAHbE7wg3-Exq2KolK44ccDudhJcJu94M");
    }

    @SneakyThrows
    @Override
    public void consume(Update update) {

        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (text.equals("/start")) {
                sendMainMenu(chatId);
            } else {
                sendMessage(chatId, "Неизвестная команда");
            }
        } else if (update.hasCallbackQuery()) {
            handleCallBackQuery(update.getCallbackQuery());
        }


    }

    private void handleCallBackQuery(CallbackQuery callbackQuery) throws IOException {

        Long chatId = callbackQuery.getFrom().getId();
        String data = callbackQuery.getData();
        switch (data) {
            case "user" -> {
                List<String> userLogs = logService.getUserLogs();
                sendLogsInChunks(chatId, userLogs, "User logs");
            }

            case "app" -> {
                List<String> appLogs = logService.getAppLogs();
                sendLogsInChunks(chatId, appLogs, "App logs");
            }
            default -> sendMessage(chatId, "неизвестная команда");
        }
    }
    @SneakyThrows
    private void sendLogsInChunks(Long chatId, List<String> logs, String logType) {

        final int CHUNK_SIZE = 50;
        StringBuilder chunk = new StringBuilder();
        chunk.append("=== ").append(logType).append(" ===\n");

        int counter = 0;

        for (String logEntry : logs) {
            chunk.append(logEntry).append("\n");
            counter++;

            // Если набрали CHUNK_SIZE записей или это последняя запись
            if (counter % CHUNK_SIZE == 0 || counter == logs.size()) {
                sendMessage(chatId, chunk.toString());
                chunk = new StringBuilder(); // Начинаем новый чанк
                if (counter < logs.size()) {
                    chunk.append("=== ").append(logType).append( " (продолжение) ===\n");
                }

                // Небольшая задержка между сообщениями, чтобы не превысить лимиты Telegram
                Thread.sleep(300);
            }
        }

        if (logs.isEmpty()) {
            sendMessage(chatId, "Нет записей в логах");
        }
    }

    @SneakyThrows
    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = SendMessage.builder()
                .text(text)
                .chatId(chatId)
                .build();

        telegramClient.execute(sendMessage);
    }

    @SneakyThrows
    private void sendMainMenu(Long chatId) {
        SendMessage sendMessage = SendMessage.builder()
                .text("Выберите пункт меню")
                .chatId(chatId)
                .build();

        InlineKeyboardButton buttonLog = InlineKeyboardButton.builder()
                .text("UserLogs")
                .callbackData("user")
                .build();
        InlineKeyboardButton appLog = InlineKeyboardButton.builder()
                .text("AppLogs")
                .callbackData("app")
                .build();

        List<InlineKeyboardRow> buttonsList = List.of(
                new InlineKeyboardRow(buttonLog),
                new InlineKeyboardRow(appLog)
        );
        new InlineKeyboardRow();

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup(buttonsList);

        sendMessage.setReplyMarkup(markup);

        telegramClient.execute(sendMessage);
    }
}
