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
public class BorrarFragment extends Fragment {

    private Button btn_Borrar;
    private EditText etBorrarPatin;

    public BorrarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //borrar
        etBorrarPatin = view.findViewById(R.id.borrarPatinEditText);
        btn_Borrar = view.findViewById(R.id.btn_borrar);

        btn_Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etBorrarPatin.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "ID del patín a borrar", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    int id = Integer.parseInt(etBorrarPatin.getText().toString());
                    for (Patin u: CRUDUser.getAllPatins()) {
                        int id2 = u.getId();
                        if(id==id2) {
                            CRUDUser.deleteUserById(Integer.parseInt(etBorrarPatin.getText().toString()));
                            Toast.makeText(getActivity(), "Se ha borrado el patín", Toast.LENGTH_SHORT).show();
                            return;
                        } else{
                            Toast.makeText(getActivity(), "ID incorrecto, utiliza un ID valido", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            }
        });

    }
}
