// Copyright 2009 StarCite Inc.  All rights reserved.
// $Id$
package com.ecool.search.resource.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

/**
 * @author soros.wang
 * 
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
@Searchable
public class ContentResource {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@SearchableId
	private Long id;

	@Persistent
	@SearchableProperty
	private String externalID;

	@Persistent
	@SearchableProperty
	private String content;

	@Persistent
	@SearchableProperty(format = "yyyy-MM-dd")
	private Date date;

	@Persistent
	@SearchableProperty
	private String tags;

	@Persistent
	@SearchableProperty
	private String title;
	
	@Persistent
	@SearchableProperty
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getExternalID() {
		return externalID;
	}

	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
