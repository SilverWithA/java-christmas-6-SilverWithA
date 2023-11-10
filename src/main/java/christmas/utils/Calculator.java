package christmas.utils;

import christmas.constants.Menu;

import java.util.Map;

public class Calculator {

    public int calculateTotalAmountBeforeDiscount(Map<String, Integer> orderMenu){
        int totalAmount = 0;
        for(String menuName : orderMenu.keySet()){
            totalAmount += Menu.menuName.getPrice() * orderMenu.get(menuName);
        }

        return totalAmount;
    }

    public String parseWonFormat(int totalAmount){
        String temp = String.valueOf(totalAmount);

        // ,와 "원" 추가하기
        return temp;
    }
}
