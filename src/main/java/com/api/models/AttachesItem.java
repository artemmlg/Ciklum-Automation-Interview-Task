package com.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AttachesItem{

	@JsonProperty("filename")
	private String filename;

	@JsonProperty("link")
	private String link;

	@JsonProperty("id")
	private String id;

	public String getFilename(){
		return filename;
	}

	public String getLink(){
		return link;
	}

	public String getId(){
		return id;
	}
}