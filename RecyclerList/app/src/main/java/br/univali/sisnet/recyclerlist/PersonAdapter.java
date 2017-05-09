package br.univali.sisnet.recyclerlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newitem = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_person, null);
        return new PersonViewHolder(newitem);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            }
        };
        holder.updateContent(personList.get(position));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

}
