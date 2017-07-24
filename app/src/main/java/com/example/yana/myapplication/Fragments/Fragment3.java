package com.example.yana.myapplication.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.yana.myapplication.R;

/**
 * Created by yana on 24.07.2017.
 */

public class Fragment3 extends Fragment {
    private Button mOkButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3_main,container,false);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mOkButton = (Button) getView().findViewById(R.id.ok_button_fragment3);
        mOkButton .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getFragmentManager().popBackStack();
            }
        });

    }
}
