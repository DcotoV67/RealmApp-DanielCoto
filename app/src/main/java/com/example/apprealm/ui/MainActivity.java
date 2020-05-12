package com.example.apprealm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.apprealm.R;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        realm = Realm.getDefaultInstance();
    }
}
