package rrx.cnuo.cnbizservice;

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
public class CnBizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnBizServiceApplication.class, args);
	}

}
