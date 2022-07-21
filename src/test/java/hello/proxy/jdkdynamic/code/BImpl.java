package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface {

    // 동적 프록시가 없다면 구현 클래스 개수만큼 프록시 객체가 필요함
    // JDK 동적 프록시에 적용할 로직은 InvocationHandler 인터페이스를 구현해서 작성!
    @Override
    public String call() {
        log.info("B 호출");
        return "b";
    }
}
