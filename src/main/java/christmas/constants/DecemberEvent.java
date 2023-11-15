package christmas.constants;

import org.mockito.internal.matchers.Null;

public enum DecemberEvent {

    CANT_ORDER_ONLY("음료",0,0),
    MAX_ORDER_COUNT(null,0,20),
    GIFT_MENU_NAME("샴페인", 120000,0),
    GIFT_MENU_COUNT("샴페인",1,0),
    FIRST_EVENT_BADGE("산타", 20000,0),
    SECOND_EVENT_BADGE("트리", 10000,0),
    THIRD_EVENT_BADGE("별", 5000,0),
    EVENT_BADGE_NOTHING("없음", 0,0),

    CHRISTMAS_START_AMOUNT(null,1000,0),
    CHRISTMAS_INCREASE_UNIT(null,100,0),
    SPECIAL_DISCOUNT_AMOUNT(null,1000,0),
    WEEKDAY_DISCOUNT_MENU("디저트",2023,0),
    WEEKEND_DISCOUNT_MENU("메인",2023,0);



    private final String name;
    private final int price;
    private final int count;

    private DecemberEvent(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount(){
        return count;
    }
}
