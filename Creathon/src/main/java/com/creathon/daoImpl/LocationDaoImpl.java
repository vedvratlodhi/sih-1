package com.creathon.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creathon.bean.Location;
import com.creathon.bean.User;
import com.creathon.dao.LocationDao;

@Repository
@Transactional
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Location> location() {
		List<Location> location=(List<Location>) sessionFactory.getCurrentSession().createQuery("from Location");
		return  location;
	}

	@Override
	public Location locationById(Integer locationId) {
		Location location = null;
		
		try
		{
			location = (Location) sessionFactory.getCurrentSession().createQuery("from Location where id =:id").setInteger("id",locationId).uniqueResult();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return location;
	}

	@Override
	public Boolean saveandupdate(Location location) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(location);
			return true;
		}catch (Exception e) {	
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
