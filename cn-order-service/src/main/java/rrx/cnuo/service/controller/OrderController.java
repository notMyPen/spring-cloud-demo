package rrx.cnuo.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import rrx.cnuo.service.service.UserFeignService;

@Api("订单相关资源操作(演示Ribbon和Feign的区别)")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserFeignService userFeignService;
	
	@ApiOperation(value = "获取订单列表",httpMethod = "GET")
	@ApiResponse(code = 200,message = "success",response = List.class)
	@GetMapping("/list")
	public List<String> list(){
		return Arrays.asList(new String[]{"订单1","订单2"});
	}
	
	@ApiOperation(value = "获取用户基本信息(用户测试feign)",httpMethod = "GET")
	@GetMapping("/userBasicInfo")
	public String userBasicInfo(){
		return userFeignService.getBasicInfo("12132");
	}
}
