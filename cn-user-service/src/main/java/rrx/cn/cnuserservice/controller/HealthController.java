package rrx.cn.cnuserservice.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HealthController {

	/*@Value("${version}")
    private String version;
	
	@Value("${test-string}")
	private String testString;*/
	
    @GetMapping("/health")
    public String health() {
        return "user-service success";
    }

    /*@GetMapping("/config/version")
    public String version(){
    	return version;
    }
    
    @GetMapping("/config/test-string")
    public String testString(){
    	return testString;
    }*/
    
    @RequestMapping(value = "/config/refresh")
    public String refresh() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(null,requestHeaders);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8862/actuator/refresh", requestEntity, String.class);
        return stringResponseEntity.getStatusCode().value() + ":" +stringResponseEntity.getBody();
    }
}
