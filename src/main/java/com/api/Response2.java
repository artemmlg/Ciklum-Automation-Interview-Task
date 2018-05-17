package com.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response2{

	@JsonProperty("result")
	private boolean result;

	@JsonProperty("id")
	private int id;

	public void setResult(boolean result){
		this.result = result;
	}

	public boolean isResult(){
		return result;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Response2{" + 
			"result = '" + result + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}