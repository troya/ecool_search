// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.compass.core.CompassHits;
import org.compass.core.CompassSearchSession;
import org.compass.core.Resource;

import com.ecool.search.resource.persistence.PMF;

/**
 * @author soros.wang
 * 
 */
@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		CompassSearchSession search = PMF.getCompass().openSearchSession();
		String query = req.getParameter("q");
		if(query != null && !query.equals("")){
			CompassHits hits = search.find(query);
			for(int i = 0; i < hits.length(); i++){
				Resource resource = hits.resource(i);
				resp.getWriter().print(resource.getValue("externalID"));
				resp.getWriter().print("");
				resp.getWriter().print(resource.getValue("content"));
		
			}
		}
		search.close();
	}

}
