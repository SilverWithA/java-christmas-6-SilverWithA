package christmas.view;

import christmas.constants.DecemberEvent;
import christmas.constants.Message;

import java.util.Map;

public class OutputView {


    public static void viewErrorMessageDate() {
        System.out.println(Message.ERROR_MESSAGE_DATE.getMessgae());
    }

    public static void viewErrorMessageMenu() {
        System.out.println(Message.ERROR_MESSAGE_MENU.getMessgae());
    }

    public static void viewOrderMenuHistory(int date, Map<String, Integer> orderMenu) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println(Message.ORDER_MENU_HISTORY.getMessgae());

        for (String menuName : orderMenu.keySet()) {
            System.out.println(menuName + " " + orderMenu.get(menuName) + "개");
        }
    }

    public static void viewTotalOrderAmountBeforeDiscount(int totalAmountBeforeDiscount) {
        System.out.println();
        System.out.println(Message.TOTAL_ORDER_AMOUNT.getMessgae());
        System.out.println(String.format("%,d원", totalAmountBeforeDiscount, 3));
    }

    public static void viewGiftHistory() {
        System.out.println();
        System.out.println(Message.GIFT_HISTORY.getMessgae());
    }

    public static void giveGift() {
        System.out.println(DecemberEvent.GIFT_MENU_NAME.getName() + " "
                + DecemberEvent.GIFT_MENU_COUNT.getPrice() + "개");
    }

    public static void noEvnetHistory() {
        System.out.println(Message.NOTHING.getMessgae());
    }

    public static void viewDiscountDetails() {
        System.out.println();
        System.out.println(Message.EVENT_HISTORY.getMessgae());
    }

    public static void viewChristmasDiscount(int christmasDistcountAmount) {
        System.out.println(String.format("크리스마스 디데이 할인: -%,d원", christmasDistcountAmount, 3));
    }

    public static void viewWeekendDistcount(int weekendDistcountAmount) {
        System.out.println(String.format("주말 할인: -%,d원", weekendDistcountAmount, 3));
    }

    public static void viewDayDistcount(int dayDistcountAmount) {
        System.out.println(String.format("평일 할인: -%,d원", dayDistcountAmount, 3));
    }

    public static void viewSpecialDistcount(int specialDistcountAmount) {
        System.out.println(String.format("특별 할인: -%,d원", specialDistcountAmount, 3));
    }

    public static void viewTotalDiscountAmountTitle() {
        System.out.println();
        System.out.println(Message.TOTAL_BENEFITS_AMOUNT.getMessgae());
    }

    public static void viewTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println(String.format("-%,d원", totalDiscountAmount, 3));
    }



    public static void viewPayAmount(int payAmount) {
        System.out.println();
        System.out.println(Message.PAY_AMOUNT_AFTER_DISCOUNT.getMessgae());
        System.out.println(String.format("%,d원", payAmount, 3));
    }


}
