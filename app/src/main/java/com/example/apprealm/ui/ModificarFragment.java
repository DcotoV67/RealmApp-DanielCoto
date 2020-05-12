package com.example.apprealm.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apprealm.R;
import com.example.apprealm.crud.CRUDUser;
import com.example.apprealm.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModificarFragment extends Fragment {

    private Button buttonModificar;

    private EditText editTextModificarUser;
    private EditText editTextNombreNuevo;
    private EditText editTextEdadNueva;

    public ModificarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modificar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //modificar
        editTextModificarUser = view.findViewById(R.id.editTextModificarUser);
        editTextNombreNuevo = view.findViewById(R.id.editTextNombreNuevo);
        editTextEdadNueva = view.findViewById(R.id.editTextEdadNueva);
        buttonModificar = view.findViewById(R.id.buttonModificar);

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextModificarUser.getText().toString().matches("") ||
                        editTextNombreNuevo.getText().toString().matches("") ||
                        editTextEdadNueva.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Inserte los datos para modificar", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    int id = Integer.parseInt(editTextModificarUser.getText().toString());
                    for (User u: CRUDUser.getAllUsers()) {
                        int id2 = u.getId();
                        if(id==id2) {
                            CRUDUser.updateUserById(Integer.parseInt(editTextModificarUser.getText().toString()),
                                    editTextNombreNuevo.getText().toString(),
                                    editTextEdadNueva.getText().toString());
                            Toast.makeText(getActivity(), "El usuario ha sido modificado con exito", Toast.LENGTH_SHORT).show();
                            return;
                        } else{
                            Toast.makeText(getActivity(), "ID del usuario no encontrado", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            }
        });
    }
}
