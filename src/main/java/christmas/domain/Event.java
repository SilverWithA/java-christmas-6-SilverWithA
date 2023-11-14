package christmas.domain;

import christmas.constants.DecemberEvent;
import christmas.constants.Menu;
import christmas.utils.Calculator;
import christmas.view.OutputView;

import java.util.Map;

public class Event {

    boolean receivedGift = false;
    int PRICE_TO_GIVE_GIFT = DecemberEvent.GIFT_MENU_NAME.getPrice();
    String GIFT_MENU_NAME = DecemberEvent.GIFT_MENU_NAME.getName();
    String EVENT_BADGE_FIRST = DecemberEvent.EVENT_BADGE_FIRST.getName();
    String EVENT_BADGE_SECOND = DecemberEvent.EVENT_BADGE_SECOND.getName();
    String EVENT_BADGE_THIRD = DecemberEvent.EVENT_BADGE_THIRD.getName();
    String EVENT_BADGE_NOTHING = DecemberEvent.EVENT_BADGE_NOTHING.getName();
    int EVENT_BADGE_FIRST_PRICE = DecemberEvent.EVENT_BADGE_FIRST.getPrice();
    int EVENT_BADGE_SECOND_PRICE = DecemberEvent.EVENT_BADGE_SECOND.getPrice();
    int EVENT_BADGE_THIRD_PRICE = DecemberEvent.EVENT_BADGE_THIRD.getPrice();
    int EVENT_BADGE_NOTHING_PRICE = DecemberEvent.EVENT_BADGE_NOTHING.getPrice();


    // 증정품
    public boolean canReceiveGift(Discount discount) {
        if (discount.getTotalAmountBeforeDiscount() >= PRICE_TO_GIVE_GIFT) {
            this.receivedGift = true;
            discount.setGiftPrice(Menu.priceOf(GIFT_MENU_NAME));
            return true;
        }
        return false;
    }

    // 모든 할인 금액 설정
    public void saveDiscountAmountAbountAllEvent(Discount discount, Date date, Order order) {
        discount.setChristmasDistcountAmount(date);
        setDateDiscount(discount, date, order);
        discount.setSpecialDistcountAmount(date);
        checkThereIsEvent(discount);
    }



    public void setDateDiscount(Discount discount, Date date, Order order) {
        boolean weekend = date.getWeekend();
        Map<String, Integer> orderMenu = order.getOrderMenu();

        if (weekend) {
            int discountAmount = Calculator.calculateWeekendDiscount(orderMenu);
            discount.setWeekendDistcountAmount(discountAmount);
        } else if (!weekend) {
            int discountAmount = Calculator.calculateDayDiscount(orderMenu);
            discount.setDayDistcountAmount(discountAmount);
        }
    }

    public void checkThereIsEvent(Discount discount) {
        if (discount.getTotalDiscountAmount() == 0) {
            OutputView.noEvnetHistory();
        } else if (discount.getTotalDiscountAmount() > 0) {
            discount.showGiftPrice();
        }
    }


    public void showEventBadge(Discount discount) {
        int totalDiscountAmount = discount.getTotalDiscountAmount();
        System.out.println();
        System.out.println("<12월 이벤트 배지>");

        if (totalDiscountAmount > EVENT_BADGE_FIRST_PRICE) {
            System.out.println(EVENT_BADGE_FIRST);

        } else if (totalDiscountAmount > EVENT_BADGE_SECOND_PRICE) {
            System.out.println(EVENT_BADGE_SECOND);

        } else if (totalDiscountAmount > EVENT_BADGE_THIRD_PRICE) {
            System.out.println(EVENT_BADGE_THIRD);

        } else if (totalDiscountAmount == EVENT_BADGE_NOTHING_PRICE) {
            System.out.println(EVENT_BADGE_NOTHING);
        }
    }
}
