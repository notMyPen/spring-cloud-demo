package rrx.common.eurekarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekarServiceApplication.class, args);
	}

}
