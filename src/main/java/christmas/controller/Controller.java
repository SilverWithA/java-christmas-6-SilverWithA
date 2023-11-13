package christmas.controller;

import christmas.domain.Date;
import christmas.utils.Calculator;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.valiator.DateValiator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Controller {
    Map<String, Integer> orderMenu;

    Date date = new Date();
    Discount discount = new Discount();
    Order order = new Order();

    public void evenStart(){
        askVistitDate();
        askOrderMenu();
        showOrderMenu();
        showTotalOrderAmountBeforeDiscount();
        showGiftMenu();

        discountDetails();
        showTotalDiscountAmount();
        showPayAmount();
        showEventBadage();
    }
    public void askVistitDate(){
        while(true){
            try{
                //숫자형 확인 -> 아닐시 에러
                int vistitDate = Integer.parseInt(InputView.requestVisitDate());
                //범위수 확인
                DateValiator.isInRange(vistitDate);
                //맞으면 날짜 정보 저장
                date.setDate(vistitDate);
                break;
            }catch(IllegalArgumentException e){
                OutputView.showErrorMessageDate();
            }
        }
    }

    public void askOrderMenu(){
        while(true) {
            try {
                String MenuBeforeSplit = InputView.requestVisitDate();
                this.orderMenu = order.orderMenu(MenuBeforeSplit);
                discount.setOrderMenu(this.orderMenu);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessageMenu();
            }
        }
    }
    public void showOrderMenu(){
        OutputView.showOrderMenuHistory(orderMenu);
    }

    public void showTotalOrderAmountBeforeDiscount(){
        int totalAmountBeforeDiscount = Calculator.calculateTotalAmountBeforeDiscount(orderMenu);
        discount.setTotalAmountBeforeDiscount(totalAmountBeforeDiscount);
        OutputView.TotalOrderAmountBeforeDiscount(totalAmountBeforeDiscount);
    }

    public void showGiftMenu(){
        discount.canReceiveGift();
    }


    public void discountDetails(){
        OutputView.showDiscountDetails();
        discount.saveDiscountAmountAbountAllEvent(date);
    }

    public void showTotalDiscountAmount() {
        int totalDiscountAmount = discount.totalDiscountAmount();
        OutputView.showTotalDiscountAmount(totalDiscountAmount);
    }
    // ------------------------------------------------------------------------
    public void showPayAmount(){
        int payAmount = discount.payAmount();
        OutputView.showPayAmount(payAmount);
    }

    public void showEventBadage(){
        discount.badge();
    }
}
