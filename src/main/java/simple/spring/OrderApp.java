package simple.spring;

import simple.spring.member.Grade;
import simple.spring.member.Member;
import simple.spring.member.MemberService;
import simple.spring.member.MemberServiceImpl;
import simple.spring.order.Order;
import simple.spring.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


        Long memberId = 1L;
        Member member = new Member(memberId, "test", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatedPrice());


    }
}
