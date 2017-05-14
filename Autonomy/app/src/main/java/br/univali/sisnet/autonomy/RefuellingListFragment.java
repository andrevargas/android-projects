package br.univali.sisnet.autonomy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RefuellingListFragment extends Fragment implements View.OnClickListener {

    public RefuellingListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_refuelling_list, container, false);
        view.findViewById(R.id.btAddRefuelling).setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AddRefuellingActivity.class);
        getActivity().startActivity(intent);
    }

}
