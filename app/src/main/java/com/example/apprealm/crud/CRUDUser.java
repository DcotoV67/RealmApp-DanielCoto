package com.example.apprealm.crud;

import android.util.Log;

import com.example.apprealm.model.Patin;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CRUDUser {
    private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Patin.class).max("id");
        int nextId;
        if(currentIdNum == null) nextId = 0;
        else nextId = currentIdNum.intValue()+1;
        return nextId;
    }
    public final static void addUser(final Patin patin){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CRUDUser.calculateIndex();
                Patin realmPatin = realm.createObject(Patin.class, index);
                realmPatin.setMarcaModelo(patin.getMarcaModelo());
            }
        });
    }

    public final static List<Patin> getAllPatins(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Patin> patins = realm.where(Patin.class).findAll();
        for(Patin patin : patins){
            Log.d("TAG", "ID: " + patin.getId() + " Marca: "  + " Marca y modelo: " + patin.getMarcaModelo());
        }
        return patins;
    }

    public final static Patin getUserByName(String marcaModelo){
        Realm realm = Realm.getDefaultInstance();
        Patin patin = realm.where(Patin.class).equalTo("marcaModelo", marcaModelo).findFirst();
        if(patin != null) Log.d("TAG", "ID: " + patin.getId() + "Marca y modelo: " + patin.getMarcaModelo());
        return patin;
    }

    public final static Patin updatePatinById(int id, String nMarcaModelo){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Patin patin = realm.where(Patin.class).equalTo("id", id).findFirst();
        patin.setMarcaModelo(nMarcaModelo);

        realm.insertOrUpdate(patin);
        realm.commitTransaction();

        if(patin != null) Log.d("TAG", "ID: " + patin.getId() + "Marca y modelo: " + patin.getMarcaModelo());
        return patin;
    }

    public static void deleteUserById(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Patin patin = realm.where(Patin.class).equalTo("id", id).findFirst();

        if(patin !=null){
            patin.deleteFromRealm();
        }
        realm.commitTransaction();

    }
}
