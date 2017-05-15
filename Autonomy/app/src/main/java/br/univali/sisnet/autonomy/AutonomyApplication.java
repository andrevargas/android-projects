package br.univali.sisnet.autonomy;

import android.app.Application;

import java.util.Calendar;

import br.univali.sisnet.autonomy.domain.GasStation.GasStation;
import br.univali.sisnet.autonomy.domain.GasStation.GasStationDao;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.domain.Refuelling.RefuellingDao;

public class AutonomyApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        GasStationDao dao = GasStationDao.getInstance();

        dao.save(new GasStation(1, "Texaco", R.drawable.logo_texaco));
        dao.save(new GasStation(2, "Shell", R.drawable.logo_shell));
        dao.save(new GasStation(3, "Petrobras", R.drawable.logo_petrobras));
        dao.save(new GasStation(4, "Ipiranga", R.drawable.logo_ipiranga));
        dao.save(new GasStation(5, "Outros", R.drawable.logo_others));

    }

}
