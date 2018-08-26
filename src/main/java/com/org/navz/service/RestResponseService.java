package com.org.navz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.navz.RestProjectApplication;
import com.org.navz.responseModel.MainResponseModel;

@Service
public class RestResponseService {

	private static final Logger log = LoggerFactory.getLogger(RestProjectApplication.class);

	public void test() {
		RestTemplate restTemplate = new RestTemplate();
		MainResponseModel mrm = restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/IN",
				MainResponseModel.class);
		log.info(mrm.toString());
		System.out.println(mrm.getRestResponse().getMessages());
		System.out.println(mrm.getRestResponse().getResult().getName());
		System.out.println(mrm.getRestResponse().getResult().getAlpha2_code());
		System.out.println(mrm.getRestResponse().getResult().getAlpha3_code());
	}
}
