package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

// @Import(AppV2Config.class) // 클래스를 스프링 빈으로 등록한다.
@Import({AppV1Config.class, AppV2Config.class}) // 배열로 여러개 등록 가능
@SpringBootApplication(scanBasePackages = "hello.proxy.app") // 주의
// 원래는 해당 파일 패키지 경로 하위를 모두 컴포넌트 스캔하지만 scanBasePackages	설정을 통해 경로를 지정해줄 수 있다.
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
