package br.univali.sisnet.autonomy.views.holders;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.fragments.RefuellingListFragment;


public class RefuellingViewHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private Refuelling selectedItem;

    private final ImageView ivLogo;
    private final TextView tvRefuellingDate;
    private final TextView tvCurrentMileage;
    private final TextView tvLitersRefuelled;

    public RefuellingViewHolder(View itemView,
        RefuellingListFragment.OnItemSelectedListener listener) {

        super(itemView);

        itemView.setOnClickListener(v -> listener.onItemSelected(selectedItem));
        context = itemView.getContext();

        ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
        tvRefuellingDate = (TextView) itemView.findViewById(R.id.tvRefuellingDate);
        tvCurrentMileage = (TextView) itemView.findViewById(R.id.tvCurrentMileage);
        tvLitersRefuelled = (TextView) itemView.findViewById(R.id.tvLitersRefuelled);

    }

    public void renderItem(Refuelling item) {

        selectedItem = item;

        Resources res = context.getResources();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            ivLogo.setImageResource(getDrawableIdByName(item.getGasStation().getLogoSrc()));
        }

        tvRefuellingDate.setText(dateFormat.format(item.getRefuellingDate().getTime()));

        tvCurrentMileage.setText(
            res.getString(
                R.string.display_current_mileage,
                item.getCurrentMileage()
            )
        );

        tvLitersRefuelled.setText(
            res.getString(
                R.string.display_liters_refuelled,
                item.getLitersRefuelled()
            )
        );

    }

    private int getDrawableIdByName(String drawableName) {
        final Resources res = context.getResources();
        return res.getIdentifier(drawableName, "drawable", context.getPackageName());
    }

}
