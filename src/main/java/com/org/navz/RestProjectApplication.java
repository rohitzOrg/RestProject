package com.org.navz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.org.navz.service.RestResponseService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.org.navz.repository")
@EntityScan(basePackages = "com.org.navz.entity")
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
		  restResponseService.writeToDatabase();
		  restResponseService.ReadFromDatabase();
	  }
	
	
}
