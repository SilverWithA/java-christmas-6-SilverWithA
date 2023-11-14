package christmas.valiator;

import christmas.constants.Menu;

import java.util.*;

public class OrderValidator {
    static int MAX_ORDER_COUNT = 20;

    public static void validateMenuName(List<String> orderMenuName ) {

        isExistMenu(orderMenuName);
        isOrderUnique(orderMenuName);
        isOnlyBeverage(orderMenuName);
    }

    public static void validateMenuCount(List<Integer> orderMenuCount) {
        isOrderOverOne(orderMenuCount);
        isInValidatedOrderCount(orderMenuCount);
    }


    public static List<String> makeOrderMenuType(List<String> orderMenuName) {
        List<String> orderMenuType = new ArrayList<>();
        for (String menu : orderMenuName) {
            orderMenuType.add(Menu.typeOf(menu));
        }
        return orderMenuType;
    }



    public static void isExistMenu(List<String> orderMenuName) {
        List<String> menuNames = Menu.getMenuNames();

        for (String menu : orderMenuName) {
            if (!menuNames.contains(menu)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isOrderOverOne(List<Integer> orderMenuCount) {
        if (orderMenuCount.contains(0)) {
            throw new IllegalArgumentException();
        }
    }


    public static void isOrderUnique(List<String> orderMenuName) {
        Set<String> uniqueOrderMenu = new HashSet<>(orderMenuName);

        if (uniqueOrderMenu.size() < orderMenuName.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInValidatedOrderCount(List<Integer> orderMenuCount) {
        int orderCount = 0;
        for (int eachOrderCount : orderMenuCount) {
            orderCount += eachOrderCount;
        }
        if (orderCount > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static void isOnlyBeverage(List<String> orderMenuName) {
        List<String> orderMenuType = makeOrderMenuType(orderMenuName);
        Set<String> orderMenuTypeUnique = new HashSet<>(orderMenuType);

        for(String element : orderMenuTypeUnique){
            if (orderMenuTypeUnique.size() == 1 && element == "음료") {
                throw new IllegalArgumentException();
            }
        }
    }

}
