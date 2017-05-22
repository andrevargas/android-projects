package br.univali.sisnet.autonomy.domain.Refuelling;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.univali.sisnet.autonomy.infra.AutonomyDbHelper;

public class RefuellingDao {

    private AutonomyDbHelper dbHelper;

    private final List<Refuelling> refuellingList = new ArrayList<>();
    private static RefuellingDao instance;

    private RefuellingDao(Context context) {
        dbHelper = new AutonomyDbHelper(context);
    }

    public static RefuellingDao getInstance(Context context) {
        if (instance == null) {
            instance = new RefuellingDao(context);
        }
        return instance;
    }

    public void save(Refuelling refuelling) {
        refuellingList.add(refuelling);
    }

    public Refuelling get(long id) {
        for (Refuelling item : refuellingList) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public List<Refuelling> getAll() {
        return refuellingList;
    }

}
