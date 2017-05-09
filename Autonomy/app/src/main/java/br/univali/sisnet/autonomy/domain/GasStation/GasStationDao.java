package br.univali.sisnet.autonomy.domain.GasStation;


import java.util.ArrayList;
import java.util.List;

public class GasStationDao {

    private final List<GasStation> gasStationList = new ArrayList<>();
    private static GasStationDao instance;

    private GasStationDao() {}

    public static GasStationDao getInstance() {
        if (instance == null) {
            instance = new GasStationDao();
        }
        return  instance;
    }

    public void save(GasStation gasStation) {
        gasStationList.add(gasStation);
    }

    public GasStation get(int index) {
        return gasStationList.get(index);
    }

    public List<GasStation> getAll() {
        return gasStationList;
    }

}
