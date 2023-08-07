package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallBackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=form form_size_m form_theme_alfa-on-white]");
        form.$("[data-test-id=city] input").sendKeys(" Ставрополь");
        form.$("[data-test-id=date] input").setValue("10.05.2025");
        form.$("[data-test-id=name] input").setValue("Петр Петрович");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=notification]").shouldHave(exactText("Встреча успешно забронирована на "));
    }

}
