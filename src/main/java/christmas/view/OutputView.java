package christmas.view;

import java.util.Map;

public class OutputView {

    static String ERROR_MESSAGE_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    static String ERROR_MESSAGE_MENU = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";


    public static void showErrorMessageDate() {
        System.out.println(ERROR_MESSAGE_DATE);
    }

    public static void showErrorMessageMenu() {
        System.out.println(ERROR_MESSAGE_MENU);
    }

    public static void showOrderMenuHistory(int date, Map<String, Integer> orderMenu) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (String menuName : orderMenu.keySet()) {
            System.out.println(menuName + " " + orderMenu.get(menuName) + "개");
        }
    }

    public static void TotalOrderAmountBeforeDiscount(int totalAmountBeforeDiscount) {
        System.out.println();
        System.out.println("<할인 전 총 주문금액>");
        System.out.println(String.format("%,d원", totalAmountBeforeDiscount, 3));
    }

    public static void giveGift() {
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println("샴페인 1개");
    }

    public static void giveGiftNull() {
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println("없음");
    }

    public static void showDiscountDetails() {
        System.out.println("<혜택 내역>");
    }

    public static void showTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("-%,d원", totalDiscountAmount, 3));
    }

    public static void showPayAmount(int payAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("-%,d원", payAmount, 3));
    }


}
