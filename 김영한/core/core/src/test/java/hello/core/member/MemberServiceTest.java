package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach // 테스트를 실행하기 전에 무조건 실행되는 것
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA",Grade.VIP); // 객체 생성(생성자를 통해)
        //when
        memberService.join(member); //save
        Member findMember = memberService.findMember(1L);
        //then
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);// 생성한 객체와 찾은 객체가 일치하는지 확인
    }
}
