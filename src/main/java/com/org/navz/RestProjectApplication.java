package com.org.navz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.navz.service.RestResponseService;

@SpringBootApplication
public class RestProjectApplication implements CommandLineRunner{

	@Autowired
	RestResponseService restResponseService;
	
	public static void main(String[] args) {
	      SpringApplication sa = new SpringApplication(RestProjectApplication.class);
	      sa.setBannerMode(Banner.Mode.OFF);
	      sa.run(args);
	  }

	  @Override
	  public void run(String... args) {
		  restResponseService.test();
	  }
	
	
}
