package com.example.apprealm.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apprealm.R;
import com.example.apprealm.crud.CRUDUser;
import com.example.apprealm.model.User;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button buttonInsertar;
    private Button buttonBorrar;
    private Button buttonBuscar;
    private Button buttonModificar;
    private Button buttonListaUsuarios;

    private TextView textViewListaUsers;

    NavController navController;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<User> users = CRUDUser.getAllUsers();

        navController = Navigation.findNavController(view);

        textViewListaUsers = view.findViewById(R.id.textViewListaUsers);
        textViewListaUsers.setVisibility(TextView.INVISIBLE);

        //insert
        buttonInsertar = view.findViewById(R.id.buttonNavInsertar);
        //listar
        buttonListaUsuarios = view.findViewById(R.id.buttonNavListaUsuarios);
        //buscar
        buttonBuscar = view.findViewById(R.id.buttonNavBuscar);
        //modificar
        buttonModificar = view.findViewById(R.id.buttonNavModificar);
        //borrar
        buttonBorrar = view.findViewById(R.id.buttonNavBorrar);

        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.insertarFragment);
            }
        });

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.buscarFragment);
            }
        });

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.modificarFragment);
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.borrarFragment);
            }
        });

        buttonListaUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewListaUsers.setVisibility(TextView.VISIBLE);
                List<User> users = CRUDUser.getAllUsers();
                textViewListaUsers.setText(users.toString());
            }
        });
    }
}
