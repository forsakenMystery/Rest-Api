/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khashehchihamed.api.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Hamed Khashechi
 */
@Entity
public class Player extends BaseEntity {

    /*
    {"name":"Hassan Sadeghain",
        "auth":{
        "email":"immortalgardian@gmail.com",
        "password":"110David"
        }
    }
     */
    private String name;
    @Embedded
    private Authentication auth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
