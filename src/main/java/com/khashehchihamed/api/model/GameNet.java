/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khashehchihamed.api.model;

import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Hamed Khashechi
 */
@Entity
public class GameNet extends BaseEntity{
    /*
    {"name":"megafun",
    "lattitude":"35.741635",
    "longtitude":"51.448145",
    "games":[
    {"name":"Dota 2"},
    {"name":"LOL"},
    {"name":"Cs-Go"}
    ]
    }
    */
   private String name;
   private double lattitude;
   private double longtitude;
   private List<Games> games;

    public List<Games> getGames() {
        return games;
    }
    
    public double getLattitude() {
        return lattitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[name: "+getName()+", lattitude: "+getLattitude()+", longtitude: "+getLongtitude()+"]"  ; //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
