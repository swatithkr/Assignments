package com.assignment.assignment.dao;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.assignment.entity.IdGenerator;

@Component
public class IdGeneratorDaoImpl implements IdGeneratorDao {
	
	@Autowired
	SessionFactory sessionFaactory;
	
	@Autowired
	IdGenerator idGeneratorDao;

	@Override
	public int doIncrementwithLock() {
		System.out.println(" saving increment ");
		Session session = sessionFaactory.getCurrentSession();
		int data = 0;
		try {
			
			session.beginTransaction();
			 
			IdGenerator idg = (IdGenerator) session.get(IdGenerator.class, 1,LockOptions.UPGRADE);
			
			idg.setNumber(idg.getNumber() + 1);
			idg = (IdGenerator) session.merge(idg);
			data = idg.getNumber();
			session.getTransaction().commit();
		} catch (org.hibernate.StaleObjectStateException e) {
			 session.getTransaction().rollback();
			throw e;
		}
		catch (Exception e) {
			throw e;
		} 

		return data;
		
	}


	
}
