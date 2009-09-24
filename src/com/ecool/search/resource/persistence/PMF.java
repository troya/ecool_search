// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.persistence;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;
import org.compass.core.config.CompassEnvironment;
import org.compass.gps.CompassGps;
import org.compass.gps.device.jdo.Jdo2GpsDevice;
import org.compass.gps.impl.SingleCompassGps;

/**
 * @author soros.wang
 *
 */
public class PMF {
	private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private static final Compass compass;
    private static final CompassGps compassGps;
    
    static {
    	compass = new CompassConfiguration().setConnection("gae://index")
    				.setSetting(CompassEnvironment.ExecutorManager.EXECUTOR_MANAGER_TYPE, "disabled")
    				.setSetting("compass.engine.analyzer.custom.type","org.wltea.analyzer.lucene.IKAnalyzer")
    				.addScan("com.ecool.search.resource.model")
    				.buildCompass();
    	
    	compassGps = new SingleCompassGps(compass);
    	compassGps.addGpsDevice(new Jdo2GpsDevice("appenine", pmfInstance));
    	compassGps.start();
    	
    	compassGps.index();
    	
    }
    
    private PMF() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
    
    public static Compass getCompass(){
    	return compass;
    }
    

    public static <T> List<T> query(Class clz, String queryString, String declareParameter, Object... parameterValues){
    	PersistenceManager persistenceManager = pmfInstance.getPersistenceManager();
    	Query query = persistenceManager.newQuery(clz, queryString);
    	query.declareParameters(declareParameter);
    	return (List<T>) query.executeWithArray(parameterValues);	
    	
    }
}
