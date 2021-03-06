package com.creathon.service;

import org.springframework.stereotype.Service;

import com.creathon.bean.LocationPermission;

public interface LocationPermissionService {

	public Boolean save(LocationPermission locationPermission);

	public LocationPermission findByShootAppIdAgnId(Integer shootApplicationId, Integer agencyId);

	public Boolean update(LocationPermission locationPermission);
}
