package christmas.domain;

import christmas.controller.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DateTest {

    @Test
    @DisplayName("입력한 방문일이 범위에 속한 일자가 아니면 에러를 일으키는지 테스트")
    void 방문일_범위체크_범위수아님_테스트(){
        Date date = new Date();

        assertThatThrownBy(() -> date.isInRange(32))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 방문일이 범위에 속한 일자가 일때 에러를 일으키지 않는지 검증")
    void 방문일_범위체크_범위수_테스트(){
        Date date = new Date();

        assertDoesNotThrow(() -> date.isInRange(31));
    }



    @Test
    @DisplayName("입력한 방문일의 주말/특별 할인일 여부를 알맞게 판단하여 저장하는는지 확인하는 테스트")
    void 방문일_정보_판단테스트(){
        Date date = new Date();
        date.setVistitDate(3);

        assertThat(date.getVisitdate()).isEqualTo(3);
        assertThat(date.getWeekendOrNot()).isFalse();
        assertThat(date.getSpecialDayOrNot()).isTrue();
    }

    @Test
    @DisplayName("입력한 방문일의 주말 여부를 알맞게 판단하는지 테스트")
    void 주문일_주말여부_테스트(){
        Date date = new Date();
        date.setVistitDate(3);

        assertThat(date.getWeekendOrNot()).isFalse();
    }

    @Test
    @DisplayName("입력한 방문일이 특별 할인일 여부를 알맞게 판단하는지 테스트")
    void 주문일_특별할인일_테스트(){
        Date date = new Date();
        date.setVistitDate(3);

        assertThat(date.getSpecialDayOrNot()).isTrue();
    }
    // -------------------------------------------------------
    @Test
    @DisplayName("계산된 크리스마스 할인금액이 잘 반환되는지 확인하는 테스트")
    void 크리스마스_할인금액_설정테스트_1일(){
        Date date = new Date();
        date.setVistitDate(1);
        int christmasDistcountAmount = date.canChristmasDiscount();

        assertThat(christmasDistcountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("계산된 크리스마스 할인금액이 잘 반환되는지 확인하는 테스트")
    void 크리스마스_할인금액_설정테스트_25일(){
        Date date = new Date();
        date.setVistitDate(25);
        int christmasDistcountAmount = date.canChristmasDiscount();

        assertThat(christmasDistcountAmount).isEqualTo(3400);
    }

    @Test
    @DisplayName("주문일이 주말인지 판단하는지 테스트-1일")
    void 주문일_주말여부_판단테스트(){
        Date date = new Date();
        date.isWeekend(1);

        assertThat(date.getWeekendOrNot()).isTrue();
    }

    @Test
    @DisplayName("주문일이 주말인지 판단하는지 테스트-3일")
    void 주문일_평일여부_판단테스트(){
        Date date = new Date();
        date.isWeekend(3);

        assertThat(date.getWeekendOrNot()).isFalse();
    }

}
