/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.db;
import com.mycompany.musicapp.Basics.*;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nicole
 */
public  class Database  {
    
    static Connection con=null;
    Statement stmt=null;
    
    public static void init(){ //This method is in charge of our program's connection with the oracle Database
        
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        //step2 create  the connection object  
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","it21762","it21762");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(con!=null){
            System.out.println("Congrats!You made it to the DB");
        } else {
            System.out.println("You couldnt connect to database");
        }

    }
    
    public static void InsertPersonInDB(Person person){ //When called, this method insers a person object in our database
            
        try {
            String insertDataSQL="INSERT INTO artists"
                    +"(id,name,country,cities,birthdate,deathdate,gender) VALUES"
                    +"(?,?,?,?,?,?,?)"; //? = parameters
            PreparedStatement inserPrepState=con.prepareStatement(insertDataSQL); //this prepares our query
            
            inserPrepState.setString(1,person.getId()); //We now set the parameters to person values
            inserPrepState.setString(2,person.getName());
            inserPrepState.setString(3,person.getCountry());
            inserPrepState.setString(4,person.getCities());
            inserPrepState.setString(5,person.getBeginDate());
            inserPrepState.setString(6,person.getEndDate());
            inserPrepState.setString(7,person.getGender());
            
            inserPrepState.executeUpdate(); //execute our updated query
            System.out.println("Records are successfully inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sorry, your records could not be successfully inserted.");
        }
       
    }
    
    public static void InsertAlbumInDB(Album album) { //same as InsertPersoninDB method
            
        try {
            String insertDataSQL="INSERT INTO albums"
                    +"(id,title,status,language,releasedate,format,trackcount,type) VALUES"
                    +"(?,?,?,?,?,?,?,?)";
            PreparedStatement inserPrepState=con.prepareStatement(insertDataSQL);
            
            inserPrepState.setString(1,album.getId());
            inserPrepState.setString(2,album.getTitle());
            inserPrepState.setString(3,album.getStatus());
            inserPrepState.setString(4,album.getLanguage());
            inserPrepState.setString(5,album.getDate());
            inserPrepState.setString(6,album.getFormat());
            inserPrepState.setInt(7,album.getTrack_count());
            inserPrepState.setString(8,album.getType());
            
            inserPrepState.executeUpdate();
            System.out.println("Records are successfully inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sorry, your records could not be successfully inserted.");
        }
       
    }
    
    public static ArrayList<Album> SearchForAlbums(String key) throws SQLException {
        /*When called, this method searches all of the table's columns for a keyword.
        Then we pass all records that contain the specific keyword to an arraylist and return it*/
        ArrayList<Album> AlbumsResults = new ArrayList();
        try {
               
            String query = "SELECT * FROM albums "
                    + "WHERE title LIKE ? "
                    + "OR id LIKE ? "
                    + "OR status LIKE ? "
                    + "OR language LIKE ? "
                    + "OR releasedate LIKE ? "
                    + "OR format LIKE ? "
                    + "OR type LIKE ?"; // our SQL SELECT query. 
            
           
            PreparedStatement inserPrepState=con.prepareStatement(query);
            inserPrepState.setString(1,"%"+key+"%"); //we used the % wildcard for sql commands
            inserPrepState.setString(2,"%"+key+"%");
            inserPrepState.setString(3,"%"+key+"%");
            inserPrepState.setString(4,"%"+key+"%");
            inserPrepState.setString(5,"%"+key+"%");
            inserPrepState.setString(6,"%"+key+"%");
            inserPrepState.setString(7,"%"+key+"%");
            
            
            
            ResultSet rs = inserPrepState.executeQuery(); // execute the query, and get a java resultset
            
            int i=0; //used for accessing array's indexes
            while (rs.next()) {
                Album album = new Album();
                String id = rs.getString("id");
                String title = rs.getString("title");
                String status = rs.getString("status");
                String language = rs.getString("language");
                String releasedate = rs.getString("releasedate");
                String format = rs.getString("format");
                int trackcount=rs.getInt("trackcount");
                String type = rs.getString("type");
                album.setId(id);
                album.setDate(releasedate);
                album.setFormat(format);
                album.setTrack_count(trackcount);
                album.setLanguage(language);
                album.setStatus(status);
                album.setTitle(title);
                album.setType(type);
                AlbumsResults.add(i, album);
                i++;

            }
            

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return AlbumsResults;
    }
    
    
    
    public static ArrayList<Person> SearchForPerson(String key) throws SQLException { //same as searchforalbum method
        ArrayList<Person> AlbumsResults = new ArrayList();
        try {
               
            String query = "SELECT * FROM artists "
                    + "WHERE id LIKE ? "
                    + "OR country LIKE ? "
                    + "OR name LIKE ? "
                    + "OR cities LIKE ? "
                    + "OR birthdate LIKE ? "
                    + "OR deathdate LIKE ? "
                    + "OR gender LIKE ?"; // our SQL SELECT query. 
            
           
            PreparedStatement inserPrepState=con.prepareStatement(query);
            inserPrepState.setString(1,"%"+key+"%");
            inserPrepState.setString(2,"%"+key+"%");
            inserPrepState.setString(3,"%"+key+"%");
            inserPrepState.setString(4,"%"+key+"%");
            inserPrepState.setString(5,"%"+key+"%");
            inserPrepState.setString(6,"%"+key+"%");
            inserPrepState.setString(7,"%"+key+"%");
            
            
            
            ResultSet rs = inserPrepState.executeQuery(); // execute the query, and get a java resultset
            
            int i=0;
            while (rs.next()) {
                Person person=new Person();
                String id = rs.getString("id");
                String country = rs.getString("country");
                String cities = rs.getString("cities");
                String birthdate = rs.getString("birthdate");
                String deathdate = rs.getString("deathdate");
                String gender = rs.getString("gender");
                String name=rs.getString("name");
              
                person.setId(id);
                person.setBeginDate(birthdate);
                person.setEndDate(deathdate);
                person.setCities(cities);
                person.setCountry(country);
                person.setGender(gender);
                person.setName(name);
       
                AlbumsResults.add(i, person);
                i++;

            }
            

        } catch (SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return AlbumsResults;
    }
    
     public static int InsertPersonArrayListInDB(ArrayList<Person> PersonList) throws SQLException {

        int count = 1;
        for (Person p : PersonList) {
            String insertDataSQL = "INSERT INTO artists"
                    + "(id,name,country,cities,birthdate,deathdate,gender) VALUES"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement inserPrepState = con.prepareStatement(insertDataSQL);

            inserPrepState.setString(1, p.getId()); //PersonList.get(i).getId()
            inserPrepState.setString(2, p.getName()); //PersonList.get(i).
            inserPrepState.setString(3, p.getCountry()); //PersonList.get(i)
            inserPrepState.setString(4, p.getCities());
            inserPrepState.setString(5, p.getBeginDate());
            inserPrepState.setString(6, p.getEndDate());
            inserPrepState.setString(7, p.getGender());

            inserPrepState.executeUpdate();
            count++;
        }
            System.out.println("Records are successfully inserted!");
           
            System.out.println("The entries are " + count);
            
            return count;

        
    }

    public static int InsertAlbumArrayListInDB(ArrayList<Album> AlbumList) throws SQLException {

        int count = 1;
        for (Album album : AlbumList) {
            String insertDataSQL = "INSERT INTO albums"
                    + "(id,title,status,language,releasedate,format,trackcount,type) VALUES"
                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement inserPrepState = con.prepareStatement(insertDataSQL);

            inserPrepState.setString(1, album.getId());
            inserPrepState.setString(2, album.getTitle());
            inserPrepState.setString(3, album.getStatus());
            inserPrepState.setString(4, album.getLanguage());
            inserPrepState.setString(5, album.getDate());
            inserPrepState.setString(6, album.getFormat());
            inserPrepState.setInt(7, album.getTrack_count());
            inserPrepState.setString(8, album.getType());

            inserPrepState.executeUpdate();
            count++;
        }
            System.out.println("Records are successfully inserted!");
            
            System.out.println("The entries are " + count);
            return count;
        
    }
    
}  
