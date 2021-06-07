package com.assignment.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdGeneratorDao{
	
	public int doIncrementwithLock();


}
