/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.tests;
import com.mycompany.musicapp.Basics.*;
import com.mycompany.musicapp.files.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class DemoBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
            ArrayList<Artists> personlist=new ArrayList(); //Creating arraylist objects for temporary  use8
            ArrayList<Artists> grouplist=new ArrayList();
            
            Person p= new Person("Michael Jackson","Male","Usa","Los Angeles","29-08-1958","25-07-2009","");
            
            personlist.add(p);//adds Person to our temporary personlist
            
            Group g= new Group("Poets of the fall","Finland","Helsinki","2003","ongoing","");
            
            grouplist.add(g); //adds Group to our temporary grouplist
            Media media= new Media();
            media.setFormat("cd");
            Album album1= new Album(personlist,"Dangerous","official","English","26-11-1991",media,14,""); //this is an artist's album
            Album album2= new Album(grouplist,"Ultraviolet","official","English","11-03-2018",media,10,""); //this is a group's album
            
            Compilation comp1=new Compilation(personlist,"Dangerous","Unofficial","English","26-11-1991",media,14,"");
            Compilation comp2=new Compilation(grouplist,"Ultraviolet","Official","English","11-03-2018",media,10,"");
            
         
    }
    
}