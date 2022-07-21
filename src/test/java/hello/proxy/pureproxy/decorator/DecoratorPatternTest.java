package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        // 꾸며주는 역할을 하는 Decorator 들은 스스로 존재할 수 없다. 항상 꾸며줄 대상이 있어야 한다.
        // 따라서 내부에 호출 대상인 component 를 가지고 있어야 한다.
        // 그리고 component 를 항상 호출해야 한다. 이 부분이 중복이다.
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        // 클라이언트 클래스는 소스를 전혀 수정하지 않고 주입하고자 하는 프록시만 주입하는 방식으로 사용된다!
        client.execute();
    }

}
