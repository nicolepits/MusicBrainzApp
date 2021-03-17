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
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.ArrayList;
import java.util.Map;

class TextRepresentation {
    String language;
    String script;
}
/**
 *
 * @author User
 */

/* This is an abstract class called Release that has two subclasses: Album and Compilation. We assumed 
   that a Release can be either an Album or a Compilation.This class can't be instantiated*/

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="", defaultImpl=Album.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
    @Type(name="Album", value=Album.class),
    @Type(name="Compilation", value=Compilation.class)
})
public abstract class Release { 

    String id;
    String title;
    String status; 
    String language; //jackson matches using the unpackLanguage method
    String date; //this is the releaseDate
    String format;
    int track_count; 
    ArrayList<Artists> artist_credit; //Arraylist with Artist Objects
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTrack_count() {
        return track_count;
    }

    public void setTrack_count(int track_count) {
        this.track_count = track_count;
    }

    public ArrayList<Artists> getArtist_credit() {
        return artist_credit;
    }

    public void setArtist_credit(ArrayList<Artists> artist_credit) {
        this.artist_credit = artist_credit;
    }
   
    
    
    
    
   
        
}
