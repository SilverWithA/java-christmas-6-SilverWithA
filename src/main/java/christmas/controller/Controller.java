package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.utils.Calculator;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.valiator.DateValiator;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.mockito.internal.util.ConsoleMockitoLogger;

import java.util.Map;

public class Controller {
    Map<String, Integer> orderMenu;

    Date date = new Date();
    Discount discount = new Discount();
    Order order = new Order();

    public void evenStart(){
        String inputDate = InputView.requestVisitDate();
        askVistitDate(inputDate);

        askOrderMenu();
        showOrderMenu();
        showTotalOrderAmountBeforeDiscount();
        showGiftMenu();

        discountDetails();
        showTotalDiscountAmount();
        showPayAmount();
        showEventBadage();
    }
    public void askVistitDate(String inputDate){
        while(true){
            try{
                int vistitDate = Integer.parseInt(inputDate);
                DateValiator.isInRange(vistitDate);
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
