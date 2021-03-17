/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.beans.Transient;
import java.util.ArrayList;

/**
 *
 * @author User
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Group") //Jackson annotation that defines this annotated class as "group"
public class Group extends Artists{ 
 
    private final String type = "Group"; //This field is needed for the serialization

    public String getType() {
        return type;
    }
    

    //constructor
    
    public Group(String name,String Country, String Cities,String BeginDate,String EndDate,String ID) {
        this.name = name;
        this.country = Country;
        this.cities = Cities;
        this.beginDate = BeginDate;
        this.endDate = EndDate;
        this.aliases= new ArrayList();
        this.tags= new ArrayList();
        this.id=ID;
    }
    
    public Group(){
        //empty Constructor
    }
    
  
    
     public void addalias(Alias alias){ //adds alias to list
        (this.aliases).add(alias);
    }
    
    public void addtags(Tag tag){  //adds tag to list
        (this.tags).add(tag);
    }
    
    //getters and setters
  

    
    
}
