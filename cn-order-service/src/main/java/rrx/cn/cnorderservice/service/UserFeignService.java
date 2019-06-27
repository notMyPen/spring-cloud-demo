package rrx.cn.cnorderservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import rrx.cn.cnorderservice.callback.HystrixFeignFallback;
import rrx.cn.cnorderservice.config.MFeignConfig;

/**
 * 通过内部访问user-service中的资源<br>
 * name是指要请求的服务名称<br>
 * fallback 是指请求失败，进入断路器的类，和使用ribbon是一样的<br>
 * configuration 是feign的一些配置，例如编码器等<br>
 * path表示对方的ContextPath(如果有)
 * @author xuhongyu
 * @date 2019年6月27日
 */
@FeignClient(name = "user-service",decode404 = true,fallback = HystrixFeignFallback.class,configuration = MFeignConfig.class/*,path = "/api"*/)
public interface UserFeignService {

	@GetMapping("/user/basicInfo/{id}")
	String getBasicInfo(@PathVariable("id") String id);
}
