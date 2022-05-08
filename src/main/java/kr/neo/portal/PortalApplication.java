package kr.neo.portal;

import kr.neo.portal.model.Item;
import kr.neo.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링의 전반적인 설정을 자동으로해줘서 개발자가 별도 설정을 안해도됨, 프로그램의 시작점
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);

        System.out.println("하하하");

    }

}
