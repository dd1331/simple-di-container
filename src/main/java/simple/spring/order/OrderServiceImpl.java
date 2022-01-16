package simple.spring.order;

import simple.spring.discount.DiscountPolicy;
import simple.spring.member.Member;
import simple.spring.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 할인정책이 무엇인지 알 필요가 없음
        // 단일책임의 원칙이 적용됨
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
