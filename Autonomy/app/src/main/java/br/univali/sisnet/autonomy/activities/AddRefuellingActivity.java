package br.univali.sisnet.autonomy.activities;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.GasStation.GasStation;
import br.univali.sisnet.autonomy.domain.GasStation.GasStationDao;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.domain.Refuelling.RefuellingDao;

public class AddRefuellingActivity extends AppCompatActivity {

    private EditText etCurrentMilleage;
    private EditText etLitersRefuelled;
    private EditText etRefuellingDate;
    private Spinner spGasStation;

    private Calendar selectedDate = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_refuelling);

        etCurrentMilleage = (EditText) findViewById(R.id.etCurrentMilleage);
        etLitersRefuelled = (EditText) findViewById(R.id.etLitersRefuelled);
        etRefuellingDate = (EditText) findViewById(R.id.etRefuellingDate);
        spGasStation = (Spinner) findViewById(R.id.spGasStation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(getString(R.string.add_refuelling));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        setupSpinnerOptions();

    }

    private void setupSpinnerOptions() {

        List<String> gasStationNamesList = new ArrayList<>();
        gasStationNamesList.add(getString(R.string.select_gas_station));

        for (GasStation item : GasStationDao.getInstance().getAll()) {
            gasStationNamesList.add(item.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            R.layout.support_simple_spinner_dropdown_item,
            gasStationNamesList
        );

        spGasStation.setAdapter(adapter);

    }

    public void openDatePicker(View target) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectedDate.set(Calendar.YEAR, year);
                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateValue();
            }
        };

        new DatePickerDialog(
            this,
            listener,
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        ).show();

    }

    private void updateDateValue() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        etRefuellingDate.setText(dateFormat.format(selectedDate.getTime()));
    }

    public void onClickAdd(View target) {

        Refuelling refuelling = new Refuelling();
        GasStation gasStation = GasStationDao.getInstance().get(1);

        refuelling.setCurrentMileage(Integer.valueOf(etCurrentMilleage.getText().toString()));
        refuelling.setLitersRefuelled(Integer.valueOf(etLitersRefuelled.getText().toString()));
        refuelling.setRefuellingDate(selectedDate);
        refuelling.setGasStation(gasStation);

        RefuellingDao.getInstance().save(refuelling);

    }

}
