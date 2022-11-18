package tests;

import org.junit.jupiter.api.Test;

public class AndroidWikipediaTests extends TestBase {
    Steps steps = new Steps();

    @Test
    void mobileSearchWordTest() {
        String searchWord = "Selenide";

        steps
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openFirstArticle()
             .checkArticle();
    }

    @Test
    void mobileSearchPhraseTest() {
        String searchPhrase = "Mobile testing";

        steps
             .skipLanguage()
             .searchRequest(searchPhrase)
             .verifyContentFound()
             .openRequestArticle(searchPhrase)
             .checkArticle();
    }

    @Test
    void mobileOnboardingScreenTest() {

        steps
             .checkContentScreen("The Free Encyclopedia\n" +
                        "…in over 300 languages")
             .openNextScreen()
             .checkContentScreen("New ways to explore")
             .openNextScreen()
             .checkContentScreen("Reading lists with sync")
             .openNextScreen()
             .checkContentScreen("Send anonymous data")
             .openFinishedScreen()
             .checkFinishedScreen();
    }
}





