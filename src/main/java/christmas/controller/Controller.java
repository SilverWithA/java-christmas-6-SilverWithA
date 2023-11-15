package christmas.controller;


import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.utils.Calculator;
import christmas.view.InputView;
import christmas.view.OutputView;


public class Controller {

    Date date = new Date();
    Order order = new Order();
    Discount discount = new Discount();
    Event event = new Event();

    public void DecemberEventStart() {
        askVistitDate();
        askOrderMenu();
        showOrderMenu();

        showTotalOrderAmount();
        showGiftMenu();

        showDiscountDetails();
        showTotalDiscountAmount();

        showPayAmounAfterDiscountt();
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
        date.setVistitDate(vistitDate);
    }

    // ---------------------------------------------


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
        OutputView.viewOrderMenuHistory(date.getVisitdate(), order.getOrderMenu());
    }

    public void showTotalOrderAmount() {
        int totalAmount = Calculator.calculateTotalAmount(order.getOrderMenu());
        discount.setTotalAmount(totalAmount);
        OutputView.viewTotalOrderAmount(totalAmount);
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
        OutputView.viewDiscountDetailsTitle();
        event.applyDiscountAbountAllEvent(discount, date, order);

        boolean eventBenefits = event.getEventBenefits();
        if(!eventBenefits){
            OutputView.noEvnetHistory();
        }

    }



    public void showTotalDiscountAmount() {
        int totalDiscountAmount = discount.getTotalDiscountAmount();
        OutputView.viewTotalDiscountAmountTitle();

        if(totalDiscountAmount > 0){
            OutputView.viewTotalDiscountAmount(totalDiscountAmount);
        }else if(totalDiscountAmount == 0){
            OutputView.noEvnetHistory();
        }
    }

    public void showPayAmounAfterDiscountt() {
        int payAmountAfterDiscount = discount.calculatePayAmountAfterDiscount();
        OutputView.viewPayAmountAfterDiscount(payAmountAfterDiscount);
    }

    public void showEventBadage() {
        int totalDiscountAmount = discount.getTotalDiscountAmount();
        OutputView.viewEventBadgeTitle();
        OutputView.viewEventBadge(totalDiscountAmount);
    }
}
