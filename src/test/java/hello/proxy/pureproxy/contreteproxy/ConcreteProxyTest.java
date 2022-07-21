package hello.proxy.pureproxy.contreteproxy;

import hello.proxy.pureproxy.contreteproxy.code.ConcreteClient;
import hello.proxy.pureproxy.contreteproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.contreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        // 인터페이스 방식과 동일하게 다형성이 적용되는 거기 때문에
        // 클라이언트의 소스코드의 수정없이 변경이 가능하다!
        client.execute();
    }

}
