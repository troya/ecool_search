// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.xmlrpc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.ecool.search.resource.model.ContentResource;
import com.ecool.search.resource.persistence.PMF;

/**
 * @author soros.wang
 *
 */
public class CreateUpdateResourceHandler {
	@SuppressWarnings("unchecked")
	public String upsertResource(String title, String type, String tags, String content, String externalID, Date date){
		
		ContentResource resource = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<ContentResource> results = PMF.query(ContentResource.class, "externalID == externalIDParam",
                "String externalIDParam", externalID);
		if(results.size() == 0){
			resource = new ContentResource();
		}else{
			resource = results.get(0);
		}
		resource.setContent(content);
		resource.setDate(date);
		resource.setExternalID(externalID);
		resource.setTitle(title);
		resource.setType(type);
		resource.setTags(tags);
		
		
		try {
			pm.makePersistent(resource);
		} finally {
			pm.close();
		}
		return "OK";
	}
}
