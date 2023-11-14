package christmas.controller;


import christmas.domain.Date;
import christmas.domain.Event;
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
                OutputView.viewErrorMessageDate();
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
                OutputView.viewErrorMessageMenu();
            }
        }
    }

    public void checkOrder(String MenuBeforeSplit) {
        order.validateOrder(MenuBeforeSplit);
    }


    public void showOrderMenu() {
        OutputView.viewOrderMenuHistory(date.getDate(), order.getOrderMenu());
    }

    public void showTotalOrderAmountBeforeDiscount() {
        int totalAmountBeforeDiscount = order.totalAmountOrder();
        discount.setTotalAmountBeforeDiscount(totalAmountBeforeDiscount);
        OutputView.viewTotalOrderAmountBeforeDiscount(totalAmountBeforeDiscount);
    }
    public void showGiftMenu() {
        boolean gift = event.canReceiveGift(discount);
        OutputView.viewGiftHistory();
        if (gift) {
            OutputView.giveGift();
        } else if (!gift) {
            OutputView.noEvnetHistory();
        }
    }


    public void showDiscountDetails() {
        OutputView.showDiscountDetails();
        event.saveDiscountAmountAbountAllEvent(discount, date, order);
    }



    public void showTotalDiscountAmount() {
        int totalDiscountAmount = discount.sumTotalDiscountAmount();

        if(totalDiscountAmount > 0){
            OutputView.showTotalDiscountAmount(totalDiscountAmount);
        }else if(totalDiscountAmount == 0){
            OutputView.showTotalDiscountAmountNull();
        }
    }

    public void showPayAmount() {
        int payAmount = discount.calculatePayAmount();
        OutputView.showPayAmount(payAmount);
    }

    public void showEventBadage() {
        event.showEventBadge(discount);
    }
}
