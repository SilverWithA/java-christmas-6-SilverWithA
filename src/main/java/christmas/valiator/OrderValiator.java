package christmas.valiator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderValidator {
    public static void validateMenu(Map<String, Integer> customerOrder){

        // 메뉴와 메뉴 개수를 각각 List 형태로 만들어 관리
        List<String> orderMenuName = makeCustomerOrderMenuName(customerOrder);
        List<Integer> orderMenuCount = makeCustomerOrderMenuCount(customerOrder);

        isExistMenu(orderMenuName); //존재하는지 확인
//        isOrderOverOne(orderMenuCount); //각 메뉴의 주문이 1개 이상인지 확인
//        isUnique(orderMenuName); //메뉴가 중복 없이 주문됐는지 확인
//        isInValidatedOrderCount(orderMenuCount); //주문 가능 주문개수인지 확인
//        isOnlyBeverage(orderMenuName);  // 음료로만 이뤄진 주문인지 확인
    }

    public static List<String> makeCustomerOrderMenuName(Map<String, Integer> customerOrder){
        List<String> menuName = new ArrayList<>();
        for(String name : customerOrder.keySet()){
            menuName.add(name);
        }
        return menuName;
    }

    public static List<Integer> makeCustomerOrderMenuCount(Map<String, Integer> customerOrder){
        List<Integer> menuCount = new ArrayList<>();

        for(Integer count : customerOrder.values()) {
            menuCount.add(count);
        }
        return menuCount;
    }

    public static void isExistMenu(List<String> orderMenuName){
        for(String menu : orderMenuName){
            if(!StaticMenu.contain(menu)){
                throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
            }
        }
    }

}
