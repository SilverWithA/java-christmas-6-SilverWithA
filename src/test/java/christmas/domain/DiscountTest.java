package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountTest {


    @Test
    @DisplayName("계산된 크리스마스 할인액이 클래스 내 잘 설정되는지 확인하는 테스트")
    void setChristmasDistcountAmountTest(){
        Discount discount = new Discount();
        Date date = new Date();
        date.setVistitDate(25);
        discount.setChristmasDistcountAmount(date);

        assertThat(discount.getChristmasDistcountAmount()).isEqualTo(3400);
    }

    @Test
    @DisplayName("계산된 주말 할인액이 클래스 내 잘 설정되는지 확인하는 테스트")
    void setWeekendDistcountAmountTest(){
        Discount discount = new Discount();
        discount.setWeekendDistcountAmount(2023);

        assertThat(discount.getWeekendDistcountAmount()).isEqualTo(2023);
    }


}
