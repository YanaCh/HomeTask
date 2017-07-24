package com.example.yana.myapplication.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.yana.myapplication.R;

/**
 * Created by yana on 24.07.2017.
 */

public class Fragment1 extends Fragment {
    private Button mRejectButton;
    private Button mConfirmButton;
    private EditText mInputEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1_main,container,false);

        mInputEditText = (EditText) v.findViewById(R.id.input_edit_text);
        return v;
    }
    private void switchAnotherFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mConfirmButton = (Button) getView().findViewById(R.id.confirm_button);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment2 fragment2 = new Fragment2();
                switchAnotherFragment(fragment2);


            }
        });

        mRejectButton = (Button) getView().findViewById(R.id.reject_button);
        mRejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 fragment3 = new Fragment3();
                switchAnotherFragment(fragment3);

            }
        });

    }
}
