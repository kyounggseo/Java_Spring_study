package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // Spring 사용하려는 설정 정보
// 자동으로 스프링 빈을 끌어올리기 위해 사용 => '@'가 붙은 것을 찾아 자동으로 스프링 빈으로 등록

// 컴포넌트 스캔사용
@ComponentScan(
        //basePackages = "hello,core.member", //탐색할 패키지의 시작위치
        //basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //AppConfig.class 의 @Configuration 를 제외하라는 의미 => 충돌 방지
)// 자동으로 스프링 빈으로 등록을 해주는데 그중 뺄 것을 지정

public class AutoAppConfig {
}
