package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventTest {

    @Test
    void 증정품_제공_테스트_(){
        Event event = new Event();
        Discount discount = new Discount();
        discount.setTotalAmountBeforeDiscount(120000);
        assertThat(event.canReceiveGift(discount)).isTrue();
    }
    @Test
    void 증정품_미제공_테스트_(){
        Event event = new Event();
        Discount discount = new Discount();
        discount.setTotalAmountBeforeDiscount(10000);
        assertThat(event.canReceiveGift(discount)).isFalse();
    }
}
