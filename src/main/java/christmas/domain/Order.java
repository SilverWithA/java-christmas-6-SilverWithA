package christmas.domain;

import christmas.valiator.OrderValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    Map<String, Integer> orderMenu;
    String SEPERATOR = "-";
    String ERROR_UNVALIDATED_ORDER ="[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    List<String> orderMenuName = new ArrayList<>();
    List<Integer> orderMenuCount = new ArrayList<>();
    public Map<String, Integer> orderMenu(String rawInputOrder){
        String[] splitedOrderMenu = splitByComma(rawInputOrder);

        for(String order: splitedOrderMenu){
            checkOrderFormat(order);
        }

        OrderValidator.validateMenuName(orderMenuName);
        OrderValidator.validateMenuCount(orderMenuCount);

        Map<String, Integer> OrderMap = makeOrderMap(splitedOrderMenu);
        return OrderMap;
    }


    public String[] splitByComma(String rawInputOrder){
        String blankRemovedOrder = rawInputOrder.replace(" ","");
        return blankRemovedOrder.split(",");
    }

    public void checkOrderFormat(String order) {
        String[] tempOrder = splitBySeperator(order);
        isOrderconsistTwoParts(tempOrder);
        isSecondElementInteger(tempOrder);

        orderMenuName.add(tempOrder[0]);
        int eachOrderMenuCount = Integer.parseInt(tempOrder[1]);
        orderMenuCount.add(eachOrderMenuCount);
    }

    public String[] splitBySeperator(String order){
        isInSeperator(order);
        return order.split(SEPERATOR);
    }

    public void isSecondElementInteger(String[] tempOrder){
        int temp = Integer.parseInt(tempOrder[1]);
    }

    public void isInSeperator(String order){
        if(! order.contains(SEPERATOR)){
            throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
        }
    }

    public void isOrderconsistTwoParts(String[] tempOrder){
        if(tempOrder.length != 2){
            throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
        }
    }

    public  Map<String, Integer> makeOrderMap(String[] splitedOrderMenu){
        Map<String, Integer> OrderMap = new HashMap<>();

        for(String order: splitedOrderMenu){
            String[] tempOrder = splitBySeperator(order);
            int tempCount = Integer.parseInt(tempOrder[1]);
            OrderMap.put(tempOrder[0], tempCount);
        }
        return OrderMap;
    }

}
