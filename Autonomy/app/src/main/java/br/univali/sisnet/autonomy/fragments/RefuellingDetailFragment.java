package br.univali.sisnet.autonomy.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.univali.sisnet.autonomy.R;


public class RefuellingDetailFragment extends Fragment {

    public RefuellingDetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refuelling_detail, container, false);
    }

}
