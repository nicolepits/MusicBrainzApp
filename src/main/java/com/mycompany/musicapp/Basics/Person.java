package com.mycompany.musicapp.Basics;


import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */

@JsonTypeName("Person") //Jackson annotation that defines this anotated class as "person"
public class Person extends Artists {
    
    private final String type = "Person"; //This field is needed for the serialization
    String gender;
    
    public String getType() {
        return type;
    }
    public Person() { 
        //empty constructor
    }

    
    //constructor that initializes the variables of the fields of the class Person
    public Person(String name, String Gender, String Country, String Cities, String BirthDate, String DeathDate,String ID) {
        this.name = name;
        this.gender = Gender;
        this.country = Country;
        this.cities = Cities;
        this.beginDate = BirthDate;
        this.endDate = DeathDate;
        this.aliases =new ArrayList();
        this.tags = new ArrayList();
        this.id=ID;
    }
    
    public void addalias(Alias alias){ //adds alias to list
        (this.aliases).add(alias);
    }
    
    public void addtags(Tag tag){  //adds tag to list
        (this.tags).add(tag);
    }
    
    //getter and setter
    
    public String getGender() { 
        return gender;
    }
    public void setGender(String Gender) { 
        this.gender = Gender;
    }
    
    
}