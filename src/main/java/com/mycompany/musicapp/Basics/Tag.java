/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Nicole
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Tag {
    
    //Tags have two fields: count and name
    //See Artists class for more info 
    
    int count;
    String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
