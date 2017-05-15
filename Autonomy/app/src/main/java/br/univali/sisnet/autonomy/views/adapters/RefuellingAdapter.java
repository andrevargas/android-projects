package br.univali.sisnet.autonomy.views.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.views.holders.RefuellingViewHolder;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;

public class RefuellingAdapter extends RecyclerView.Adapter<RefuellingViewHolder> {

    private List<Refuelling> refuellingList;

    public RefuellingAdapter(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    @Override
    public RefuellingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.refuelling_item, null);
        return new RefuellingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RefuellingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return refuellingList.size();
    }
}
