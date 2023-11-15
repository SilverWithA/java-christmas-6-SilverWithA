package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    Order order = new Order();

    @Test
    @DisplayName("입력한 주문이 유효할때 유효한지 알맞게 판단하는지 테스트")
    void validateOrderTest_validOrder() {

        String inputOrder = "해산물파스타-1, 제로콜라-3, 샴페인-1";
        assertDoesNotThrow(() -> order.validateOrder(inputOrder));
    }

    @Test
    @DisplayName("입력한 주문이 유효하지 않을때 에러를 일으키는지 테스트")
    void validateOrderTest_UnValidOrder() {

        String inputOrder = "해산물파스타-a, 제로콜라-3, 샴페인-1";
        assertThatThrownBy(()-> order.validateOrder(inputOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("입력한 주문을 콤마를 기준으로 분리하는지 테스트")
    void splitByCommaTest() {
        String[] splitedOrder = order.splitByComma("해산물파스타-1, 제로콜라-3, 샴페인-1");
        String[] expectedSplitedOrder = {"해산물파스타-1", "제로콜라-3", "샴페인-1"};

        assertThat(splitedOrder).isEqualTo(expectedSplitedOrder);
    }


    @Test
    @DisplayName("구분자를 기준으로 두번째 요소가 숫자형이 아닐때 예외가 발생하는지 확인하는 테스트")
    void isSecondElementIntegerTest_String() {
        String[] tempOrder = {"해물파스타", "abc"};

        assertThrows(NumberFormatException.class, () -> order.isSecondElementInteger(tempOrder));
    }

    @Test
    @DisplayName("구분자를 기준으로 두번째 요소가 숫자형일때 예외가 발생하지 않는지 확인하는 테스트")
    void isSecondElementIntegerTest_Integer() {
        String[] tempOrder = {"해물파스타", "3"};
        assertDoesNotThrow(() -> order.isSecondElementInteger(tempOrder));
    }


    @Test
    @DisplayName("정해진 구분자로 주문이 들어오지 않았을때 예외가 발생하는지 테스트")
    void isInSeperator_NoSeperator() {
        assertThatThrownBy(() -> order.isInSeperator("해물파스타:2"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("정해진 구분자가 있을때 예외가 일어나지 않는지 검증 테스트")
    void isInSeperator_Seperator() {
        assertDoesNotThrow(() -> order.isInSeperator("해물파스타-2"));
    }

    @Test
    @DisplayName("주문이 구분자를 기준으로나눠졌을때 두 부분이 아닐때 에러 발생 검증 테스트")
    void isOrderconsistTwoPartsTest_false() {
        String[] tempOrder = {"해산물파스타", "샴페인", "3"};
        assertThatThrownBy(() -> order.isOrderconsistTwoParts(tempOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문이 구분자를 기준으로나눠졌을때 에러 발생하지 않는지 확인 테스트")
    void isOrderconsistTwoPartsTest_true() {
        String[] tempOrder = {"해산물파스타", "3"};
        assertDoesNotThrow(() -> order.isOrderconsistTwoParts(tempOrder));
    }
}
