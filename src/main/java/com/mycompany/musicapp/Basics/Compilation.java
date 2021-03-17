/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("Compilation") //Jackson annotation that defines this annotated class as "person"
public class Compilation extends Release {
    

    public Compilation() {
    }

    
    public Compilation(ArrayList<Artists> mylist,String title,String status,String language,String releaseDate,Media format,int trackCount,String id) {
        this.artist_credit = mylist;
       // this.media=format;
        this.id=id;
        this.date=releaseDate;
        this.status=status;
        this.title=title;
        this.track_count=trackCount;
    }

  
    
    
    
}
