package christmas.controller;

import christmas.domain.Discount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ControllerTest {

    @Test
    @DisplayName("주문 날짜가 1 ~ 31 사이가 아닐때 에러 테스트")
    void 주문날짜_범위_입력테스트(){
        Controller controller = new Controller();

        assertThatThrownBy(() -> controller.checkValidationVistitDate("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 날짜가 숫자형이 아닐때 에러 테스트")
    void 주문메뉴_입력테스트(){
        Controller controller = new Controller();

        assertThatThrownBy(() -> controller.checkValidationVistitDate("3일"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 형식이 올바르지 않으면 에러가 일어나는지 테스트")
    void 주문형식_예외테스트(){
        Controller controller = new Controller();
        assertThatThrownBy(() -> controller.checkOrder("감자칩-많이, 사이다-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 방문일입력부터_주문기능입력까지_테스트(){
        Controller controller = new Controller();
        assertDoesNotThrow(()-> controller.checkValidationVistitDate("3"));
        assertDoesNotThrow(()-> controller.checkOrder("해산물파스타-3,샴페인-1"));
    }
}
