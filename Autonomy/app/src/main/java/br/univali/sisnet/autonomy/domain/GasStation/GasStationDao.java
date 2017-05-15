package br.univali.sisnet.autonomy.domain.GasStation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public GasStation get(long id) {
        return gasStationList
            .stream()
            .filter(item -> item.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public List<GasStation> getAll() {
        return gasStationList;
    }

}
