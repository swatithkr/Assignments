package com.assignment.assignment.service;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.IdGeneratorDao;

@Service
public class IdgeneratorService {
	
	@Autowired
	IdGeneratorDao idGeneratorDao;
	
	public int increaseNumber() {
		
		int result = 0;
		
		try {
			result=	idGeneratorDao.doIncrementwithLock();
			System.out.println("data saved....");
			}
		
		catch (StaleObjectStateException e) {
			System.out.println("race condition occured, try again for perform this.");
				
			}
		catch (Exception e) {
			throw e;
			}
			
		return result;
			
	}
}
