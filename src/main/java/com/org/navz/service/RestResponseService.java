package com.org.navz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.navz.RestProjectApplication;
import com.org.navz.entity.RestTable;
import com.org.navz.repository.RestResponseRepository;
import com.org.navz.responseModel.MainResponseModel;

@Service
@Transactional
public class RestResponseService {

	private static final Logger log = LoggerFactory.getLogger(RestProjectApplication.class);

	@Autowired
	RestResponseRepository restResponseRepository;

	RestTemplate restTemplate = new RestTemplate();
	MainResponseModel mrm = restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/IN",
			MainResponseModel.class);

	@Autowired
	RestTable rt;

	@Transactional
	public void writeToDatabase() {

		
		  log.info(mrm.toString());
		  System.out.println(mrm.getRestResponse().getMessages());
		  System.out.println(mrm.getRestResponse().getResult().getName());
		  System.out.println(mrm.getRestResponse().getResult().getAlpha2_code());
		  System.out.println(mrm.getRestResponse().getResult().getAlpha3_code());
		  
		  rt.setName(mrm.getRestResponse().getResult().getName());
		  rt.setMessages(mrm.getRestResponse().getMessages().toString());
		  rt.setAlpha2_code(mrm.getRestResponse().getResult().getAlpha2_code());
		  rt.setAlpha3_code(mrm.getRestResponse().getResult().getAlpha3_code());
		  
		  restResponseRepository.save(rt);
		 

	}

	public void ReadFromDatabase() {
		List<RestTable> listOfObjects = restResponseRepository.findAll();

		//listOfObjects.stream().forEach(System.out::println);
		
		  for(RestTable rt : listOfObjects) {
		  System.out.println(rt.getId()+" "+rt.getMessages()+" "+rt.getName()+" "+rt.
		  getAlpha2_code()+" "+rt.getAlpha3_code()+" "); }
		 
	}

}
