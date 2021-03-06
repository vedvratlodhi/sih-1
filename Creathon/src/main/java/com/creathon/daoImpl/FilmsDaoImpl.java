package com.creathon.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creathon.bean.Films;
import com.creathon.bean.TeamMember;
import com.creathon.dao.FilmsDao;

@Transactional
@Repository
public class FilmsDaoImpl implements FilmsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Boolean saveOrUpdate(Films film) {
		
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(film);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Films> findAllByProductionHouseId(Integer productionHouseId) {

		List<Films> filmList = null;
		try{
			filmList = sessionFactory.getCurrentSession().createQuery("from Films where productionHouse ="+productionHouseId).list();
			return filmList;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer deleteFilm(Integer filmId) {
		System.out.println("inside deleteFilm daoImpl-->"+filmId);
		int result = 0;
		try{
			Films film = findByFilmId(filmId);
			System.out.println(film);
			sessionFactory.getCurrentSession().delete(film);
			//int result =sessionFactory.getCurrentSession().createSQLQuery("delete from team_member where id="+teamMemberId).executeUpdate();
			result = 1;
		}catch(Exception e){
			e.printStackTrace();			
		}
		return result;
	}

	@Override
	public Films findByFilmId(Integer filmId) {
		System.out.println("inside findByFilm daoImpl-->"+filmId);
		try{
			
			Films film =(Films) sessionFactory.getCurrentSession().createQuery("from Films where id="+filmId).uniqueResult();
			return film;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
