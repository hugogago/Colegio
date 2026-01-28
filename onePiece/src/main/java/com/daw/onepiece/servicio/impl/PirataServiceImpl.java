package com.daw.onepiece.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.daw.onepiece.dao.interfaces.IPirataDAO;
import com.daw.onepiece.servicio.interfaces.IPirataService;

public class PirataServiceImpl implements IPirataService {
	@Autowired
	IPirataDAO pirataDAO;
	
	
}
