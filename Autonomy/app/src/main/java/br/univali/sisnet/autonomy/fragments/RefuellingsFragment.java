package br.univali.sisnet.autonomy.fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;


public class RefuellingsFragment extends Fragment
    implements RefuellingListFragment.OnItemSelectedListener {

    public RefuellingsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refuellings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentTransaction transaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.flFragmentMain, new RefuellingListFragment());

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.flFragmentSecondary, new RefuellingDetailFragment());
        }

        transaction.commit();

    }

    @Override
    public void onItemSelected(Refuelling refuelling) {

        FragmentTransaction transaction = getActivity()
            .getSupportFragmentManager()
            .beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putSerializable("refuelling", refuelling);

        RefuellingDetailFragment detailFragment = new RefuellingDetailFragment();
        detailFragment.setArguments(bundle);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.flFragmentSecondary, detailFragment);
        } else {
            transaction.replace(R.id.flFragmentMain, detailFragment);
            transaction.addToBackStack(null);
        }

        transaction.commit();

    }
}
