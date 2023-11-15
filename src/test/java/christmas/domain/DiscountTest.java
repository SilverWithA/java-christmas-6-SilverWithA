package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountTest {

    @Test
    void 할인_전_총주문금액_설정테스트(){
        Discount discount = new Discount();
        int expectedAmount = 110000;
        discount.setTotalAmount(110000);

        assertThat(discount.getTotalAmount()).isEqualTo(expectedAmount);

    }



    @Test
    void 크리스마스_할인금액_설정테스트(){
        Discount discount = new Discount();
        Date date = new Date();
        date.setVistitDate(25);
        discount.setChristmasDistcountAmount(date);

        assertThat(discount.getChristmasDistcountAmount()).isEqualTo(3400);
    }

    @Test
    void 주말_할인금액_설정테스트(){
        Discount discount = new Discount();
        discount.setWeekendDistcountAmount(2023);

        assertThat(discount.getWeekendDistcountAmount()).isEqualTo(2023);
    }


}
