package br.univali.sisnet.autonomy.infra;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AutonomyDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "autonomy.db";

    private static final String SQL_CREATE_GAS_STATION_TABLE =
        "CREATE TABLE gas_station (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "logo_src TEXT NOT NULL" +
        ")";

    private static final String SQL_CREATE_REFUELLING_TABLE =
        "CREATE TABLE refuelling (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "current_mileage NUMERIC NOT NULL," +
            "liters_refuelled NUMERIC NOT NULL," +
            "refuelling_date NUMERIC NOT NULL," +
            "gas_station_id INTEGER NOT NULL" +
        ")";

    private static final String SQL_INSERT_INITIAL_GAS_STATIONS =
        "INSERT INTO gas_station (id, name, logo_src) " +
        "VALUES (1, 'Texaco', 'logo_texaco'), " +
        "(2, 'Shell', 'logo_shell'), " +
        "(3, 'Petrobras', 'logo_petrobras'), " +
        "(4, 'Ipiranga', 'logo_ipiranga'), " +
        "(5, 'Outros', 'logo_others')";

    private static AutonomyDbHelper instance;

    public static AutonomyDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new AutonomyDbHelper(context);
        }
        return instance;
    }

    private AutonomyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GAS_STATION_TABLE);
        db.execSQL(SQL_CREATE_REFUELLING_TABLE);
        db.execSQL(SQL_INSERT_INITIAL_GAS_STATIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}
