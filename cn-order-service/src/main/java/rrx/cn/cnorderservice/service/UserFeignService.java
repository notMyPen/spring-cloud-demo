package rrx.cn.cnorderservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 通过内部访问user-service中的资源
 * @author xuhongyu
 * @date 2019年6月27日
 */
@FeignClient(name = "user-service",decode404 = true/*,path = "/api"*/)//path表示对方的ContextPath(如果有)
public interface UserFeignService {

	@GetMapping("/user/basicInfo/{id}")
	String getBasicInfo(@PathVariable("id") String id);
}
