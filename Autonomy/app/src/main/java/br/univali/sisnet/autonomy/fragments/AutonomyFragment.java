package br.univali.sisnet.autonomy.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.domain.Refuelling.RefuellingDao;


public class AutonomyFragment extends Fragment {

    private TextView tvAutonomy;
    private Double currentAutonomy = 0.0;

    public AutonomyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_autonomy, container, false);
        tvAutonomy = (TextView) view.findViewById(R.id.tvAutonomy);

        calculateAutonomy();
        updateValue();

        return view;

    }

    private void calculateAutonomy() {

        Context context = getActivity().getApplicationContext();
        List<Refuelling> refuellings = new ArrayList<>(RefuellingDao.getInstance(context).getAll());

        if (refuellings.size() > 0) {

            Refuelling lastRefuelling = refuellings.get(refuellings.size() - 1);
            Refuelling firstRefuelling = refuellings.get(0);

            Double totalMileage = lastRefuelling.getCurrentMileage() - firstRefuelling.getCurrentMileage();
            Double litersSum = 0.0;

            refuellings.remove(refuellings.size() - 1);

            for (Refuelling item : refuellings) {
                litersSum += item.getLitersRefuelled();
            }

            if (litersSum > 0) {
                currentAutonomy = totalMileage / litersSum;
            }

        }

    }

    public void updateValue() {
        tvAutonomy.setText(String.format("%.1f", currentAutonomy));
    }

    @Override
    public void onResume() {
        super.onResume();
        calculateAutonomy();
        updateValue();
    }
}
