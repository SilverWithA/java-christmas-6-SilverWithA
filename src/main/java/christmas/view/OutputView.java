package christmas.view;

import christmas.constants.DecemberEvent;

import java.util.Map;

public class OutputView {

    static String ERROR_MESSAGE_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    static String ERROR_MESSAGE_MENU = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";


    public static void viewErrorMessageDate() {
        System.out.println(ERROR_MESSAGE_DATE);
    }

    public static void viewErrorMessageMenu() {
        System.out.println(ERROR_MESSAGE_MENU);
    }

    public static void viewOrderMenuHistory(int date, Map<String, Integer> orderMenu) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");

        for (String menuName : orderMenu.keySet()) {
            System.out.println(menuName + " " + orderMenu.get(menuName) + "개");
        }
    }

    public static void viewTotalOrderAmountBeforeDiscount(int totalAmountBeforeDiscount) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", totalAmountBeforeDiscount, 3));
    }

    public static void viewGiftHistory() {
        System.out.println();
        System.out.println("<증정 메뉴>");
    }

    public static void giveGift() {
        System.out.println(DecemberEvent.GIFT_MENU_NAME.getName() + " "
                + DecemberEvent.GIFT_MENU_COUNT.getPrice() + "개");
    }

    public static void noEvnetHistory() {
        System.out.println("없음");
    }

    public static void showDiscountDetails() {
        System.out.println();
        System.out.println("<혜택 내역>");
    }

    public static void showChristmasDiscount(int christmasDistcountAmount) {
        System.out.println(String.format("크리스마스 디데이 할인: -%,d원", christmasDistcountAmount, 3));
    }

    public static void showWeekendDistcount(int weekendDistcountAmount) {
        System.out.println(String.format("주말 할인: -%,d원", weekendDistcountAmount, 3));
    }

    public static void showDayDistcount(int dayDistcountAmount) {
        System.out.println(String.format("평일 할인: -%,d원", dayDistcountAmount, 3));
    }

    public static void showSpecialDistcount(int specialDistcountAmount) {
        System.out.println(String.format("특별 할인: -%,d원", specialDistcountAmount, 3));
    }

    public static void showTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("-%,d원", totalDiscountAmount, 3));
    }

    public static void showTotalDiscountAmountNull() {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println("없음");
    }


    public static void showPayAmount(int payAmount) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", payAmount, 3));
    }


}
