package tests;

import org.junit.jupiter.api.Test;

public class AndroidWikipediaTests extends TestBase {
    Steps steps = new Steps();

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

    @Test
    void mobileCheckFootterTabbarTest() {

        steps
             .skipLanguage()
             .switchTabFootter("Explore")
             .checkTabExplore("Customize your Explore feed")
             .switchTabFootter("Saved")
             .checkTabSaved("Sync reading lists")
             .switchTabFootter("Search")
             .checkTabSearch("History")
             .switchTabFootter("Edits")
             .checkTabEdits("Did you know that everyone can edit Wikipedia?")
             .switchTabFootter("More")
             .checkTabMore();
    }

    @Test
    void mobileCheckChapterOfArticleTest() {
        String searchWord = "appium";

        steps
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openRequestArticle(searchWord)
             .checkArticle()
             .switchTabContents()
             .checkTabContents()
             .switchArticleTitleAndCheck(searchWord)
             .switchTabContents()
             .switchArticleChapterAndCheck("History")
             .switchTabContents()
             .switchArticleChapterAndCheck("References")
             .switchTabContents()
             .switchArticleChapterAndCheck("External links")
             .switchTabContents()
             .switchArticleChapterAndCheck("About this article");
    }

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
}





