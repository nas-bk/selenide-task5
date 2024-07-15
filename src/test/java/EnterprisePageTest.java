import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterprisePageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openEnterprisePageTest() {
        open("https://github.com");

        $(".header-menu-wrapper")
                .$(byText("Solutions"))
                .hover();

        $("ul[aria-labelledby='solutions-by-size-heading']")
                .find(byText("Enterprise"))
                .click();

        $("#hero-section-brand-heading")
                .shouldHave(text("The AI-powered developer platform."))
                .shouldBe(visible);
    }
}
