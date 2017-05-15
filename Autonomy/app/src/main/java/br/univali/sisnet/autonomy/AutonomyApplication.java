package br.univali.sisnet.autonomy;

import android.app.Application;

import br.univali.sisnet.autonomy.domain.GasStation.GasStation;
import br.univali.sisnet.autonomy.domain.GasStation.GasStationDao;

public class AutonomyApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        GasStationDao dao = GasStationDao.getInstance();

        dao.save(new GasStation(1, "Texaco"));
        dao.save(new GasStation(2, "Shell"));
        dao.save(new GasStation(3, "Petrobras"));
        dao.save(new GasStation(4, "Ipiranga"));
        dao.save(new GasStation(5, "Outros"));

    }

}
