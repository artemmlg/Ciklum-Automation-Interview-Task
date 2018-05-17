package com.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("new")
	private String jsonMemberNew;

	@JsonProperty("id_wrestler")
	private String idWrestler;

	public void setJsonMemberNew(String jsonMemberNew){
		this.jsonMemberNew = jsonMemberNew;
	}

	public String getJsonMemberNew(){
		return jsonMemberNew;
	}

	public void setIdWrestler(String idWrestler){
		this.idWrestler = idWrestler;
	}

	public String getIdWrestler(){
		return idWrestler;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"new = '" + jsonMemberNew + '\'' + 
			",id_wrestler = '" + idWrestler + '\'' + 
			"}";
		}
}