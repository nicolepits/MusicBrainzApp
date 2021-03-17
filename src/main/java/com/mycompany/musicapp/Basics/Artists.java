/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Nicole
 */

/* This is an abstract class called Artists that has two subclasses: Group and Person. We assumed 
       that an Artist can be either an individual (Person) or a Group.This class can't be 
       instantiated*/

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
    @Type(name="Person", value=Person.class),
    @Type(name="Group", value=Group.class)
})
public abstract class Artists {
    
    //these are the mutual fields of both Person and Group class
    
    String name;
    String country;
    String cities;
    String beginDate;
    String endDate;
    ArrayList<Alias> aliases;
    ArrayList<Tag> tags;
       //@JsonProperty
    String id;
    
    /*
       Json's Artists fields has the following subfields:
       name,country,id (All are Strings)
       aliases,tags(lists)
       However aliases and tags are both lists of objects, so we created two extra classes: Tag and Alias
       */
  
    
    /*Musicbrainz' field 'life-span' has two values: BeginDate and EndDate, so we created a new 
    method called unpackNameFromNestedObject which assumes that that the field lifespan is a hashmap
    with a key and a value (begindate and enddate).This method sets the values to our class' fields
    beginDate and endDate. We achieved this by using the annotation JsonProperty to serialize/deserialize
    the property lifespan to deal with this non-standard getter.
    */
       
    @JsonProperty("life-span")
    private void unpackNameFromNestedObject(Map<String, String> lifespan) {
        beginDate = lifespan.get("begin");
        endDate=lifespan.get("ended");
    }
    
    //Standard Getters and Setters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<Alias> aliases) {
        this.aliases = aliases;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
