package com.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(value = {"attaches", "trainer1", "trainer2", "trainerid1", "trainerid2"})
public class UpdateWrestlerModel {
    @JsonProperty("result")
    private boolean result;

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

    public boolean getResult() {
        return result;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    public String getRegion2() {
        return region2;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getExpires() {
        return expires;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMname() {
        return mname;
    }

    public void setAttaches(List<AttachesItem> attaches) {
        this.attaches = attaches;
    }

    public List<AttachesItem> getAttaches() {
        return attaches;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setTrainer2(String trainer2) {
        this.trainer2 = trainer2;
    }

    public String getTrainer2() {
        return trainer2;
    }

    public void setTrainer1(String trainer1) {
        this.trainer1 = trainer1;
    }

    public String getTrainer1() {
        return trainer1;
    }

    public void setCardState(String cardState) {
        this.cardState = cardState;
    }

    public String getCardState() {
        return cardState;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setLictype(String lictype) {
        this.lictype = lictype;
    }

    public String getLictype() {
        return lictype;
    }

    public void setTrainerid2(String trainerid2) {
        this.trainerid2 = trainerid2;
    }

    public String getTrainerid2() {
        return trainerid2;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setFst1(String fst1) {
        this.fst1 = fst1;
    }

    public String getFst1() {
        return fst1;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFst2(String fst2) {
        this.fst2 = fst2;
    }

    public String getFst2() {
        return fst2;
    }

    public void setTrainerid1(String trainerid1) {
        this.trainerid1 = trainerid1;
    }

    public String getTrainerid1() {
        return trainerid1;
    }
}