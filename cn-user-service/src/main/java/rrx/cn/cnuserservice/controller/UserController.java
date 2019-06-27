package rrx.cn.cnuserservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api("用户相关资源操作(演示Ribbon和Feign的区别)")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private RestTemplate restTemplate;//演示Ribbon怎么用
	
	@ApiOperation(value = "获取用户基本信息",httpMethod = "GET")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@GetMapping("/basicInfo/{id}")
	public String basicInfo(@PathVariable String id){
		System.out.println("id是："+id);
		return "这是basicInfo";
	}
	
	/**
	 * 演示Ribbon怎么用,ribbon不支持复杂数据类型list，所以要用数组接受，然后转list<br>
	 * Ribbon和Feign的区别：<br>
	 * 1.启动类使用的注解不同，Ribbon用的是@RibbonClient，Feign用的是@EnableFeignClients。<br>
	 * 2.服务的指定位置不同，Ribbon是在@RibbonClient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明<br>
	 * 3.调用方式不同，Ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。<br>
	 * https://blog.csdn.net/y532798113/article/details/81273110
	 * @author xuhongyu
	 * @return
	 */
	@ApiOperation(value = "获取用户订单列表(用于测试Ribbon)",httpMethod = "GET")
	@GetMapping("/orderList")
	@HystrixCommand(fallbackMethod="userFallbackMethod")
	public String orderList(){
		//url是你提供者的spring.application.name的值
		String[] orderArr = this.restTemplate.getForObject("http://order-service/order/list", String[].class);
		List<String> orderList = Arrays.asList(orderArr);
		return orderList == null ? "0个" : orderList.size() + "个";
	}
	
	public String userFallbackMethod(){
        return null;
    }
}
