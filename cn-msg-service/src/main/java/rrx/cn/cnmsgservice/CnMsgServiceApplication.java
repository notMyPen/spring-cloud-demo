package rrx.cn.cnmsgservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
//@EnableHystrixDashboard
@EnableCircuitBreaker
public class CnMsgServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnMsgServiceApplication.class, args);
	}

}
