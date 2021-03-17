/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

/**
 *
 * @author Nicole
 */
@JsonIgnoreProperties(ignoreUnknown=true)
class Area{
    
    String id;
    String name;
    String sort_name;
    ArrayList<String> iso_3166_1_codes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public ArrayList<String> getIso_3166_1_codes() {
        return iso_3166_1_codes;
    }

    public void setIso_3166_1_codes(ArrayList<String> iso_3166_1_codes) {
        this.iso_3166_1_codes = iso_3166_1_codes;
    }
    
   
    
}
@JsonIgnoreProperties(ignoreUnknown=true)
public class ReleaseEvents {
    
    String date;
    Area area;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    
    
}
