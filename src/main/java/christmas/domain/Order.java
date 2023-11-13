package christmas.domain;

import christmas.valiator.OrderValidator;

import java.util.HashMap;
import java.util.Map;

public class Order {

    String SPERATOR = "-";
    String ERROR_UNVALIDATED_ORDER ="[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public Map<String, Integer> orderMenu(String MenuBeforeSplit){

        Map<String, Integer> customerOrder = new HashMap<>();

        // (1) 쉼표로 각 주문 분리
        String[] splitedOrderMenu = MenuBeforeSplit.split(",");


        for(String order : splitedOrderMenu){

            // (2) 구분자 "-"가 존재하는지 확인
            isInSeperator(order);
            String[] tempOrder = order.split(SPERATOR);

            // (3) 구분자를 기준으로 메뉴 이름 - 메뉴 개수 구성되어 있는지 확인
            consistMenuAndOrderCount(tempOrder);

            // (4) 구분자 뒤 요소가 숫자인지 확인
            int tempCount = Integer.parseInt(tempOrder[1]);

            // (5) 손님의 주문 list를 담은 customerMenu에 저장
            customerOrder.put(tempOrder[0],tempCount);
        }

        // (6) 주문이 존재하는 메뉴인지/ 주문 개수는 20개 안넘는지 // 음료만 주문하지 않았는지 확인
        OrderValidator.validateMenu(customerOrder);
        return customerOrder;
    }

    public void isInSeperator(String order){
        if(! order.contains(SPERATOR)){
            throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
        }
    }

    public void consistMenuAndOrderCount(String[] tempOrder){
        if(tempOrder.length != 2){
            throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
        }
    }

    public void IsvalidatedMenuFormat(String MenuBeforeSplit){
        int removedCommaLength = MenuBeforeSplit.replace(",","").length();
        int removedSeparatorLength = MenuBeforeSplit.replace(SPERATOR,"").length();

        if(removedSeparatorLength != removedCommaLength + 1){
            throw new IllegalArgumentException(ERROR_UNVALIDATED_ORDER);
        }
    }
}
