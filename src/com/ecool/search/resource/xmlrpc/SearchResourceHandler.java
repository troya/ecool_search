// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.xmlrpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.compass.core.CompassHits;
import org.compass.core.CompassSearchSession;
import org.compass.core.Resource;

import com.ecool.search.resource.persistence.PMF;

/**
 * @author soros.wang
 *
 */
public class SearchResourceHandler {
	@SuppressWarnings("unchecked")
	public List<Map> search(String queryString){
		List<Map> result= new ArrayList<Map>();
		CompassSearchSession searchSession = PMF.getCompass().openSearchSession();
		if(queryString != null && !queryString.equals("")){
			CompassHits hits = searchSession.find(queryString);
			for(int i = 0; i < hits.length(); i++){
				Resource resource = hits.resource(i);
				Map resultEntry = new HashMap();
				resultEntry.put("externalID", resource.getValue("externalID"));
				resultEntry.put("title", resource.getValue("title"));
				resultEntry.put("tags", resource.getValue("tags"));
				resultEntry.put("content", resource.getValue("content"));
				resultEntry.put("date", resource.getValue("date"));
				result.add(resultEntry);
			}
		}
		searchSession.close();
		return result;
	}
}
