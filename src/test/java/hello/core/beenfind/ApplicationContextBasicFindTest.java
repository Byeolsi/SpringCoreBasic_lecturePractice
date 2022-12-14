package hello.core.beenfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // getBean()을 통해 가져온 memberService 객체의 클래스와 MemberServiceImpl이 같은 클래스인지 확인.
        // 같으면 성공, 다르면 에러 발생.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        // getBean()을 통해 가져온 memberService 객체의 클래스와 MemberServiceImpl이 같은 클래스인지 확인.
        // 같으면 성공, 다르면 에러 발생.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현체의 타입으로 조회")
    void findBeanByImpl() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        // getBean()을 통해 가져온 memberService 객체의 클래스와 MemberServiceImpl이 같은 클래스인지 확인.
        // 같으면 성공, 다르면 에러 발생.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        // ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxxx", MemberService.class));
    }
}
