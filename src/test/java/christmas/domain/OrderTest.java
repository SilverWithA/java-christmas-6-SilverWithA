package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    Order order= new Order();

    @Test
     void 콤마기준_분리테스트(){
        String[] splitedOrder = order.splitByComma("해산물파스타-1, 제로콜라-3, 샴페인-1");
        String[] expectedSplitedOrder = {"해산물파스타-1","제로콜라-3","샴페인-1"};

        assertThat(splitedOrder).isEqualTo(expectedSplitedOrder);
    }


    @Test
    void 주문형식_주문개수_문자형_예외테스트() {
        String[] tempOrder = {"해물파스타", "abc"};

        assertThrows(NumberFormatException.class, () -> order.isSecondElementInteger(tempOrder));
    }

    @Test
    void 주문형식_주문개수_숫자형_예외테스트(){
        String[] tempOrder = {"해물파스타","3"};
        assertDoesNotThrow(() -> order.isSecondElementInteger(tempOrder));
    }


    @Test
    @DisplayName("정해진 구분자로 주문이 들어오지 않았을때 예외가 발생하는지 테스트")
    void 주문형식_예외테스트_구분자없음(){
        assertThatThrownBy(() -> order.isInSeperator("해물파스타:2"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("정해진 구분자가 있을때 예외가 일어나지 않는지 검증 테스트")
    void 주문형식에_구분자있을시_테스트(){
        assertDoesNotThrow(() -> order.isInSeperator("해물파스타-2"));
    }

    @Test
    @DisplayName("주문이 구분자를 기준으로나눠졌을때 두 부분인지 확인하는 테스트")
    void 주문형식_두파트가_아닐때_예외테스트(){
        String[] tempOrder = {"해산물파스타", "샴페인", "3"};
        assertThatThrownBy(() -> order.isOrderconsistTwoParts(tempOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문이 구분자를 기준으로나눠졌을때 두 부분인지 확인하는 테스트")
    void 주문형식_두파트일때_테스트(){
        String[] tempOrder = {"해산물파스타", "3"};
        assertDoesNotThrow(() -> order.isOrderconsistTwoParts(tempOrder));
    }
}