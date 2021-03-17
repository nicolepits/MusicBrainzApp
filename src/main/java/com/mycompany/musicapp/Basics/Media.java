/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musicapp.Basics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Nicole
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Media {
    
    String format;
    @JsonIgnore
    int disc_count;
    @JsonIgnore
    int track_count;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getDisc_count() {
        return disc_count;
    }

    public void setDisc_count(int disc_count) {
        this.disc_count = disc_count;
    }

    public int getTrack_count() {
        return track_count;
    }

    public void setTrack_count(int track_count) {
        this.track_count = track_count;
    }
}
