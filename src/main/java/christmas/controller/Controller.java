package christmas.controller;

import christmas.domain.CustomerMenu;
import christmas.utils.Calculator;
import christmas.domain.Discount;
import christmas.valiator.DateValiator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.awt.*;
import java.util.Map;

public class Controller {
    Map<String, Integer> orderMenu;
    int totalAmountBeforeDiscount;
    boolean gift;
    Discount discount = new Discount(); //할인 정보 관리 클래스
    CustomerMenu customerMenu = new CustomerMenu();// Menu menu = new Menu();

    public void evenStart(){
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
    public void askVistitDate(){
        while(true){
            try{
                //숫자형 확인
                int vistitDate = Integer.parseInt(InputView.requestVisitDate());
                //범위수 확인
                DateValiator.isInRange(vistitDate);
                //맞으면 날짜 정보 저장
                discount.setDate(vistitDate);
                break;
            }catch(IllegalArgumentException e){
                OutputView.ERROR_MESSAGE(ERROR_MESSAGE_DATE);
            }
        }
    }
    public void askOrderMenu(){
        while(true) {
            try {
                String MenuBeforeSplit = InputView.requestOrdringMenu();
                this.orderMenu = customerMenu.orderMenu(MenuBeforeSplit);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.ERROR_MESSAGE(ERROR_MESSAGE_MENU);
            }
        }
    }
    public void showOrderMenu(){
        OutputView.showOrderMenuHistory(orderMenu);
    }

    public void showTotalOrderAmountBeforeDiscount(){
        Calculator calculator = new Calculator();
        this.totalAmountBeforeDiscount = calculator.calculateTotalAmountBeforeDiscount(orderMenu);
        String wonFormatTotalAmount = calculator.parseWonFormat(totalAmountBeforeDiscount);
        OutputView.showTotalAmountBeforeDiscount(wonFormatTotalAmount);
    }
    public void showGiftMenu(){
        if(totalAmountBeforeDiscount >= PRICE_TO_GIVE_GIFT){
            OutputView.giveGift();
            this.gift = true;
        }else if(totalAmountBeforeDiscount < PRICE_TO_GIVE_GIFT){
            OutputView.giveGiftNull();
            this.gift = false;
        }
    }

}
