package br.univali.sisnet.autonomy.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.activities.AddRefuellingActivity;
import br.univali.sisnet.autonomy.domain.Refuelling.RefuellingDao;
import br.univali.sisnet.autonomy.views.adapters.RefuellingAdapter;


public class RefuellingListFragment extends Fragment implements View.OnClickListener {

    private RefuellingAdapter adapter = null;

    public RefuellingListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_refuelling_list, container, false);
        view.findViewById(R.id.btAddRefuelling).setOnClickListener(this);

        setupRecyclerView(view);

        return view;

    }

    public void setupRecyclerView(View itemView) {

        RecyclerView rvRefuellings = (RecyclerView) itemView.findViewById(R.id.rvRefuellings);

        Context context = getActivity().getApplicationContext();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        adapter = new RefuellingAdapter();
        adapter.setList(RefuellingDao.getInstance().getAll());

        rvRefuellings.setLayoutManager(layoutManager);
        rvRefuellings.setAdapter(adapter);

        TextView tvZeroData = (TextView) itemView.findViewById(R.id.tvZeroData);

        if (adapter.getItemCount() == 0) {
            rvRefuellings.setVisibility(View.GONE);
            tvZeroData.setVisibility(View.VISIBLE);
        } else {
            rvRefuellings.setVisibility(View.VISIBLE);
            tvZeroData.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AddRefuellingActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

}
