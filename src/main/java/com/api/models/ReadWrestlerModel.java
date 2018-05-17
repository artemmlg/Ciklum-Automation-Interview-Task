package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(value = {"id_wrestler", "attaches", "trainer1", "trainer2", "trainerid1", "trainerid2"})
public class ReadWrestlerModel{

	@JsonProperty("fname")
	private String fname;

	@JsonProperty("region1")
	private String region1;

	@JsonProperty("region2")
	private String region2;

	@JsonProperty("expires")
	private String expires;

	@JsonProperty("photo")
	private String photo;

	@JsonProperty("mname")
	private String mname;

	@JsonProperty("attaches")
	private List<AttachesItem> attaches;

	@JsonProperty("lname")
	private String lname;

	@JsonProperty("trainer2")
	private String trainer2;

	@JsonProperty("trainer1")
	private String trainer1;

	@JsonProperty("card_state")
	private String cardState;

	@JsonProperty("dob")
	private String dob;

	@JsonProperty("lictype")
	private String lictype;

	@JsonProperty("trainerid2")
	private String trainerid2;

	@JsonProperty("style")
	private String style;

	@JsonProperty("fst1")
	private String fst1;

	@JsonProperty("id")
	private String id;

	@JsonProperty("fst2")
	private String fst2;

	@JsonProperty("trainerid1")
	private String trainerid1;

	public String getFname(){
		return fname;
	}

	public String getRegion1(){
		return region1;
	}

	public String getRegion2(){
		return region2;
	}

	public String getExpires(){
		return expires;
	}

	public String getPhoto(){
		return photo;
	}

	public String getMname(){
		return mname;
	}

	public List<AttachesItem> getAttaches(){
		return attaches;
	}

	public String getLname(){
		return lname;
	}

	public String getTrainer2(){
		return trainer2;
	}

	public String getTrainer1(){
		return trainer1;
	}

	public String getCardState(){
		return cardState;
	}

	public String getDob(){
		return dob;
	}

	public String getLictype(){
		return lictype;
	}

	public String getTrainerid2(){
		return trainerid2;
	}

	public String getStyle(){
		return style;
	}

	public String getFst1(){
		return fst1;
	}

	public String getId(){
		return id;
	}

	public String getFst2(){
		return fst2;
	}

	public String getTrainerid1(){
		return trainerid1;
	}
}