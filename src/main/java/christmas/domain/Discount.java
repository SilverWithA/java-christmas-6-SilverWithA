package christmas.domain;

import christmas.constants.Menu;
import christmas.utils.Calculator;
import christmas.view.OutputView;

import java.util.Map;

public class Discount {
    Map<String, Integer> orderMenu;
    int totalAmountBeforeDiscount;
    int PRICE_TO_GIVE_GIFT = 120000;
    String GIFT_MENU_NAME = "샴페인";
    boolean receivedGift = false;
    int giftPrice = 0;
    int christmasDistcountAmount = 0;
    int dayDistcountAmount = 0;
    int weekendDistcountAmount = 0;
    int specialDistcountAmount = 0;
    int totalDiscountAmount = 0;

    public void setOrderMenu(Map<String, Integer> orderMenu) {
        this.orderMenu = orderMenu;
    }


    // 할인 전 총 구매금액
    public void setTotalAmountBeforeDiscount(int totalAmountBeforeDiscount) {
        this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
    }

    public int getTotalAmountBeforeDiscount() {
        return this.totalAmountBeforeDiscount;
    }

    // 증정품
    public boolean canReceiveGift() {
        if (totalAmountBeforeDiscount >= PRICE_TO_GIVE_GIFT) {
            this.receivedGift = true;
            this.giftPrice = Menu.priceOf(GIFT_MENU_NAME);
            return true;
        }
        return false;
    }

    public void saveDiscountAmountAbountAllEvent(Date date) {

        setChristmasDistcountAmount(date);

        boolean weekend = date.getWeekend();

        if (weekend) {
            int discountAmount = Calculator.calculateWeekendDiscount(orderMenu);
            setWeekendDistcountAmount(discountAmount);
        } else if (!weekend) {
            int discountAmount = Calculator.calculateDayDiscount(orderMenu);
            setDayDistcountAmount(discountAmount);
        }

        setSpecialDistcountAmount(date);
        showGiftPrice();
    }

    //크리스마스 할인
    public void setChristmasDistcountAmount(Date date) {
        int christmasDistcountAmount = date.canChristmasDiscount();
        if (christmasDistcountAmount > 0) {
            this.christmasDistcountAmount = christmasDistcountAmount;
            System.out.println(String.format("크리스마스 디데이 할인: -%,d원", christmasDistcountAmount, 3));
        }
    }

    public int getChristmasDistcountAmount(){
        return this.christmasDistcountAmount;
    }

    // 주말 할인 설정
    public void setWeekendDistcountAmount(int discountAmount) {
        if (discountAmount > 0) {
            this.weekendDistcountAmount = discountAmount;
            System.out.println(String.format("주말 할인: -%,d원", weekendDistcountAmount, 3));
        }
    }


    // 평일 할인 설정
    public void setDayDistcountAmount(int discountAmount) {
                if (discountAmount > 0) {
            this.dayDistcountAmount = discountAmount;
            System.out.println(String.format("평일 할인: -%,d원", dayDistcountAmount, 3));
        }
    }


    // 특별 할인 설정 Date date
    public void setSpecialDistcountAmount(Date date) {
        int discountAmount = date.canSpecialDiscount();
        if (discountAmount > 0) {
            this.specialDistcountAmount = discountAmount;
            System.out.println(String.format("특별 할인: -%,d원", specialDistcountAmount, 3));
        }
    }

    public void showGiftPrice(){
        if(giftPrice > 0){
            System.out.println(String.format("증정 이벤트: -%,d원", giftPrice, 3));
        }
    }

    public int sumTotalDiscountAmount() {
        this.totalDiscountAmount = this.christmasDistcountAmount
                + this.dayDistcountAmount
                + this.weekendDistcountAmount
                + this.specialDistcountAmount
                + this.giftPrice;
        return this.totalDiscountAmount;
    }

    public int payAmount() {
        return totalAmountBeforeDiscount - totalDiscountAmount;
    }

    public void badge() {
        if (totalDiscountAmount > 2000) {
            System.out.println("산타");
        } else if (totalDiscountAmount > 10000) {
            System.out.println("트리");
        } else if (totalDiscountAmount > 5000) {
            System.out.println("별");
        }
    }
}
