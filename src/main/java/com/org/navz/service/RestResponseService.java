package com.org.navz.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.navz.RestProjectApplication;
import com.org.navz.entity.RestTable;
import com.org.navz.resository.RestResponseRepository;
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
	public void test() {

		log.info(mrm.toString());
		System.out.println(mrm.getRestResponse().getMessages());
		System.out.println(mrm.getRestResponse().getResult().getName());
		System.out.println(mrm.getRestResponse().getResult().getAlpha2_code());
		System.out.println(mrm.getRestResponse().getResult().getAlpha3_code());

		rt.setName(mrm.getRestResponse().getResult().getName());
		/* persistenceManager.save(rt); */

		restResponseRepository.save(rt);
	}

}
