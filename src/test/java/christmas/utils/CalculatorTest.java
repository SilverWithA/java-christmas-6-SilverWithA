package christmas.utils;

import christmas.controller.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("할인 전 총 주문 금액이 올바르게 계산되는지 검증")
    void 할인_전_총금액_테스트(){
        Map<String, Integer> orderMenu = Map.of("해산물파스타", 2, "레드와인", 1, "초코케이크", 1);
        int totalAmount = Calculator.calculateTotalAmountBeforeDiscount(orderMenu);

        assertThat(totalAmount).isEqualTo(145000);
    }
}
