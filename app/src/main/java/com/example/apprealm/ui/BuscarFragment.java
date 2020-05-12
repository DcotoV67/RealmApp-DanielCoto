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
import com.example.apprealm.model.Patin;

public class BuscarFragment extends Fragment {

    private Button btn_Buscar;
    private EditText etBuscarMarca;

    private TextView buscarPatintextView;

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
        etBuscarMarca = view.findViewById(R.id.buscarMarcaEditText);
        btn_Buscar = view.findViewById(R.id.btn_buscar);
        buscarPatintextView = view.findViewById(R.id.buscarPatinTextView);
        buscarPatintextView.setVisibility(TextView.INVISIBLE);

        btn_Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Patin patin = CRUDUser.getUserByName(etBuscarMarca.getText().toString());
                if (etBuscarMarca.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Escribe la marca que quieres buscar", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if(patin != null){
                        buscarPatintextView.setVisibility(TextView.VISIBLE);
                        buscarPatintextView.setText(patin.toString());
                    } else Toast.makeText(getActivity(), "No se ha encontrado la marca", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
