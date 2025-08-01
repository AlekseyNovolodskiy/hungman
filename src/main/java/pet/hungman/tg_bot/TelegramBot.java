package pet.hungman.tg_bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramBot implements SpringLongPollingBot {

    private final TgBotConsumer tgBotConsumer;

    @Override
    public String getBotToken() {
        return "7957920891:AAFAHbE7wg3-Exq2KolK44ccDudhJcJu94M";
    }

    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return tgBotConsumer;
    }

}