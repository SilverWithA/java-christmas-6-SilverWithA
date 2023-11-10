package christmas.domain;

import christmas.valiator.MenuValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerMenu {
    public Map<String, Integer> orderMenu(String MenuBeforeSplit){
        //올바른 형식인지 확인

        Map<String, Integer> customerOrder = new HashMap<>();

        String[] splitedOrderMenu = MenuBeforeSplit.split(",");
        for(String order : splitedOrderMenu){

            //구분자 "-"가 존재하는지 확인
            isInSeperator(order);
            String[] tempOrder = order.split(SPERATOR);
            //메뉴이름 - 메뉴개수로 두부분으로 구성되어있는지 확인
            consistMenuAndOrderCount(tempOrder);

            //숫자형인지 확인후 숫자형으로 parsing
            int tempCount = Integer.parseInt(tempOrder[1]);

            //손님의 주문 list를 담은 customerMenu에 저장
            customerOrder.put(tempOrder[0],tempCount);
        }

        MenuValidator.validateMenu(customerOrder);
        return customerOrder;
    }

    public void isInSeperator(String order){
        if(! order.contains("-")){
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
        int removedSeparatorLength = MenuBeforeSplit.replace(SEPERATOR,"").length();

        if(removedSeparatorLength != removedCommaLength + 1){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
