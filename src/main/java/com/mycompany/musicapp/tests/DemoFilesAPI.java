/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.tests;
import com.mycompany.musicapp.db.Database;
import com.mycompany.musicapp.Basics.*;
import com.mycompany.musicapp.files.APIWrapper;
import com.mycompany.musicapp.files.FileWrapper;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicole
 */
public class DemoFilesAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try {
            ArrayList myList;
            ArrayList<Artists> myArtistList;
            
            myList=APIWrapper.getArtistsFrom("artist:fred"); //get's json data from url with the url parameter "artist:fred"
                                                             //and deserializes the data to an arraylist
            FileWrapper.writeArtistsToFile("txt.json", myList);//serialises the data to json format and writes it to file
            myArtistList=FileWrapper.readArtistsFromFile("txt.json"); //reads json data from file,deserializes it to java
                                                                      //objects and returns it to myArtistList
            
            ArrayList mySecondList;
            ArrayList<Release> myReleaseList;
            
            mySecondList=APIWrapper.getReleaseFrom("Lets-Dance");//get's json data from url with the url parameter "Lets Dance"
                                                                //and deserializes the data to an arraylist
            FileWrapper.writeReleasesToFile("txt.json", mySecondList);//serialises the data to json format and writes it to file
            mySecondList=FileWrapper.readReleasesFromFile("txt.json");//reads json data from file,deserializes it to java
                                                                      //objects and returns it to myArtistList
                                                                      
                                                                      
            Database.init(); //Loads our oracle Database
            
            //Before running this program we need to make sure that we have created our two tables in our database: Albums and Artists
            //and that they are both empty or else there will be constraint errors (in case we've already run this program)
            
            //First we insert one object (person and album) in our Database
            Database.InsertPersonInDB((Person) myList.get(0));
            Database.InsertAlbumInDB((Album)mySecondList.get(0));
            
            //We test our SQL Query methods by passing their return arraylists to albumDbList and personDbList.
            //Both arraylists can be checked by debugging 
            ArrayList<Album> albumDbList=new ArrayList();
            albumDbList=Database.SearchForAlbums("Dance");
            ArrayList<Person> personDbList=new ArrayList();
            personDbList=Database.SearchForPerson("Fred");
            
            //We now test our method which inserts an ArrayList of Album Objects in our Database
            ArrayList temparray= new ArrayList();
            temparray=APIWrapper.getReleaseFrom("Kind_Of_Magic");
            Database.InsertAlbumArrayListInDB(temparray); 
            
            //And lastly, we test our method which inserts an ArrayList of Person Objects in our Database
            ArrayList temparray1;
            temparray1=APIWrapper.getArtistsFrom("artist:jackson%20AND%20type:Person");
            Database.InsertPersonArrayListInDB(temparray1);
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(DemoBasics.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
    }
    
}
