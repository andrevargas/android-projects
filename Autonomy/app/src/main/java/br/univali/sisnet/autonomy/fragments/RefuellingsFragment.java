package br.univali.sisnet.autonomy.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.univali.sisnet.autonomy.R;


public class RefuellingsFragment extends Fragment {

    public RefuellingsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refuellings, container, false);
    }

}
