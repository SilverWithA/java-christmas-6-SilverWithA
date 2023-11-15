package christmas.validator;

import christmas.controller.Controller;
import christmas.valiator.OrderValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderValidatorTest {

    @Test
    @DisplayName("유효한 메뉴명 주문시 예외가 발생하지 않는지 확인")
    void validateMenuNameTest_validOrder(){
        List<String> tempOrderName = List.of("티본스테이크","양송이수프");
        assertDoesNotThrow(()-> OrderValidator.validateMenuName(tempOrderName));
    }

    @Test
    @DisplayName("유효하지 않은 메뉴명 주문시 예외가 발생하는지 확인")
    void validateMenuNameTest_unValidOrder(){
        List<String> tempOrderName = List.of("레드와인");
        assertThatThrownBy(()-> OrderValidator.validateMenuName(tempOrderName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //-----------
    @Test
    @DisplayName("유효한 메뉴개수로 주문시 예외가 발생하지 않는지 확인")
    void validateMenuCountTest_validOrder(){
        List<Integer> tempOrderCount = List.of(1,3,2);
        assertDoesNotThrow(()-> OrderValidator.validateMenuCount(tempOrderCount));
    }

    @Test
    @DisplayName("유효하지 않은 메뉴개수로 주문시 예외가 발생하는지 확인")
    void validateMenuCountTest_UnValidOrder(){
        List<Integer> tempOrderCount = List.of(1,15,6);
        assertThatThrownBy(()-> OrderValidator.validateMenuCount(tempOrderCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // ------

    @Test
    @DisplayName("기존 메뉴판에 존재하는 메뉴명인지 확인하는 테스트")
    void isExistMenuTest() {
        assertThatThrownBy(() -> OrderValidator.isExistMenu(List.of("양송이스프,바비큐립,오란씨")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문마다 주문개수가 1개 이상인지 확인하는 테스트")
    void isOrderOverOneTest() {
        assertThatThrownBy(() -> OrderValidator.isOrderOverOne(List.of(0, 1, 2, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("중복 주문한 메뉴가 있으면 예외가 일어나는지 확인하는 테스트")
    void isOrderUniqueTest_Duplicate() {
        List<String> orderWithDuplicate = Arrays.asList("양송이스프", "제로콜라", "양송이스프");

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.isOrderUnique(orderWithDuplicate);
        });
    }

    @Test
    @DisplayName("주문을 중복없이 했을때 예외가 발생하지 않는지 확인하는 테스트")
    void isOrderUniqueTest_Unique() {
        List<String> orderWithoutDuplicate = Arrays.asList("양송이스프", "제로콜라", "해산물파스타");

        assertDoesNotThrow(() -> {
            OrderValidator.isOrderUnique(orderWithoutDuplicate);
        });
    }

    @Test
    @DisplayName("최대 주문가능치를 넘는 주문이 들어왓을때 예외발생 테스트")
    void isInValidatedOrderCountTest() {
        assertThatThrownBy(() -> OrderValidator.isInValidatedOrderCount(List.of(10, 5, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("음료메뉴만 주문했을때 예외 발생 테스트")
    void isOnlyBeverageTest_Only() {
        List<String> orderOnlyBeverage = Arrays.asList("제로콜라", "레드와인");

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.isOnlyBeverage(orderOnlyBeverage);
        });
    }

    @Test
    @DisplayName("음료메뉴에 다른 타입의 메뉴도 주문했을때 예외가 발생하지 않는지 검증하는 테스트")
    void isOnlyBeverage_diverse() {
        List<String> orderOnlyBeverage = Arrays.asList("제로콜라", "아이스크림");

        assertDoesNotThrow(() -> {
            OrderValidator.isOnlyBeverage(orderOnlyBeverage);
        });
    }
}

