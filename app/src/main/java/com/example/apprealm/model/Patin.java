package com.example.apprealm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Patin extends RealmObject {
    @PrimaryKey
    private int id;
    private String marcaModelo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    @Override
    public String toString() {
        return "Patin{" +
                "id=" + id +
                ", marcaModelo='" + marcaModelo + '\'' +
                '}';
    }
}
