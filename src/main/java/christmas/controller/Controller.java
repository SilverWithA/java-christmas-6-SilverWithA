package christmas.controller;


import christmas.domain.Date;
import christmas.utils.Calculator;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Controller {
    Map<String, Integer> orderMenu;
    String orderDate;

    Date date = new Date();
    Order order = new Order();
    Discount discount = new Discount();

    public void evenStart() {
        askVistitDate();
        askOrderMenu();
        showOrderMenu();
        showTotalOrderAmountBeforeDiscount();
        showGiftMenu();
//
//        discountDetails();
//        showTotalDiscountAmount();
//        showPayAmount();
//        showEventBadage();
        }

        public void askVistitDate(){
            while (true) {
                try {
                    String inputDate = InputView.requestVisitDate();
                    checkValidationVistitDate(inputDate);
                    this.orderDate = inputDate;
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.showErrorMessageDate();
                }
            }
        }

        public void checkValidationVistitDate (String inputDate){
            int vistitDate = Integer.parseInt(inputDate);
            date.isInRange(vistitDate);
            date.setDate(vistitDate);
        }


        public void askOrderMenu () {
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

        public void checkOrder(String MenuBeforeSplit){
            order.validateOrder(MenuBeforeSplit);
        }


        public void showOrderMenu () {
            OutputView.showOrderMenuHistory(date.getDate(), order.getOrderMenu());
        }

        public void showTotalOrderAmountBeforeDiscount () {
            int totalAmountBeforeDiscount = order.totalAmountOrder();
            discount.setTotalAmountBeforeDiscount(totalAmountBeforeDiscount);
            OutputView.TotalOrderAmountBeforeDiscount(totalAmountBeforeDiscount);
        }

        // ------------------------------------------------------------------------
        public void showGiftMenu () {
            boolean gift = discount.canReceiveGift();
            if (gift) {
                OutputView.giveGift();
            } else if (!gift) {
                OutputView.giveGiftNull();
            }
        }


        public void discountDetails () {
            OutputView.showDiscountDetails();
            discount.saveDiscountAmountAbountAllEvent(date);
        }

        public void showTotalDiscountAmount () {
            int totalDiscountAmount = discount.totalDiscountAmount();
            OutputView.showTotalDiscountAmount(totalDiscountAmount);
        }
        public void showPayAmount () {
            int payAmount = discount.payAmount();
            OutputView.showPayAmount(payAmount);
        }

        public void showEventBadage () {
            discount.badge();
        }
    }
