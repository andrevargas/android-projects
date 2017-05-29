package br.univali.sisnet.autonomy.domain.Refuelling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.univali.sisnet.autonomy.domain.GasStation.GasStationDao;
import br.univali.sisnet.autonomy.infra.AutonomyDbHelper;

public class RefuellingDao {

    private AutonomyDbHelper dbHelper;
    private GasStationDao gasStationDao;
    private static RefuellingDao instance;

    private RefuellingDao(Context context) {
        gasStationDao = GasStationDao.getInstance(context);
        dbHelper = AutonomyDbHelper.getInstance(context);
    }

    public static RefuellingDao getInstance(Context context) {
        if (instance == null) {
            instance = new RefuellingDao(context);
        }
        return instance;
    }

    public void save(Refuelling refuelling) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("current_mileage", refuelling.getCurrentMileage());
        values.put("liters_refuelled", refuelling.getLitersRefuelled());
        values.put("refuelling_date", refuelling.getRefuellingDate().getTimeInMillis());
        values.put("gas_station_id", refuelling.getGasStation().getId());

        db.insert("refuelling", null, values);
        db.close();

    }

    public List<Refuelling> getAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Refuelling> refuellings = new ArrayList<>();

        String[] columns = {
            "id",
            "current_mileage",
            "liters_refuelled",
            "refuelling_date",
            "gas_station_id"
        };

        Cursor cursor = db.query("refuelling", columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {

                Refuelling refuelling = new Refuelling();

                refuelling.setId(cursor.getLong(0));
                refuelling.setCurrentMileage(cursor.getDouble(1));
                refuelling.setLitersRefuelled(cursor.getDouble(2));

                Calendar refuellingDate = Calendar.getInstance();
                refuellingDate.setTimeInMillis(cursor.getInt(3));
                refuelling.setRefuellingDate(refuellingDate);

                refuelling.setGasStation(gasStationDao.get(cursor.getLong(4)));

                refuellings.add(refuelling);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return refuellings;

    }

}
