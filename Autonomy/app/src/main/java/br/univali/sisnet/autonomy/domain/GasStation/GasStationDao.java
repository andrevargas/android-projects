package br.univali.sisnet.autonomy.domain.GasStation;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", gasStation.getName());
        values.put("logo_src", gasStation.getLogoSrc());

        db.insert("gas_station", null, values);
        db.close();

    }

    public GasStation get(long id) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        GasStation gasStation = null;

        String[] columns = { "id", "name", "logo_src" };
        String where = "id = ?";
        String[] whereValues = { String.valueOf(id) };

        Cursor cursor = db.query("gas_station", columns, where, whereValues, null, null, null);

        if (cursor.moveToFirst()) {
            gasStation = new GasStation(
                cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2)
            );
        }

        cursor.close();
        db.close();

        return gasStation;

    }

}
