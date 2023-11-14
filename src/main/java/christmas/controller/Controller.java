package christmas.controller;


import christmas.domain.Date;
import christmas.domain.Event;
import christmas.utils.Calculator;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Controller {
    Date date = new Date();
    Order order = new Order();
    Discount discount = new Discount();
    Event event = new Event();

    public void evenStart() {
        askVistitDate();
        askOrderMenu();
        showOrderMenu();
        showTotalOrderAmountBeforeDiscount();
        showGiftMenu();
        showDiscountDetails();
        showTotalDiscountAmount();
        showPayAmount();
        showEventBadage();
    }

    public void askVistitDate() {
        while (true) {
            try {
                String inputDate = InputView.requestVisitDate();
                checkValidationVistitDate(inputDate);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessageDate();
            }
        }
    }

    public void checkValidationVistitDate(String inputDate) {
        int vistitDate = Integer.parseInt(inputDate);
        date.isInRange(vistitDate);
        date.setDate(vistitDate);
    }


    public void askOrderMenu() {
        while (true) {
            try {
                String MenuBeforeSplit = InputView.requestOrderMenu();
                checkOrder(MenuBeforeSplit);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.showErrorMessageMenu();
            }
        }
    }

    public void checkOrder(String MenuBeforeSplit) {
        order.validateOrder(MenuBeforeSplit);
    }


    public void showOrderMenu() {
        OutputView.showOrderMenuHistory(date.getDate(), order.getOrderMenu());
    }

    public void showTotalOrderAmountBeforeDiscount() {
        int totalAmountBeforeDiscount = order.totalAmountOrder();
        discount.setTotalAmountBeforeDiscount(totalAmountBeforeDiscount);
        OutputView.TotalOrderAmountBeforeDiscount(totalAmountBeforeDiscount);
    }
    public void showGiftMenu() {
        boolean gift = event.canReceiveGift(discount);
        if (gift) {
            OutputView.giveGift();
        } else if (!gift) {
            OutputView.giveGiftNull();
        }
    }


    public void showDiscountDetails() {
        OutputView.showDiscountDetails();
        discount.saveDiscountAmountAbountAllEvent(date, order);
    }



    public void showTotalDiscountAmount() {
        int totalDiscountAmount = discount.sumTotalDiscountAmount();

        if(totalDiscountAmount > 0){
            OutputView.showTotalDiscountAmount(totalDiscountAmount);
        }else if(totalDiscountAmount == 0){
            OutputView.showTotalDiscountAmountNull();
        }
    }
    // -----------------------------------------
    public void showPayAmount() {
        int payAmount = discount.calculatePayAmount();
        OutputView.showPayAmount(payAmount);
    }

    public void showEventBadage() {
        event.badge(discount);
    }
}
