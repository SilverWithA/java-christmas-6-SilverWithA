package christmas.utils;

import christmas.constants.DecemberEvent;
import christmas.constants.EventMonthCalender;
import christmas.constants.Menu;

import java.util.Map;

public class Calculator {



    public static int calculateTotalAmount(Map<String, Integer> orderMenu){
        int totalAmount = 0;

        for(String orderName : orderMenu.keySet()){
            int orderCount = orderMenu.get(orderName);
            totalAmount += (Menu.priceOf(orderName) * orderCount);
            }

        return totalAmount;
        }

     public static int calculateChristmasDistcount(int date) {
        int christmasDistcountAmount = 0;
        if (date < EventMonthCalender.CHIRSTMAS_DAY.getDay() + 1) {
            christmasDistcountAmount +=  DecemberEvent.CHRISTMAS_START_AMOUNT.getPrice()
                    + (DecemberEvent.CHRISTMAS_INCREASE_UNIT.getPrice() * (date - 1));
        }
        return christmasDistcountAmount;
    }

    public static int calculateWeekendDiscount(Map<String, Integer> orderMenu){
        int discountAmount = 0;
        for(String menu : orderMenu.keySet()){
            if(isMain(menu)){
                discountAmount += (DecemberEvent.WEEKEND_DISCOUNT_MENU.getPrice() * orderMenu.get(menu));
            }
        }
        return discountAmount;

    }

    public static boolean isMain(String menu){
        if(Menu.typeOf(menu) == DecemberEvent.WEEKEND_DISCOUNT_MENU.getName()) {
            return true;
        }
        return false;
    }

    public static int calculateDayDiscount(Map<String, Integer> orderMenu){
        int discountAmount = 0;
        for(String menu : orderMenu.keySet()){
            if(isDesert(menu)){
                discountAmount += (DecemberEvent.WEEKDAY_DISCOUNT_MENU.getPrice() * orderMenu.get(menu));
            }
        }
        return discountAmount;
    }

    public static boolean isDesert(String menu){
        if(Menu.typeOf(menu) == DecemberEvent.WEEKDAY_DISCOUNT_MENU.getName()) {
            return true;
        }
        return false;
    }


    public static int calculateSpecialDiscount(boolean specialDay){
        int discountAmount = 0;
        if(specialDay){
            discountAmount += DecemberEvent.SPECIAL_DISCOUNT_AMOUNT.getPrice();
        }
        return discountAmount;
    }

}
