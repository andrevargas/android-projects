package br.univali.sisnet.autonomy.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.utils.Util;


public class RefuellingDetailFragment extends Fragment {

    public RefuellingDetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refuelling_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        if (getArguments() == null) {
            TextView tvNoItemSelected = (TextView) view.findViewById(R.id.tvNoItemSelected);
            LinearLayout llRefuellingInfo = (LinearLayout) view.findViewById(R.id.llRefuellingInfo);
            if (tvNoItemSelected != null && llRefuellingInfo != null) {
                tvNoItemSelected.setVisibility(View.VISIBLE);
                llRefuellingInfo.setVisibility(View.GONE);
            }
            return;
        }

        Resources res = getContext().getResources();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Refuelling refuelling = (Refuelling) getArguments().getSerializable("refuelling");

        ImageView ivGasStationLogo = (ImageView) view.findViewById(R.id.ivGasStationLogo);
        TextView tvGasStationName = (TextView) view.findViewById(R.id.tvGasStationName);
        TextView tvRefuellingDate = (TextView) view.findViewById(R.id.tvRefuellingDate);
        TextView tvCurrentMileage = (TextView) view.findViewById(R.id.tvCurrentMileage);
        TextView tvLitersRefuelled = (TextView) view.findViewById(R.id.tvLitersRefuelled);

        ivGasStationLogo.setImageResource(
            Util.getDrawableIdByName(getContext(),
            refuelling.getGasStation().getLogoSrc())
        );

        tvGasStationName.setText(refuelling.getGasStation().getName());
        tvRefuellingDate.setText(dateFormat.format(refuelling.getRefuellingDate().getTime()));

        tvCurrentMileage.setText(
            res.getString(
                R.string.display_current_mileage,
                refuelling.getCurrentMileage()
            )
        );

        tvLitersRefuelled.setText(
            res.getString(
                R.string.display_liters_refuelled,
                refuelling.getLitersRefuelled()
            )
        );

    }
}
