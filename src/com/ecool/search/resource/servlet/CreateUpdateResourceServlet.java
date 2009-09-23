// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlrpc.server.XmlRpcServer;

import com.ecool.search.resource.model.ContentResource;
import com.ecool.search.resource.persistence.PMF;
import com.ecool.search.resource.xmlrpc.CreateUpdateResourceHandler;

/**
 * @author soros.wang
 * 
 */
@SuppressWarnings("serial")
public class CreateUpdateResourceServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
	}
}
