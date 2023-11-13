package christmas.validator;

import christmas.controller.Controller;
import christmas.valiator.OrderValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderValidatorTest {

    @Test
    @DisplayName("기존 메뉴판에 존재하는 메뉴명인지 확인하는 테스트")
    void 존재하지않는_메뉴_예외테스트() {
        assertThatThrownBy(() -> OrderValidator.isExistMenu(List.of("양송이스프,바비큐립,오란씨")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문마다 주문개수가 1개 이상인지 확인하는 테스트")
    void 주문건수_0일때_예외테스트() {
        assertThatThrownBy(() -> OrderValidator.isOrderOverOne(List.of(0, 1, 2, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("중복 주문한 메뉴가 있으면 예외가 일어나는지 확인하는 테스트")
    void 중복주문_예외테스트() {
        List<String> orderWithDuplicate = Arrays.asList("양송이스프", "제로콜라", "양송이스프");

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.isOrderUnique(orderWithDuplicate);
        });
    }

    @Test
    @DisplayName("주문을 중복없이 했을때 예외가 발생하지 않는지 확인하는 테스트")
    void 중복주문_아닐시_테스트() {
        List<String> orderWithoutDuplicate = Arrays.asList("양송이스프", "제로콜라", "해산물파스타");

        assertDoesNotThrow(() -> {
            OrderValidator.isOrderUnique(orderWithoutDuplicate);
        });
    }

    @Test
    @DisplayName("최대 주문가능치를 넘는 주문이 들어왓을때 예외발생 테스트")
    void 주문최대치_예외테스트() {
        assertThatThrownBy(() -> OrderValidator.isInValidatedOrderCount(List.of(10, 5, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("음료메뉴만 주문했을때 예외 발생 테스트")
    void 음료만_주문시_예외테스트() {
        List<String> orderOnlyBeverage = Arrays.asList("제로콜라", "레드와인");

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.isOnlyBeverage(orderOnlyBeverage);
        });
    }

    @Test
    @DisplayName("음료메뉴에 다른 타입의 메뉴도 주문했을때 예외가 발생하지 않는지 검증하는 테스트")
    void 음료와다른메뉴_주문테스트() {
        List<String> orderOnlyBeverage = Arrays.asList("제로콜라", "아이스크림");

        assertDoesNotThrow(() -> {
            OrderValidator.isOnlyBeverage(orderOnlyBeverage);
        });
    }
}

