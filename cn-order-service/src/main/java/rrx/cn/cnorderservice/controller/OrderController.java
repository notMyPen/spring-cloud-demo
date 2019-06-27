package rrx.cn.cnorderservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rrx.cn.cnorderservice.service.UserFeignService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserFeignService userFeignService;
	
	@GetMapping("/list")
	public List<String> list(){
		return Arrays.asList(new String[]{"订单1","订单2"});
	}
	
	@GetMapping("/userBasicInfo")
	public String userBasicInfo(){
		return userFeignService.getBasicInfo("12132");
	}
}
