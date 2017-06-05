package br.univali.sisnet.autonomy.views.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.fragments.RefuellingListFragment;
import br.univali.sisnet.autonomy.views.holders.RefuellingViewHolder;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;

public class RefuellingAdapter extends RecyclerView.Adapter<RefuellingViewHolder> {

    private List<Refuelling> refuellingList;
    private RefuellingListFragment.OnItemSelectedListener listener;

    public RefuellingAdapter(RefuellingListFragment.OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public void setList(List<Refuelling> list) {
        refuellingList = list;
    }

    @Override
    public RefuellingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.item_refuelling, parent, false);
        return new RefuellingViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RefuellingViewHolder holder, int position) {
        holder.renderItem(refuellingList.get(position));
    }

    @Override
    public int getItemCount() {
        return refuellingList.size();
    }

}
