package br.univali.sisnet.autonomy.views.holders;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;


public class RefuellingViewHolder extends RecyclerView.ViewHolder {

    private final Context context;

    private final ImageView ivLogo;
    private final TextView tvRefuellingDate;
    private final TextView tvCurrentMilleage;
    private final TextView tvLitersRefuelled;

    public RefuellingViewHolder(View itemView) {

        super(itemView);

        context = itemView.getContext();

        ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
        tvRefuellingDate = (TextView) itemView.findViewById(R.id.tvRefuellingDate);
        tvCurrentMilleage = (TextView) itemView.findViewById(R.id.tvCurrentMilleage);
        tvLitersRefuelled = (TextView) itemView.findViewById(R.id.tvLitersRefuelled);

    }

    public void renderItem(Refuelling item) {

        Resources res = context.getResources();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        ivLogo.setImageResource(item.getGasStation().getLogoSrc());
        tvRefuellingDate.setText(dateFormat.format(item.getRefuellingDate().getTime()));

        tvCurrentMilleage.setText(
            res.getString(
                R.string.display_current_milleage,
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

}
