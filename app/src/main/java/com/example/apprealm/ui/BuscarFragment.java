package com.example.apprealm.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apprealm.R;
import com.example.apprealm.crud.CRUDUser;
import com.example.apprealm.model.User;

public class BuscarFragment extends Fragment {

    private Button buttonBuscar;
    private EditText editTextNombreBuscar;

    private TextView textViewBuscarUser;

    public BuscarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //buscar
        editTextNombreBuscar = view.findViewById(R.id.editTextNombreBuscar);
        buttonBuscar = view.findViewById(R.id.buttonBuscar);
        textViewBuscarUser = view.findViewById(R.id.textViewBuscarUser);
        textViewBuscarUser.setVisibility(TextView.INVISIBLE);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = CRUDUser.getUserByName(editTextNombreBuscar.getText().toString());
                if (editTextNombreBuscar.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Inserte el nombre del usuario que quiere buscar", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if(user != null){
                        textViewBuscarUser.setVisibility(TextView.VISIBLE);
                        textViewBuscarUser.setText(user.toString());
                    } else Toast.makeText(getActivity(), "Usuario no encontrado", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
