package com.cloud.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;

@SpringBootTest
class CloudServiceConsumerApplicationTests {

	@Autowired
	private RibbonLoadBalancerClient balancerClient;

	@Test
	void contextLoads() {
		for (int i = 0; i < 100; i++) {
			ServiceInstance instance = balancerClient.choose("service-provider");
			System.out.println(instance.getPort());
		}
	}

}
