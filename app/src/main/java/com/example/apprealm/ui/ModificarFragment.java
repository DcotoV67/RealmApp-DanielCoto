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
import com.example.apprealm.model.Patin;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModificarFragment extends Fragment {

    private Button btn_Modificar;

    private EditText editTextModificarPatin;
    private EditText editTextMarcaN;
    private EditText editTextModeloN;

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

        editTextModificarPatin = view.findViewById(R.id.editTextModificarPatin);
        editTextMarcaN = view.findViewById(R.id.editTextMarcaN);
        editTextModeloN = view.findViewById(R.id.editTextModeloN);
        btn_Modificar = view.findViewById(R.id.btn_modificar);

        btn_Modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextModificarPatin.getText().toString().matches("") ||
                        editTextMarcaN.getText().toString().matches("") ||
                        editTextModeloN.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Escribe la nueva marca y el nuevo modelo", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    int id = Integer.parseInt(editTextModificarPatin.getText().toString());
                    for (Patin u: CRUDUser.getAllPatins()) {
                        int id2 = u.getId();
                        if(id==id2) {
                            CRUDUser.updatePatinById(Integer.parseInt(editTextModificarPatin.getText().toString()),
                                    editTextMarcaN.getText().toString(),
                                    editTextModeloN.getText().toString());
                            Toast.makeText(getActivity(), "Se han realizado los cambios con exito", Toast.LENGTH_SHORT).show();
                            return;
                        } else{
                            Toast.makeText(getActivity(), "Error, ID incorrecto, no se ha encontrado el ID", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            }
        });
    }
}
