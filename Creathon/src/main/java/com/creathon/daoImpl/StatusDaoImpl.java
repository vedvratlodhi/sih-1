package com.creathon.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.creathon.bean.Status;
import com.creathon.dao.StatusDao;

@Transactional
@Repository
public class StatusDaoImpl implements StatusDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Status> listOfStatus() {
		
		List<Status> listOfStatus = null;
		try{
			listOfStatus = sessionFactory.getCurrentSession().createQuery("from Status ").list();
			return listOfStatus;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Status findById(Integer statusId) {
		Status status = null;
		try{
			status = (Status) sessionFactory.getCurrentSession().createQuery("from Status where id="+statusId).uniqueResult();
			return status;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
