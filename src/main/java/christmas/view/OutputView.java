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

    public static void viewTotalOrderAmount(int totalAmountBeforeDiscount) {
        System.out.println();
        System.out.println(Message.TOTAL_ORDER_AMOUNT.getMessgae());
        System.out.println(String.format("%,d원", totalAmountBeforeDiscount, 3));
    }

    public static void viewGiftHistory() {
        System.out.println();
        System.out.println(Message.GIFT_HISTORY.getMessgae());
    }

    public static void giveGift() {
        System.out.println(DecemberEvent.GIFT_MENU.getName() + " "
                + DecemberEvent.GIFT_MENU.getCount() + "개");
    }

    public static void noEvnetHistory() {
        System.out.println(Message.NOTHING.getMessgae());
    }

    public static void viewDiscountDetailsTitle() {
        System.out.println();
        System.out.println(Message.EVENT_HISTORY.getMessgae());
    }

    public static void viewChristmasDiscount(int christmasDistcountAmount) {
        System.out.println(String.format(Message.CHRISTMAS_AMOUNT.getMessgae(), christmasDistcountAmount, 3));
    }

    public static void viewWeekendDistcount(int weekendDistcountAmount) {
        System.out.println(String.format(Message.WEEKEND_AMOUNT.getMessgae(), weekendDistcountAmount, 3));
    }

    public static void viewDayDistcount(int dayDistcountAmount) {
        System.out.println(String.format(Message.WEEKDAY_AMOUNT.getMessgae(), dayDistcountAmount, 3));
    }

    public static void viewSpecialDistcount(int specialDistcountAmount) {
        System.out.println(String.format(Message.SPECIAL_AMOUNT.getMessgae(), specialDistcountAmount, 3));
    }

    public static void viewGiftEvent(int specialDistcountAmount) {
        System.out.println(String.format(Message.GIFT_EVENT.getMessgae(), specialDistcountAmount, 3));
    }

    public static void viewTotalDiscountAmountTitle() {
        System.out.println();
        System.out.println(Message.TOTAL_BENEFITS_AMOUNT.getMessgae());
    }

    public static void viewTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println(String.format("-%,d원", totalDiscountAmount, 3));
    }



    public static void viewPayAmountAfterDiscount(int payAmount) {
        System.out.println();
        System.out.println(Message.PAY_AMOUNT_AFTER_DISCOUNT.getMessgae());
        System.out.println(String.format("%,d원", payAmount, 3));
    }

    public static void viewEventBadgeTitle(){
        System.out.println();
        System.out.println(Message.EVENT_BADGE.getMessgae());
    }
    public static void viewEventBadge(int totalDiscountAmount){
        if (totalDiscountAmount > DecemberEvent.FIRST_EVENT_BADGE.getPrice()) {
            System.out.println(DecemberEvent.FIRST_EVENT_BADGE.getName());

        } else if (totalDiscountAmount > DecemberEvent.SECOND_EVENT_BADGE.getPrice()) {
            System.out.println(DecemberEvent.SECOND_EVENT_BADGE.getName());

        } else if (totalDiscountAmount > DecemberEvent.THIRD_EVENT_BADGE.getPrice()) {
            System.out.println(DecemberEvent.THIRD_EVENT_BADGE.getName());

        } else if (totalDiscountAmount == DecemberEvent.EVENT_BADGE_NOTHING.getPrice()) {
            System.out.println(DecemberEvent.EVENT_BADGE_NOTHING.getName());
        }
    }

}
