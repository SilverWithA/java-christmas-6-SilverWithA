package christmas.domain;

import christmas.utils.Calculator;
import christmas.view.OutputView;

import java.util.Map;

public class Discount {
    Map<String, Integer> orderMenu;
    int totalAmountBeforeDiscount;
    int PRICE_TO_GIVE_GIFT = 120000;
    boolean receivedGift = false;
    int giftPrice = 0;
    int christmasDistcountAmount;
    int dayDistcountAmount;
    int weekendDistcountAmount;
    int specialDistcountAmount;
    int totalDiscountAmount;

    public void setOrderMenu(Map<String, Integer> orderMenu){
        this.orderMenu = orderMenu;
    }


    // 할인 전 총 구매금액
    public void setTotalAmountBeforeDiscount(int totalAmountBeforeDiscount){
        this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
    }

    // 증정품
    public void canReceiveGift(){
        if(totalAmountBeforeDiscount >= PRICE_TO_GIVE_GIFT){
            OutputView.giveGift();
            this.receivedGift = true;
            this.giftPrice = 25000;
        }else if(totalAmountBeforeDiscount < PRICE_TO_GIVE_GIFT){
            OutputView.giveGiftNull();
        }
    }

    public void saveDiscountAmountAbountAllEvent(Date date){
        //크리스마스 할인 금액 저장
        setChristmasDistcountAmount(date.canChristmasDiscount());

        // 평일-주말 할인 금액 저장
        if(date.getWeekend()){
            setWeekendDistcountAmount(Calculator.calculateWeekendDiscount(orderMenu));
        }else if(!date.getWeekend()){
            setDayDistcountAmount(Calculator.calculateWeekendDiscount(orderMenu));
        }

        // 특별 할인 금액 저장
        setSpecialDistcountAmount(date.canSpecialDiscount());

        // 증정 이벤트
        System.out.println(String.format("증정 이벤트: -%,d원",giftPrice, 3));
    }

    //크리스마스 할인
    public void setChristmasDistcountAmount(int christmasDistcountAmount){
        this.christmasDistcountAmount = christmasDistcountAmount;
        System.out.println(String.format("크리스마스 디데이 할인: - %,d원", christmasDistcountAmount, 3));
    }

    // 평일 할인 설정
    public void setDayDistcountAmount(int discountAmount){
        this.dayDistcountAmount = discountAmount;
        System.out.println(String.format("평일 할인: -%,d원",dayDistcountAmount, 3));

    }
    // 주말 할인 설정
    public void setWeekendDistcountAmount(int discountAmount){
        this.weekendDistcountAmount = discountAmount;
        System.out.println(String.format("주말 할인: -%,d원",weekendDistcountAmount, 3));
    }
    // 특별 할인 설정
    public void setSpecialDistcountAmount(int discountAmount){
        this.specialDistcountAmount = discountAmount;
        System.out.println(String.format("특별 할인: -%,d원",specialDistcountAmount, 3));
    }

    public int totalDiscountAmount(){
        this.totalDiscountAmount = this.christmasDistcountAmount
                + this.dayDistcountAmount
                + this.weekendDistcountAmount
                + this.specialDistcountAmount
                + this.giftPrice;
        return this.totalDiscountAmount;
    }

    public int payAmount(){
        return totalAmountBeforeDiscount - totalDiscountAmount;
    }

    public void badge(){
        if(totalDiscountAmount > 2000){
            System.out.println("산타");
        }else if(totalDiscountAmount > 10000){
            System.out.println("트리");
        }else if(totalDiscountAmount > 5000){
            System.out.println("별");
        }
    }
}
