/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khashehchihamed.api.services;

import com.khashehchihamed.api.model.GameNet;
import com.khashehchihamed.api.model.Games;
import com.khashehchihamed.api.model.Player;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Hamed Khashechi
 */
public class UserService {

    private static final double THRESHOLD = 0.01;
    MongoClient client = new MongoClient("localhost", 27017);
    Datastore DB = new Morphia().createDatastore(client, "forsakenMystery");
    
    public String addPlayer(Player player) {
        DB.save(player);
        return "add player";
    }

    public String addGameNet(GameNet gamenet) {
        DB.save(gamenet);
        return "add gamenet";
    }

    public List<Player> getAllPlayer() {
        List<Player> list = DB.find(Player.class).asList();
        
        if (list != null) {
            return list;
        }
        return null;
    }

    public List<GameNet> getAllGameNet() {
        List<GameNet> list = DB.find(GameNet.class).asList();
        if (list != null) {
            return list;
        }
        return null;
    }

    public Player getPlayerByName(String username) {
        Player player = DB.find(Player.class, "name", username).get();
        if (player != null) {
            return player;
        }
        return null;
    }
//https://www.google.com/search?rlz=1C1CHBF_enIR766IR766&ei=sTRNWproOqeY6ASznICYCg&q=searching+areas+map+google+js&oq=searching+areas+map+google+js&gs_l=psy-ab.3..33i22i29i30k1.37580.44117.0.44270.29.20.0.0.0.0.999.3111.3-1j2j0j2.5.0....0...1c.1.64.psy-ab..24.5.3111...0j0i67k1j0i22i30k1.0.5IN-rSItHO8
    public List<GameNet> getGameNetByName(String name) {
        List<GameNet> gamenet = DB.find(GameNet.class, "name", name).asList();
        if (gamenet != null) {
            return gamenet;
        }
        return null;
    }

    public List<GameNet> getGameNetByLocation(String s) {
        List<GameNet> gamenet = DB.find(GameNet.class).asList();
        double lattitude,longtitude;
        lattitude=Double.parseDouble(s.split(",")[0]);
        longtitude=Double.parseDouble(s.split(",")[1]);
        System.out.println("longtitude = " + longtitude);
        System.out.println("lattitude = " + lattitude);
        List<GameNet> send = null;
        for (GameNet game : gamenet) {
            System.out.println("game = " + game);
            if (Math.abs(game.getLattitude() - lattitude) < THRESHOLD && Math.abs(game.getLongtitude() - longtitude) < THRESHOLD) {
                if (send == null) {
                    send = new ArrayList<>();
                } 
                send.add(game);
            }
        }
        if (send != null) {
            return send;
        }
        return null;
    }

    public List<GameNet> getGameNetByGame(String game) {
        List<GameNet> gg = DB.find(GameNet.class).asList();
        List<GameNet> gamenet= new ArrayList<>();
        System.out.println("gg = " + gg);
        Games games = new Games();
        games.setName(game);
        for(GameNet ga: gg){
            if(ga.getGames().contains(games)){
                gamenet.add(ga);
            }
        }
        if (gamenet != null) {
            return gamenet;
        }
        return null;
    }

}
