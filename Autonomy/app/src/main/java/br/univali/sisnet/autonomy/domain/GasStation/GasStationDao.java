package br.univali.sisnet.autonomy.domain.GasStation;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.univali.sisnet.autonomy.infra.AutonomyDbHelper;

public class GasStationDao {

    private AutonomyDbHelper dbHelper;
    private static GasStationDao instance;

    private GasStationDao(Context context) {
        dbHelper = AutonomyDbHelper.getInstance(context);
    }

    public static GasStationDao getInstance(Context context) {
        if (instance == null) {
            instance = new GasStationDao(context);
        }
        return  instance;
    }

    public void save(GasStation gasStation) {
        gasStationList.add(gasStation);
    }

    public GasStation get(long id) {
        for (GasStation item: gasStationList) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public List<GasStation> getAll() {
        return gasStationList;
    }

}
