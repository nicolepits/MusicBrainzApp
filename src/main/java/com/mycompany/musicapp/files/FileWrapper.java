/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.files;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mycompany.musicapp.Basics.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nicole
 */
public class FileWrapper {
    
    public static void writeArtistsToFile(String filename, ArrayList<Artists> k) {
        
        ObjectMapper mapper = new ObjectMapper(); // Creating an ObjectMapper object (Jackson API)
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter()); //Sets default pretty print for json text
        try {
            writer.writeValue(new File("txt.json"), k);   
            //this writes our arrayList k -converted into json-, into the file txt.json
        } catch (IOException ex) {
            Logger.getLogger(FileWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeReleasesToFile(String filename, ArrayList<Release> k) {
        
        ObjectMapper mapper = new ObjectMapper();// Creating an ObjectMapper object (Jackson API)
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter()); //Sets default pretty print for json text
        try {
            writer.writeValue(new File("txt.json"), k);   
            //this writes our arrayList k -converted into json-, into the file txt.json
        } catch (IOException ex) {
            Logger.getLogger(FileWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Artists> readArtistsFromFile(String filename) {

        ObjectMapper mapper=new ObjectMapper(); // Creating an ObjectMapper object (Jackson API)
        File file=new File(filename);
        
        ArrayList<Artists> result=new ArrayList();
        try {
            result=  mapper.readValue(file,new TypeReference<ArrayList<Artists>>() { } ); //this converts json file to object type:Artists
        } catch (IOException ex) {
            Logger.getLogger(FileWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result; //returning a deserialized ArrayList<Artists> 

    }

    public static ArrayList<Release> readReleasesFromFile(String filename) throws IOException {
        
        ObjectMapper mapper=new ObjectMapper(); // Creating an ObjectMapper object (Jackson API)
        File file=new File(filename);
        
        ArrayList<Release> result=new ArrayList();
        try {
            result=  mapper.readValue(file,new TypeReference<ArrayList<Release>>() { } ); //this converts json file to object type:Release
        } catch (IOException ex) {
            Logger.getLogger(FileWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result; //returning a deserialized ArrayList<Release> 
    }
  
  
}