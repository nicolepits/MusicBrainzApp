/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.files;
import com.mycompany.musicapp.Basics.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

/**
 *
 * @author Nicole
 */
public class APIWrapper {
    
    static final String USER_AGENT = "Mozilla/5.0";
    static ArrayList<Artists> ObjectArray;

    // HTTP GET request
    public static ArrayList<Artists> getArtistsFrom(String queryParam) throws Exception {

        queryParam=queryParam.replaceAll(" ", "_");
        String url="http://musicbrainz.org/ws/2/artist/?query="+queryParam+"&fmt=json";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        
        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        InputStream contentResponse = response.getEntity().getContent();
        //For matching Json Fieds to Java Fields, Jackson is needed
        ObjectMapper map= new ObjectMapper();
        //we need to ignore the uknown extra fields by using jackson's deserialization feature
        map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        map.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true); //This was needed for no errors during deserialization
        map.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        map.registerSubtypes(Person.class, Group.class);
         
        APIQueryArtists query =  map.readValue(contentResponse,new TypeReference<APIQueryArtists>(){}); //We used TypeReference to obtain full
                                                                                                        //type information from subclasses
        //arraylist 'results' now contains Objects (Type:Artist)
        
        return query.artists;

    }
    
    
    public static ArrayList<Release> getReleaseFrom(String queryParam) throws Exception {

        queryParam=queryParam.replaceAll(" ", "_");
        String url="http://musicbrainz.org/ws/2/release/?query="+queryParam+"&fmt=json";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        
        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        InputStream contentResponse = response.getEntity().getContent();
        //For matching Json Fieds to Java Fields, Jackson is needed
        ObjectMapper map= new ObjectMapper();
        //we need to ignore the uknown extra fields by using jackson's deserialization feature
        map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        map.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        map.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        map.registerSubtypes(Album.class, Compilation.class);
        
        //Match Json Fields with another APIQueryRelease, (explanation below)
        APIQueryRelease query =  map.readValue(contentResponse,new TypeReference<APIQueryRelease>(){});
        ArrayList<Release> list=new ArrayList();
        
        /*
        Jackson could not deserialize successfully using the Abstract class Release because of uknown reasons, so
        we created a new class called Release Query and deserialize it via our APIQueryRelease.We then create a new
        ArrayList (with Release Objects) and use an enhanced for-loop to append Release Query's elemenets that we
        need to our new Release ArrayList. 
        So we end up with a ArrayList<Release> which contains all json objects deserialized.
        */
        
        for(ReleaseQuery q: query.releases){ //To avoid NullPointerException, we make sure that each element is not null
            if(q.getRelease_group().getPrimary_type() == null){
                q.getRelease_group().setPrimary_type("");
            }
            if(q.getRelease_group().getSecondary_types() == null)
                q.getRelease_group().setSecondary_types(new ArrayList());
            if(q.getRelease_group().getSecondary_types().contains("Compilation")){
                Compilation temp=new Compilation();
                temp.setType("Compilation");
                if(q.getArtist_credit()!=null)
                    temp.setArtist_credit(q.getArtist_credit());
                if(q.getDate()!=null)
                    temp.setDate(q.getDate());
                if(q.getMedia().get(0).getFormat()!=null)
                    temp.setFormat(q.getMedia().get(0).getFormat());
                if(q.getId()!=null)
                    temp.setId(q.getId());
                if(q.getText_presentation()!=null)
                    temp.setLanguage(q.getText_presentation().getLanguage());
                if(q.getStatus()!=null)
                    temp.setStatus(q.getStatus());
                if(q.getTitle()!=null)
                    temp.setTitle(q.getTitle());
                temp.setTrack_count(q.getTrack_count());
                list.add(temp);
            } else if(q.getRelease_group().getPrimary_type().equals("Album")){
                Album temp=new Album();
                temp.setType("Album");
                if(q.getArtist_credit()!= null)
                    temp.setArtist_credit(q.getArtist_credit());
                if(q.getDate()!= null)
                    temp.setDate(q.getDate());
                if(q.getMedia().get(0).getFormat()!= null)
                    temp.setFormat(q.getMedia().get(0).getFormat());
                if(q.getId()!= null)
                    temp.setId(q.getId());
                if(q.getText_presentation()!= null)
                    temp.setLanguage(q.getText_presentation().getLanguage());
                if(q.getStatus()!= null)
                    temp.setStatus(q.getStatus());
                if(q.getTitle()!= null)
                    temp.setTitle(q.getTitle());
                temp.setTrack_count(q.getTrack_count());
                list.add(temp);
            
            }
        }
        
        return list;

        /*
        The reason why Jackson could not deserialize is that there's no single field on MusicBrainz that clarifies whether a 
        release is compilation or album (Jackson needs a 'type' field to deserialize/serialize subclasses) we created another class called
        ReleaseQuery which has the desired 
        musicbrains fields. Here on apiwrapper we keep only the values we need from the parsed Array and pass them to a new empty
        Release arraylist.
 
        */
        
    
    }
    
    
    
}
