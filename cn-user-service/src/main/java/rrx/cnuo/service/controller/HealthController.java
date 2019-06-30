package rrx.cnuo.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class HealthController {

	@Value("${test-string}")
	private String testString;
	
    @GetMapping("/config/test-string")
    public String testString(){
    	return testString;
    }
    
    @GetMapping("/health")
    public String health() {
        return "user-service success";
    }
    
//    @RequestMapping(value = "/config/refresh")
//    public String refresh() {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> requestEntity = new HttpEntity<>(null,requestHeaders);
//        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8862/actuator/refresh", requestEntity, String.class);
//        return stringResponseEntity.getStatusCode().value() + ":" +stringResponseEntity.getBody();
//    }
}
