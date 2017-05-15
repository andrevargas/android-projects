package br.univali.sisnet.autonomy.domain.Refuelling;

import java.util.ArrayList;
import java.util.List;

public class RefuellingDao {

    private final List<Refuelling> refuellingList = new ArrayList<>();
    private static RefuellingDao instance;

    private RefuellingDao() {}

    public static RefuellingDao getInstance() {
        if (instance == null) {
            instance = new RefuellingDao();
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
