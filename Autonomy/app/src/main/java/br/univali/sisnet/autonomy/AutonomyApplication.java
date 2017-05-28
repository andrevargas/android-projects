package br.univali.sisnet.autonomy;

import android.app.Application;
import android.content.res.Resources;

import java.util.Calendar;

import br.univali.sisnet.autonomy.domain.GasStation.GasStation;
import br.univali.sisnet.autonomy.domain.GasStation.GasStationDao;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.domain.Refuelling.RefuellingDao;

public class AutonomyApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        Resources res = getResources();
        GasStationDao dao = GasStationDao.getInstance(getApplicationContext());

        dao.save(new GasStation(1, "Texaco", res.getResourceEntryName(R.drawable.logo_texaco)));
        dao.save(new GasStation(2, "Shell", res.getResourceEntryName(R.drawable.logo_shell)));
        dao.save(new GasStation(3, "Petrobras", res.getResourceEntryName(R.drawable.logo_petrobras)));
        dao.save(new GasStation(4, "Ipiranga", res.getResourceEntryName(R.drawable.logo_ipiranga)));
        dao.save(new GasStation(5, "Outros", res.getResourceEntryName(R.drawable.logo_others)));

    }

}
