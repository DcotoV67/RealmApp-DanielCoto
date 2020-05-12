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
import android.widget.EditText;
import android.widget.Toast;

import com.example.apprealm.R;
import com.example.apprealm.crud.CRUDUser;
import com.example.apprealm.model.Patin;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertarFragment extends Fragment {

    NavController navController;

    private EditText editTextMarca;
    private EditText editTextModelo;
    private Button btn_Insertar;


    private Patin patin;

    public InsertarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insertar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        patin = new Patin();

        navController = Navigation.findNavController(view);

        editTextModelo = view.findViewById(R.id.editTextModelo);
        editTextMarca = view.findViewById(R.id.editTextMarca);
        btn_Insertar = view.findViewById(R.id.buttonInsertar);

        btn_Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextModelo.getText().toString().matches("") || editTextMarca.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Introduce la marca y el modelo", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    patin.setMarca(editTextMarca.getText().toString());
                    patin.setModelo(editTextModelo.getText().toString());
                    CRUDUser.addUser(patin);
                    Toast.makeText(getActivity(), "Se ha añadido el patín correctamente", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
