package christmas.domain;

import christmas.constants.DecemberEvent;
import christmas.constants.Menu;
import christmas.utils.Calculator;

import java.util.Map;

public class Event {

    boolean receivedGift = false;
    boolean eventBenefits = false;
    int PRICE_TO_GIVE_GIFT = DecemberEvent.GIFT_MENU.getPrice();
    String GIFT_MENU_NAME = DecemberEvent.GIFT_MENU.getName();

    public boolean getEventBenefits() {
        return this.eventBenefits;
    }

    // 증정품 증정 여부 판단
    public boolean canReceiveGift(Discount discount) {
        if (discount.getTotalAmount() >= PRICE_TO_GIVE_GIFT) {
            this.receivedGift = true;
            discount.setGiftPrice(Menu.priceOf(GIFT_MENU_NAME));
            return true;
        }
        return false;
    }

    // 모든 혜택 금액 계산 및 설정
    public void applyDiscountAbountAllEvent(Discount discount, Date date, Order order) {
        discount.setChristmasDistcountAmount(date);
        setDateDiscount(discount, date, order);
        discount.setSpecialDistcountAmount(date);
        discount.showGiftPrice();

        checkThereIsEventBenefits(discount);
    }


    public void setDateDiscount(Discount discount, Date date, Order order) {
        boolean weekend = date.getWeekendOrNot();
        Map<String, Integer> orderMenu = order.getOrderMenu();

        if (weekend) {
            int discountAmount = Calculator.calculateWeekendDiscount(orderMenu);
            discount.setWeekendDistcountAmount(discountAmount);
        } else if (!weekend) {
            int discountAmount = Calculator.calculateDayDiscount(orderMenu);
            discount.setDayDistcountAmount(discountAmount);
        }
    }

    public void checkThereIsEventBenefits(Discount discount) {
        discount.sumTotalDiscountAmount();

        if (discount.getTotalDiscountAmount() > 0) {
            this.eventBenefits = true;
        } else if (discount.getTotalDiscountAmount() == 0) {
            this.eventBenefits = false;
        }
    }

}
