package christmas.constants;

import org.mockito.internal.matchers.Null;

public enum DecemberEvent {
    GIFT_MENU_NAME("샴페인", 120000),
    GIFT_MENU_COUNT("샴페인",1),
    FIRST_EVENT_BADGE("산타", 20000),
    SECOND_EVENT_BADGE("트리", 10000),
    THIRD_EVENT_BADGE("별", 5000),
    EVENT_BADGE_NOTHING("없음", 0);

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
