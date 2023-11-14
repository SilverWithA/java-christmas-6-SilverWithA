package christmas.utils;

import christmas.constants.Menu;

import java.util.Arrays;
import java.util.Map;

public class Calculator {



    //할인 전 총 구매금액
    public static int calculateTotalAmountBeforeDiscount(Map<String, Integer> orderMenu){
        int totalAmount = 0;
        for(String orderName : orderMenu.keySet()){
            int orderCount = orderMenu.get(orderName);
            totalAmount += (Menu.priceOf(orderName) * orderCount);
            }
        return totalAmount;
        }



    // 크리스마스 할인 계산
     public static int calculateChristmasDistcount(int date) {
        int christmasDistcountAmount = 0;
        if (date < 26) {
            christmasDistcountAmount +=  1000 + (100 * (date - 1));
        }
        return christmasDistcountAmount;
    }

    // 평일 할인 계산
    public static int calculateDayDiscount(Map<String, Integer> orderMenu){
        int discountAmount = 0;
        for(String menu : orderMenu.keySet()){
            if(isDesert(menu)){
                discountAmount += 2023;
            }
        }
        return discountAmount;
    }

    private static boolean isDesert(String menu){
        boolean answer = false;
        if(Menu.typeOf(menu) == "디저트") {
            answer = true;
        }
        return answer;
    }

    public static int calculateWeekendDiscount(Map<String, Integer> orderMenu){
        int discountAmount = 0;
        for(String menu : orderMenu.keySet()){
            if(isMain(menu)){
                discountAmount += 2023;
            }
        }
        return discountAmount;

    }

    private static boolean isMain(String menu){
        boolean answer = false;
        if(Menu.typeOf(menu) == "메인") {
            answer = true;
        }
        return answer;
    }

    public static int calculateSpecialDiscount(boolean specialDay){
        int discountAmount = 0;
        if(specialDay){
            discountAmount += 1000;
        }
        return discountAmount;
    }

}
