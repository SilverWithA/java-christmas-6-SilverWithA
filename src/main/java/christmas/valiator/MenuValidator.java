package christmas.valiator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuValidator {
    List<String> orderMenuName;
    List<Integer> orderMenuCount;

    public void validateMenu(Map<String, Integer> customerOrder){
        makeCustomerOrderMenuName(customerOrder);
        makeCustomerOrderMenuCount(customerOrder);
        isExistMenu(orderMenuName); //존재하는지 확인
        isOrderOverOne(customerOrder); //각 메뉴의 주문이 1개 이상인지 확인
        isUnique(customerOrder); //메뉴가 중복 없이 주문됐는지 확인
        isInValidatedOrderCount(customerOrder); //주문 가능 주문개수인지 확인
    }

    public void makeCustomerOrderMenuName(Map<String, Integer> customerOrder){
        List<String> menuName = new ArrayList<>();
        for(String name : customerOrder.keySet()){
            menuName.add(name);
        }
        this.orderMenuName = menuName;
    }

    public void makeCustomerOrderMenuCount(Map<String, Integer> customerOrder){
        List<Integer> menuCount = new ArrayList<>();
        for(Integer count : customerOrder.get(customerOrder.keySet())){
            menuCount.add(count);
        }
        this.orderMenuCount = menuCount;
    }

    public void isExistMenu(List<String> orderMenuName){
        for(String menu : orderMenuName){
            if(!StaticMenu.contain(menu)){
                throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
            }
        }
    }


}
