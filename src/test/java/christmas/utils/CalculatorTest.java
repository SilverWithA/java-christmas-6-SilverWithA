package christmas.utils;

import christmas.constants.Menu;
import christmas.controller.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("할인 전 총 주문 금액이 올바르게 계산되는지 검증")
    void calculateTotalAmountTest(){
        Map<String, Integer> orderMenu = Map.of("해산물파스타", 2, "레드와인", 1, "초코케이크", 1);
        int totalAmount = Calculator.calculateTotalAmount(orderMenu);

        assertThat(totalAmount).isEqualTo(145000);
    }

    @Test
    @DisplayName("주문일 기준 크리스마스 할인금액 계산 검증-1일")
    void calculateChristmasDistcountTest_DAY1(){
        int discountAmount = Calculator.calculateChristmasDistcount(1);
        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("주문일 기준 크리스마스 할인금액 계산 검증-25일")
    void calculateChristmasDistcountTest_DAY25() {
        int discountAmount = Calculator.calculateChristmasDistcount(25);
        assertThat(discountAmount).isEqualTo(3400);
    }

    @Test
    @DisplayName("주문일 기준 크리스마스 할인금액 계산 검증-26일")
    void calculateChristmasDistcountTest_DAY26() {
        int discountAmount = Calculator.calculateChristmasDistcount(26);
        assertThat(discountAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("메뉴가 메인메뉴인지 참 판단 태스트")
    void isMainTest_True(){
        boolean actual = Calculator.isMain("티본스테이크");
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("메뉴가 메인메뉴인지 거짓 판단 태스트")
    void isMainTest_False(){
        boolean actual = Calculator.isMain("시저샐러드");
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("메인메뉴 주문 있을때 주말 할인 금액 계산 테스트")
    void calculateWeekendDiscountTest_Main(){
        Map<String, Integer> orderMenu = Map.of("양송이수프",2,"티본스테이크",2);
        int discountAmount = Calculator.calculateWeekendDiscount(orderMenu);

        assertThat(discountAmount).isEqualTo(4046);
    }

    @Test
    @DisplayName("메인메뉴 주문 없을 때 주말 할인 금액 계산 테스트")
    void calculateWeekendDiscountTest_NoMain(){
        Map<String, Integer> orderMenu = Map.of("양송이수프",2);
        int discountAmount = Calculator.calculateWeekendDiscount(orderMenu);

        assertThat(discountAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("메뉴가 디저트메뉴인지 참 판단 태스트")
    void isDesertTest_True(){
        boolean actual = Calculator.isDesert("아이스크림");
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("메뉴가 디저트메뉴인지 거짓 판단 태스트")
    void isDesertTest_False(){
        boolean actual = Calculator.isDesert("양송이수프");
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("디저트메뉴 주문 있을 때 평일 할인 금액 계산 테스트")
    void calculateDayDiscount_Dissert(){
        Map<String, Integer> orderMenu = Map.of("아이스크림",2);
        int discountAmount = Calculator.calculateDayDiscount(orderMenu);

        assertThat(discountAmount).isEqualTo(4046);
    }

    @Test
    @DisplayName("디저트메뉴 주문 없을 때 평일 할인 금액 계산 테스트")
    void calculateDayDiscount_NoDissert(){
        Map<String, Integer> orderMenu = Map.of("양송이수프",2);
        int discountAmount = Calculator.calculateDayDiscount(orderMenu);

        assertThat(discountAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("스페셜데이 해당시 할인 금액 테스트")
    void calculateSpecialDiscountTest(){
        boolean specialDay = true;
        int discountAmount = Calculator.calculateSpecialDiscount(specialDay);

        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("스페셜데이 해당되지 않을시ㅐ 할인 금액 테스트")
    void calculateSpecialDiscountTest_no(){
        boolean specialDay = false;
        int discountAmount = Calculator.calculateSpecialDiscount(specialDay);

        assertThat(discountAmount).isEqualTo(0);
    }
}
