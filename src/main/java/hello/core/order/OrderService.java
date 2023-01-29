package hello.core.order;

// 주문서비스

public interface OrderService {
    /**
     * 주문 생성 - 회원Id, 상품명, 상품가격
     */
    Order createOrder(
            Long memberId,
            String itemName,
            int itemPrice);
}
