package christmas.constants;

public enum Message {

    START_EVEN_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ERROR_MESSAGE_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_MESSAGE_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ORDER_MENU_HISTORY("<주문 메뉴>"),
    TOTAL_ORDER_AMOUNT("<할인 전 총주문 금액>"),
    GIFT_HISTORY("<증정 메뉴>"),
    NOTHING("없음"),
    EVENT_HISTORY("<혜택 내역>"),
    CHRISTMAS_AMOUNT("크리스마스 디데이 할인: -%,d원"),
    WEEKEND_AMOUNT("주말 할인: -%,d원"),
    WEEKDAY_AMOUNT("평일 할인: -%,d원"),
    SPECIAL_AMOUNT("특별 할인: -%,d원"),
    GIFT_EVENT("증정 이벤트: -%,d원"),
    TOTAL_BENEFITS_AMOUNT("<총혜택 금액>"),
    PAY_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),

    EVENT_BADGE("<12월 이벤트 배지>");


     private final String messgae;
    private Message(String messgae){
        this.messgae = messgae;
    }

    public String getMessgae(){
        return this.messgae;
    }
}
