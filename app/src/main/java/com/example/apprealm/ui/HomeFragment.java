package com.example.apprealm.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.apprealm.R;
import com.example.apprealm.crud.CRUDUser;
import com.example.apprealm.model.Patin;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button btn_Insertar;
    private Button btn_Borrar;
    private Button btn_Buscar;
    private Button btn_Modificar;
    private Button btn_ListaPatins;

    private TextView textViewListaPatins;

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

        List<Patin> patins = CRUDUser.getAllPatins();

        navController = Navigation.findNavController(view);

        textViewListaPatins = view.findViewById(R.id.listaPatinesTextView);
        textViewListaPatins.setVisibility(TextView.INVISIBLE);


        btn_Insertar = view.findViewById(R.id.buttonNavInsertar);

        btn_ListaPatins = view.findViewById(R.id.buttonNavListaPatins);

        btn_Buscar = view.findViewById(R.id.buttonNavBuscar);

        btn_Modificar = view.findViewById(R.id.buttonNavModificar);

        btn_Borrar = view.findViewById(R.id.buttonNavBorrar);

        btn_Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.insertarFragment);
            }
        });

        btn_Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.buscarFragment);
            }
        });

        btn_Modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.modificarFragment);
            }
        });

        btn_Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.borrarFragment);
            }
        });

        btn_ListaPatins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewListaPatins.setVisibility(TextView.VISIBLE);
                List<Patin> patins = CRUDUser.getAllPatins();
                textViewListaPatins.setText(patins.toString());
            }
        });
    }
}
