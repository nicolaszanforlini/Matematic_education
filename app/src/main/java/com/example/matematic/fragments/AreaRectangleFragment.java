package com.example.matematic.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matematic.CalculArea;
import com.example.matematic.R;
import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AreaRectangleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AreaRectangleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AreaRectangleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AreaRectangleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AreaRectangleFragment newInstance(String param1, String param2) {
        AreaRectangleFragment fragment = new AreaRectangleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_area_rectangle, container, false);

        EditText editTextB = rootView.findViewById(R.id.inputB);
        EditText editTextA = rootView.findViewById(R.id.inputA);
        TextView textView = rootView.findViewById(R.id.txtResult);
        CalculArea calculArea = new CalculArea();

        MaterialButton btnCalcul = rootView.findViewById(R.id.btnCalcul);
        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    calculArea.areaRectangle(editTextB.getText().toString(), editTextA.getText().toString());
                    textView.setText(String.valueOf(calculArea.getResult()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        MaterialButton btnReset = rootView.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("0");
                editTextB.setText("0");
                editTextA.setText("0");
            }
        });

        MaterialButton btnHome = rootView.findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.frame)).commit();
                HomeFragment frag = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame, frag).commit();
            }
        });
    // test

        return rootView;
    }
}