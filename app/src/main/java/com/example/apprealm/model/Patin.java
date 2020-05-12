package com.example.apprealm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Patin extends RealmObject {
    @PrimaryKey
    private int id;
    private String marca;
    private String modelo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Id: '" + id + '\'' +
                ", Marca: '" + marca + '\'' +
                ", Modelo: '" + modelo + '\'' + "\n";
    }
}
