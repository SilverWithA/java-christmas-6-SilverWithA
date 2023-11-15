package christmas.domain;

import christmas.controller.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DateTest {

    @Test
    @DisplayName("isIsRange: 1 ~ 31 사이의 수가 아니면 에러를 일으키는지 테스트")
    void 범위체크_매서드테스트(){
        Date date = new Date();

        assertThatThrownBy(() -> date.isInRange(33))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("setDate: 유효한 date를 변수에 저장하는지 테스트")
    void 주문일_저장_테스트(){
        Date date = new Date();
        date.setDate(3);

        assertThat(date.getDate()).isEqualTo(3);
    }

    @Test
    @DisplayName("setDate: 유효한 date가 주말여부인지 판단하며 저장하는지 테스트")
    void 주문일_주말여부_테스트(){
        Date date = new Date();
        date.setDate(3);

        assertThat(date.getWeekend()).isFalse();
    }

    @Test
    @DisplayName("setDate: 유효한 date가 특별할인일인지 판단하며 저장하는지 테스트")
    void 주문일_특별할인일_테스트(){
        Date date = new Date();
        date.setDate(3);

        assertThat(date.getSpecialDayOrNot()).isTrue();
    }
    @Test
    @DisplayName("계산된 크리스마스 할인금액이 잘 반환되는지 확인하는 테스트")
    void 크리스마스_할인금액_설정테스트_1일(){
        Date date = new Date();
        date.setDate(1);
        int christmasDistcountAmount = date.canChristmasDiscount();

        assertThat(christmasDistcountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("계산된 크리스마스 할인금액이 잘 반환되는지 확인하는 테스트")
    void 크리스마스_할인금액_설정테스트_25일(){
        Date date = new Date();
        date.setDate(25);
        int christmasDistcountAmount = date.canChristmasDiscount();

        assertThat(christmasDistcountAmount).isEqualTo(3400);
    }

    @Test
    @DisplayName("주문일이 주말인지 판단하는지 테스트-1일")
    void 주문일_주말여부_판단테스트(){
        Date date = new Date();
        date.isWeekend(1);

        assertThat(date.getWeekend()).isTrue();
    }

    @Test
    @DisplayName("주문일이 주말인지 판단하는지 테스트-3일")
    void 주문일_평일여부_판단테스트(){
        Date date = new Date();
        date.isWeekend(3);

        assertThat(date.getWeekend()).isFalse();
    }

}
