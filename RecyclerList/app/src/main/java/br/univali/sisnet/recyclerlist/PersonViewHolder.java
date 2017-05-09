package br.univali.sisnet.recyclerlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvAge;

    PersonViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvAge = (TextView) itemView.findViewById(R.id.tvAge);
    }

    void updateContent(Person person) {
        tvName.setText(person.getName());
        tvAge.setText(String.valueOf(person.getAge()));
    }

}
