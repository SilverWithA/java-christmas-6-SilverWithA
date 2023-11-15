package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.Message;

public class InputView {

    public static String requestVisitDate(){
        System.out.println(Message.START_EVEN_PLANNER.getMessgae());
        System.out.println(Message.VISIT_DATE.getMessgae());

        String inputDate = Console.readLine();
        return inputDate;
    }

    public static String requestOrderMenu(){
        System.out.println(Message.ORDER_MENU.getMessgae());
        String inputOrder = Console.readLine();
        return inputOrder;
    }
}
