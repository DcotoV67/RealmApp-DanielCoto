package com.example.apprealm.crud;

import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.apprealm.model.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CRUDUser {
    private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(User.class).max("id");
        int nextId;
        if(currentIdNum == null) nextId = 0;
        else nextId = currentIdNum.intValue()+1;
        return nextId;
    }
    public final static void addUser(final User user){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CRUDUser.calculateIndex();
                User realmUser = realm.createObject(User.class, index);
                realmUser.setNombre(user.getNombre());
                realmUser.setAño(user.getAño());
            }
        });
    }

    public final static List<User> getAllUsers(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> users = realm.where(User.class).findAll();
        for(User user : users){
            Log.d("TAG", "ID: " + user.getId() + " Nombre: " + user.getNombre());
        }
        return users;
    }

    public final static User getUserByName(String name){
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).equalTo("nombre", name).findFirst();
        if(user != null) Log.d("TAG", "ID: " + user.getId() + " Nombre: " + user.getNombre() + " Edad: " + user.getAño());
        return user;
    }

    public final static User updateUserById(int id, String nombreNuevo, String edadNueva){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        User user = realm.where(User.class).equalTo("id", id).findFirst();
        user.setNombre(nombreNuevo);
        user.setAño(edadNueva);

        realm.insertOrUpdate(user);
        realm.commitTransaction();

        if(user != null) Log.d("TAG", "ID: " + user.getId() + " Nombre: " + user.getNombre() + " Edad: " + user.getAño());
        return user;
    }

    public static void deleteUserById(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        User user = realm.where(User.class).equalTo("id", id).findFirst();

        if(user!=null){
            user.deleteFromRealm();
        }
        realm.commitTransaction();

    }
}
