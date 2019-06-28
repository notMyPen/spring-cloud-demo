package rrx.cnuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Feign和Ribbon选其一即可也可以同时使用，一般选Feign，Feign使用更优雅且内部也是用Ribbon实现的负载均衡
 * @author xuhongyu
 * @date 2019年6月27日
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
//@EnableHystrixDashboard
@EnableCircuitBreaker
@RibbonClient(name="user-service")//name不指定服务则为所有的服务打开负载均衡，也可以在用yml中进行配置
public class CnUserServiceApplication {

	@Autowired
    private RestTemplateBuilder builder;//给@RibbonClient用(不用就去掉)
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
//		给@RibbonClient用(不用就去掉)
        return builder.build();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CnUserServiceApplication.class, args);
	}

}
