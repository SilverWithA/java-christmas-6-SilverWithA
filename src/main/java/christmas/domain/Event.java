package christmas.domain;

import christmas.constants.Menu;

public class Event {
    int PRICE_TO_GIVE_GIFT = 120000;
    boolean receivedGift = false;
    String GIFT_MENU_NAME = "샴페인";

    // 증정품
    public boolean canReceiveGift(Discount discount) {
        if (discount.getTotalAmountBeforeDiscount() >= PRICE_TO_GIVE_GIFT) {
            this.receivedGift = true;
            discount.setGiftPrice(Menu.priceOf(GIFT_MENU_NAME));
            return true;
        }
        return false;
    }

    public void badge(Discount discount) {
        int totalDiscountAmount = discount.getTotalDiscountAmount();
        if (totalDiscountAmount > 2000) {
            System.out.println("산타");
        } else if (totalDiscountAmount > 10000) {
            System.out.println("트리");
        } else if (totalDiscountAmount > 5000) {
            System.out.println("별");
        }
    }
}
