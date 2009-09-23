// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.persistence;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

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
}
