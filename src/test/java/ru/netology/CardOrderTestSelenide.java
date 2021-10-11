package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTestSelenide {
    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
    }

    @Test
    public void shouldOrderCardWithCssSelectors() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Сергеев Иван");
        $("[type='tel']").setValue("+79890000002");
        $(".checkbox__box").click();
        $("button").click();
        $(".paragraph_theme_alfa-on-white").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


}
