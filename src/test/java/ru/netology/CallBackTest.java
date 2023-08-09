package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallBackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ставрополь");
        $("[data-test-id=date] input").sendKeys("10.05.2025");
        $("[data-test-id=name] input").setValue("Петр Петрович");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=notification]")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на" + "10.05.2025"));
    }

}
