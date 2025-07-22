package pet.hungman.service.programmbody;

import org.springframework.stereotype.Service;

@Service
public class HungPicture {



    public String risuemViselicu(int i) {
        String multiLineText = "";
        switch (i) {
            case 0:
                multiLineText = """
                        ||
                        ||
                        ||
                        ||
                        ||
                        ||
                        ||
                        ||
                        ||
                        """;

                break;
            case 1:
                multiLineText = """
                        ||=====||
                        ||
                        ||
                        ||
                        ||
                        ||
                        ||
                        ||
                        """;

                break;
            case 2:
                multiLineText = """
                        ||=====||
                        ||     |
                        ||     O
                        ||
                        ||
                        ||
                        ||
                        ||
                        """;


                break;

            case 3:
                multiLineText = """
                         ||=====||
                         ||     |
                         ||     O
                         ||    /|\\\\
                         ||     |
                         ||
                         ||
                         ||
                        """;

                break;

            case 4:
                multiLineText = """
                         ||=====||
                         ||     |
                         ||     O
                         ||    /|\\\\
                         ||     |
                         ||    / \\\\
                         ||
                         ||
                        """;


        }

        return multiLineText;
    }
}