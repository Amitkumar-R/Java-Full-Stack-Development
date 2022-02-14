package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringEdgeServerRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEdgeServerRoutingApplication.class, args);
	}

}
