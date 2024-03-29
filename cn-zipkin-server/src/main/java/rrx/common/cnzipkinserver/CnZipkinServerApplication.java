package rrx.common.cnzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class CnZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnZipkinServerApplication.class, args);
	}

}
