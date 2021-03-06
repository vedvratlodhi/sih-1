package com.creathon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creathon.bean.LocationPermission;
import com.creathon.dao.LocationPermissionDao;
import com.creathon.service.LocationPermissionService;

@Service
public class LocationPermisionServiceImpl implements LocationPermissionService {

	@Autowired
	private LocationPermissionDao locationPermissionDao;
	
	@Override
	public Boolean save(LocationPermission locationPermission) {
		// TODO Auto-generated method stub
		return locationPermissionDao.save(locationPermission);
	}

	@Override
	public LocationPermission findByShootAppIdAgnId(Integer shootApplicationId, Integer agencyId) {
		// TODO Auto-generated method stub
		return locationPermissionDao.findByShootAppIdAgnId(shootApplicationId, agencyId);
	}

	@Override
	public Boolean update(LocationPermission locationPermission) {
		// TODO Auto-generated method stub
		return locationPermissionDao.update(locationPermission);
	}

}
