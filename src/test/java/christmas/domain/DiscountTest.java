package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountTest {

    @Test
    void 할인_전_총주문금액_설정테스트(){
        Discount discount = new Discount();
        int expectedAmount = 110000;
        discount.setTotalAmountBeforeDiscount(110000);

        assertThat(discount.getTotalAmountBeforeDiscount()).isEqualTo(expectedAmount);

    }

    @Test
    void 증정품_제공_테스트_(){
        Discount discount = new Discount();
        discount.setTotalAmountBeforeDiscount(120000);
        assertThat(discount.canReceiveGift()).isTrue();
    }
    @Test
    void 증정품_미제공_테스트_(){
        Discount discount = new Discount();
        discount.setTotalAmountBeforeDiscount(10000);
        assertThat(discount.canReceiveGift()).isFalse();
    }


    @Test
    void 크리스마스_할인금액_설정테스트(){
        Discount discount = new Discount();
        Date date = new Date();
        date.setDate(25);
        discount.setChristmasDistcountAmount(date);

        assertThat(discount.getChristmasDistcountAmount()).isEqualTo(3400);
    }


}
