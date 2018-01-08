/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khashehchihamed.api;

import com.google.gson.Gson;
import com.khashehchihamed.api.model.GameNet;
import com.khashehchihamed.api.model.Player;
import com.khashehchihamed.api.services.UserService;
import java.util.List;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author Hamed Khashechi
 */
public class Api {
    
    public static UserService userService = new UserService();

    public static void main(String[] args) {
        Gson gson = new Gson();
        post("/add-player", (req, res) -> {
            res.type("application/json");
            Player player = gson.fromJson(req.body(), Player.class);
            return userService.addPlayer(player);
        }, gson::toJson);

        post("/add-game-net", (req, res) -> {
            res.type("application/json");
            GameNet gamenet = gson.fromJson(req.body(), GameNet.class);
            return userService.addGameNet(gamenet);
        }, gson::toJson);
        
        get("/player", (req, res) -> {
            res.type("application/json");
            return userService.getAllPlayer();
        }, gson::toJson);
        
        get("/game-net", (req, res) -> {
            res.type("application/json");
            return userService.getAllGameNet();
        }, gson::toJson);
        
        get("/player/name/:username", (req, res) -> {
            res.type("application/json");
            Player player = userService.getPlayerByName(req.params("username"));
            if (player != null) {
                return player;
            }
            return "No Player found!";
        }, gson::toJson);
        
        get("/game-net/name/:name", (req, res) -> {
            res.type("application/json");
            List<GameNet> game = userService.getGameNetByName(req.params("name"));
            if (game != null) {
                return game;
            }
            return "No GameNet found!";
        }, gson::toJson);
        
        get("/game-net/lattitude&longtitude/:lalo", (req, res) -> {
            res.type("application/json");
            List<GameNet> game = userService.getGameNetByLocation(req.params("lalo"));
            if (game != null) {
                return game;
            }
            return "No GameNet found!";
        }, gson::toJson);
     
        
        get("/game-net/game/:games", (req, res) -> {
            res.type("application/json");
            List<GameNet> game = userService.getGameNetByGame(req.params("games"));
            System.out.println("game = " + game);
            if (game != null) {
                return game;
            }
            return "No GameNet found!";
        }, gson::toJson);
    }
}
