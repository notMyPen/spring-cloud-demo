package rrx.cnuo.service;

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
public class CnOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnOrderServiceApplication.class, args);
	}

}
