package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Steps {

    public Steps skipLanguage() {
        step("Skip language alert", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        return this;
    }

    public Steps searchRequest(String searchRequest) {
        step("Input search request", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
        });
        return this;
    }

    public Steps verifyContentFound() {
        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
        return this;
    }

    public Steps openFirstArticle() {
        step("Open first found article", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        return this;
    }

    public Steps openRequestArticle(String searchRequest) {
        step("Open article by search request", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text(searchRequest)).click());
        return this;
    }

    public Steps checkArticle() {
        step("Check article", () ->
                $(AppiumBy.className("android.webkit.WebView")).shouldBe(visible));
        return this;
    }

    public Steps checkContentScreen(String content) {
            step("Check content onboarding screen", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text(content));
                $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered")).shouldBe(visible);
        });
        return this;
    }

    public Steps openNextScreen() {
        step("Open next screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        return this;
    }

    public Steps openFinishedScreen() {
        step("Open finished screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
        return this;
    }

    public Steps checkFinishedScreen() {
        step("Checking onboarding is finished", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_header_image")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(Condition.text("Customize your Explore feed"));
        });
        return this;
    }
}
