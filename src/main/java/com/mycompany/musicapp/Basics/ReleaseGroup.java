/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author Nicole
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ReleaseGroup { //This is a subfield for musicbrainz' release from which we need to extract only the types
    
    @JsonIgnore
    String id;
    @JsonIgnore
    String type_id;
    @JsonIgnore
    String title;
    @JsonProperty("primary-type")
    String primary_type;
    @JsonProperty("secondary-type")
    ArrayList<String> secondary_types;
    
    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimary_type() {
        return primary_type;
    }

    public void setPrimary_type(String primary_type) {
        this.primary_type = primary_type;
    }

    public ArrayList<String> getSecondary_types() {
        return secondary_types;
    }

    public void setSecondary_types(ArrayList<String> secondary_types) {
        this.secondary_types = secondary_types;
    }
    
   
    
    
}
