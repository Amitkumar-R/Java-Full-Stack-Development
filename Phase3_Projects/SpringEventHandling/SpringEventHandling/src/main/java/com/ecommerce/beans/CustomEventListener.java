package com.ecommerce.beans;

import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {

	public void onApplicationEvent(CustomEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.toString());
	}

}
