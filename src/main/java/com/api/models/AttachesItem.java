package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(value = {"id_wrestler"})
public class AttachesItem{

	@JsonProperty("filename")
	private String filename;

	@JsonProperty("link")
	private String link;

	@JsonProperty("id")
	private String id;

	public void setFilename(String filename){
		this.filename = filename;
	}

	public String getFilename(){
		return filename;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}