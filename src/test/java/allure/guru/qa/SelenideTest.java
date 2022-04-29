package allure.guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


@Owner("IgorSidorenko")
@Severity(SeverityLevel.BLOCKER)
@Feature("Task in repository")
@Story("Ability to see created issues in repository")
public class SelenideTest {
    @Test
    @DisplayName("My favorite test")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com ");

        $(".header-search-input").click();
        $(".header-search-input").setValue("IgorSidorenko/qa_guru_12_7");
        $(".header-search-input").submit();

        $(linkText("IgorSidorenko/qa_guru_12_7")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.visible);
    }

}

