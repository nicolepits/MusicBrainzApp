/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author Nicole
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseQuery { //Jackson only uses this class for Release Serialization/Deserialization
    
    String id;
    @JsonIgnore    //@JsonIgnore annotation ignores json fields and doesn't serialize/deserialize them
    int score;
    @JsonIgnore
    int count;
    
    String title;
    String status;
    @JsonProperty("text-presentation") //This means that text_presentation in json format is named "text-presentation"
    TextPresentation text_presentation;
    @JsonIgnore
    ArrayList<Artists> artist_credit;
    @JsonProperty("release-group")
    ReleaseGroup release_group;
    
    String date;
    @JsonIgnore
    String country;
    @JsonIgnore
    ArrayList<ReleaseEvents> release_events;
    @JsonIgnore
    ArrayList<LabelInfo> label_info;
    @JsonProperty("track-count")
    int track_count;
    ArrayList<Media> media;

    //Standard Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TextPresentation getText_presentation() {
        return text_presentation;
    }

    public void setText_presentation(TextPresentation text_presentation) {
        this.text_presentation = text_presentation;
    }

    public ArrayList<Artists> getArtist_credit() {
        return artist_credit;
    }

    public void setArtist_credit(ArrayList<Artists> artist_credit) {
        this.artist_credit = artist_credit;
    }

    public ReleaseGroup getRelease_group() {
        return release_group;
    }

    public void setRelease_group(ReleaseGroup release_group) {
        this.release_group = release_group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<ReleaseEvents> getRelease_events() {
        return release_events;
    }

    public void setRelease_events(ArrayList<ReleaseEvents> release_events) {
        this.release_events = release_events;
    }

    public ArrayList<LabelInfo> getLabel_info() {
        return label_info;
    }

    public void setLabel_info(ArrayList<LabelInfo> label_info) {
        this.label_info = label_info;
    }

    public int getTrack_count() {
        return track_count;
    }

    public void setTrack_count(int track_count) {
        this.track_count = track_count;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }
    
    
}
