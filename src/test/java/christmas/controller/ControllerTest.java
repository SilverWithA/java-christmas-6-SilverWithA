package christmas.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    void 주문메뉴_숫자형_입력테스트(){
        Controller controller = new Controller();

        assertThatThrownBy(() -> controller.checkValidationVistitDate("3일"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // --------------------------------------------------------------
    @Test
    @DisplayName("주문 형식이 올바르지 않으면 에러가 일어나는지 테스트")
    void 주문형식_예외테스트(){
        Controller controller = new Controller();
        assertThatThrownBy(() -> controller
                .checkValidationOrder("감자칩-많이, 사이다-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void 주문메뉴_출력테스트(){

    }


    void 할인전_주문금액_출력테스트(){

    }

    void 증정메뉴_출력테스트(){

    }

    void 혜택내역_출력테스트(){

    }

    void 총_혜택금액_출력테스트(){

    }

    void 할인후_예상결제금액_출력테스트(){

    }

    void 이벤트배지_출력테스트(){

    }
}
