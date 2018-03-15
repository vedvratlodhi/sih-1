package com.creathon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creathon.bean.Agency;
import com.creathon.dao.AgencyDao;
import com.creathon.service.AgencyService;

@Service
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyDao agencyDao;
	
	@Override
	public Agency findAgencyByEmail(String email) {
		return agencyDao.findAgencyByEmail(email);
	}

}
