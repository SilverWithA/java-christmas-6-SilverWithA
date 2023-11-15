package christmas.constants;

import org.mockito.internal.matchers.Null;

public enum DecemberEvent {
    GIFT_MENU_NAME("샴페인", 120000),
    GIFT_MENU_COUNT("샴페인",1),
    FIRST_EVENT_BADGE("산타", 20000),
    SECOND_EVENT_BADGE("트리", 10000),
    THIRD_EVENT_BADGE("별", 5000),
    EVENT_BADGE_NOTHING("없음", 0),

    CHRISTMAS_START_AMOUNT(null,1000),
    CHRISTMAS_INCREASE_UNIT(null,100),
    DAY_DISCOUNT_AMOUNT(null,2023),
    SPECIAL_DISCOUNT_AMOUNT(null,1000),
    WEEKDAY_DISCOUNT_MENU("디저트",2023),
    WEEKEND_DISCOUNT_MENU("메인",2023);



    private final String name;
    private final int price;

    private DecemberEvent(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
