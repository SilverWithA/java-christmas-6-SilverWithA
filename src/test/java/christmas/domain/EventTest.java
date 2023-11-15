package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventTest {

    @Test
    @DisplayName("증정품 제공해야하는 구매액일시 증정품을 제공하는지 확인")
    void canReceiveGiftTest_giveGift(){
        Event event = new Event();
        Discount discount = new Discount();
        discount.setTotalAmount(120000);
        assertThat(event.canReceiveGift(discount)).isTrue();
    }
    @Test
    @DisplayName("증정품 미제공 주문 건에 대해 증정품을 제공하지 않는지 확인")
    void canReceiveGift_NoGift(){
        Event event = new Event();
        Discount discount = new Discount();
        discount.setTotalAmount(10000);
        assertThat(event.canReceiveGift(discount)).isFalse();
    }
}
