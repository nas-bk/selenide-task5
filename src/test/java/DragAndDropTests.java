import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @BeforeEach
    void beforeEach() {
        open("/drag_and_drop");
    }

    @Test
    void dragAndDropActionsTest() {
        var elementA = $("#column-a");
        var elementB = $("#column-b");

        actions().clickAndHold(elementA)
                .moveToElement(elementB)
                .release()
                .perform();

        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));
    }

    @Test
    void methodDragAndDropTest() {
        var elementA = $("#column-a");
        var elementB = $("#column-b");

        elementA.dragAndDrop(DragAndDropOptions.to(elementB));

        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));
    }
}
