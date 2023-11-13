package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderTest {

    Order order= new Order();

    @Test
     void 콤마기준_분리테스트(){
        String[] splitedOrder = order.splitByComma("해산물파스타-1, 제로콜라-3, 샴페인-1");
        String[] expectedSplitedOrder = {"해산물파스타-1","제로콜라-3","샴페인-1"};

        assertThat(splitedOrder).isEqualTo(expectedSplitedOrder);
    }
    @Test
    @DisplayName("정해진 구분자로 주문이 들어오지 않았을때 예외가 발생하는지 테스트")
    void 주문형식_예외테스트_구분자없음(){
        order.isInSeperator("해물파스타:2");

    }
}
