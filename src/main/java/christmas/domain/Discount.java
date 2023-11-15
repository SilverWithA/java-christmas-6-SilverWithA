package christmas.domain;

import christmas.constants.Menu;
import christmas.utils.Calculator;
import christmas.view.OutputView;

import java.util.Map;

public class Discount {
    int totalAmount;
    int giftPrice = 0;
    int christmasDistcountAmount = 0;
    int dayDistcountAmount = 0;
    int weekendDistcountAmount = 0;
    int specialDistcountAmount = 0;
    int totalDiscountAmount = 0;


    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    public void setGiftPrice(int giftPrice){
        this.giftPrice = giftPrice;
    }


    //크리스마스 할인
    public void setChristmasDistcountAmount(Date date) {
        int christmasDistcountAmount = date.canChristmasDiscount();
        if (christmasDistcountAmount > 0) {
            this.christmasDistcountAmount = christmasDistcountAmount;
            OutputView.viewChristmasDiscount(christmasDistcountAmount);
        }
    }

    public int getChristmasDistcountAmount(){
        return this.christmasDistcountAmount;
    }

    // 주말 할인 설정
    public void setWeekendDistcountAmount(int discountAmount) {
        if (discountAmount > 0) {
            this.weekendDistcountAmount = discountAmount;
            OutputView.viewWeekendDistcount(discountAmount);
        }
    }

    public int getWeekendDistcountAmount(){
        return this.weekendDistcountAmount;
    }


    // 평일 할인 설정
    public void setDayDistcountAmount(int discountAmount) {
                if (discountAmount > 0) {
            this.dayDistcountAmount = discountAmount;
            OutputView.viewDayDistcount(discountAmount);
        }
    }

    // 특별 할인 설정
    public void setSpecialDistcountAmount(Date date) {
        int discountAmount = date.canSpecialDiscount();
        if (discountAmount > 0) {
            this.specialDistcountAmount = discountAmount;
            OutputView.viewSpecialDistcount(discountAmount);
        }
    }

    public void showGiftPrice(){
        if(giftPrice > 0){
            OutputView.viewGiftEvent(giftPrice);
        }
    }

    public void sumTotalDiscountAmount() {
        this.totalDiscountAmount = christmasDistcountAmount
                + dayDistcountAmount + weekendDistcountAmount
                + specialDistcountAmount + giftPrice;
    }

    public int calculatePayAmountAfterDiscount() {
        return totalAmount - totalDiscountAmount + giftPrice;
    }

    public int getTotalDiscountAmount(){
        return this.totalDiscountAmount;
    }

}
