package christmas.domain;

import christmas.utils.Calculator;
import christmas.valiator.OrderValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    Map<String, Integer> orderMenu;
    String SEPERATOR = "-";

    List<String> orderMenuName;
    List<Integer> orderMenuCount;


    public Map<String, Integer> getOrderMenu() {
        return this.orderMenu;
    }

    // 입력한 주문의 유효성 확인
    public void validateOrder(String rawInputOrder) {
        initOrderMenu();
        checkOrderFormat(rawInputOrder);

        OrderValidator.validateMenuName(orderMenuName);
        OrderValidator.validateMenuCount(orderMenuCount);

        Map<String, Integer> OrderMap = arrangeOrderMap();
        this.orderMenu = OrderMap;
    }

    public void initOrderMenu() {
        this.orderMenuName = new ArrayList<>();
        this.orderMenuCount = new ArrayList<>();
    }

    public void checkOrderFormat(String rawInputOrder) {
        String[] splitedOrderMenu = splitByComma(rawInputOrder);

        for (String order : splitedOrderMenu) {
            String[] tempOrder = splitBySeperator(order);
            isOrderconsistTwoParts(tempOrder);
            isSecondElementInteger(tempOrder);
            arrageOrderMenu(tempOrder);

        }
    }

    public void arrageOrderMenu(String[] tempOrder) {
        orderMenuName.add(tempOrder[0]);
        int eachOrderMenuCount = Integer.parseInt(tempOrder[1]);
        orderMenuCount.add(eachOrderMenuCount);
    }

    public String[] splitByComma(String rawInputOrder) {
        String blankRemovedOrder = rawInputOrder.replace(" ", "");
        return blankRemovedOrder.split(",");
    }

    public String[] splitBySeperator(String order) {
        isInSeperator(order);
        return order.split(SEPERATOR);
    }

    public void isSecondElementInteger(String[] tempOrder) {
        try {
            Integer.parseInt(tempOrder[1]);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void isInSeperator(String order) {
        if (!order.contains(SEPERATOR)) {
            throw new IllegalArgumentException();
        }
    }

    public void isOrderconsistTwoParts(String[] tempOrder) {
        if (tempOrder.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    public Map<String, Integer> arrangeOrderMap() {
        Map<String, Integer> OrderMap = new HashMap<>();

        for (int i = 0; i < orderMenuName.size(); i++) {
            OrderMap.put(orderMenuName.get(i), orderMenuCount.get(i));
        }
        return OrderMap;
    }

}
