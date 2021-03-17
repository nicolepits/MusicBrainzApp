/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.musicapp.files;
import com.mycompany.musicapp.Basics.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.ArrayList;

/**
 *
 * @author Nicole
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({}) //empty because there are no subclasses
public class APIQueryRelease {
    /*
    Musicbrainz's artist data (in json) has 4 fields: created,offset,count and artists which contains subfields.
    Same goes to release's data that has: created, offset, count and releases (with subfiels)
    Hence we created this APIQueryArtists to match those four primary fields with the APIQueryArtists's fields and 
    using Jackson's annotations we ignored the three fields: created,count and offset.
    */
    @JsonIgnore
    String created;
    @JsonIgnore
    int count;
    @JsonIgnore
    int offset;
    //We only need the Release list (Recordings list in musicbrainz' json stream)
    ArrayList<ReleaseQuery> releases;//= new ArrayList();

    
    //Jackson does not function without setters and getters
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public ArrayList<ReleaseQuery> getReleases() {
        return releases;
    }

    public void setReleases(ArrayList<ReleaseQuery> releases) {
        this.releases = releases;
    }
}
