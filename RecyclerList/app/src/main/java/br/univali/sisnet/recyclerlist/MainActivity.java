package br.univali.sisnet.recyclerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> list = new ArrayList<>();

        list.add(new Person("André", 20));
        list.add(new Person("Ana", 22));
        list.add(new Person("Luan", 69));
        list.add(new Person("Lúcifer", 666));

        for (int i = 1; i <= 100; i++) {
            list.add(new Person("Person #" + i, i));
        }

        RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
        PersonAdapter adapter = new PersonAdapter(list);

        rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvList.setAdapter(adapter);

    }
}
