package br.univali.sisnet.autonomy.activities;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.univali.sisnet.autonomy.R;
import br.univali.sisnet.autonomy.domain.GasStation.GasStationDao;
import br.univali.sisnet.autonomy.domain.Refuelling.Refuelling;
import br.univali.sisnet.autonomy.domain.Refuelling.RefuellingDao;

public class AddRefuellingActivity extends AppCompatActivity {

    private EditText etCurrentMileage;
    private EditText etLitersRefuelled;
    private EditText etRefuellingDate;
    private Spinner spGasStation;

    private final Calendar selectedDate = Calendar.getInstance();
    private final RefuellingDao dao = RefuellingDao.getInstance();

    private Refuelling newInstance = new Refuelling();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_refuelling);

        etCurrentMileage = (EditText) findViewById(R.id.etCurrentMileage);
        etLitersRefuelled = (EditText) findViewById(R.id.etLitersRefuelled);
        etRefuellingDate = (EditText) findViewById(R.id.etRefuellingDate);
        spGasStation = (Spinner) findViewById(R.id.spGasStation);

        setupToolbar();
        updateDateValue();

    }

    private void setupToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(getString(R.string.add_refuelling));

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            toolbar.setNavigationOnClickListener(v -> {
                onBackPressed();
            });
        }

    }

    public void openDatePicker(View target) {

        DatePickerDialog.OnDateSetListener listener = (view, year, month, dayOfMonth) -> {
            selectedDate.set(Calendar.YEAR, year);
            selectedDate.set(Calendar.MONTH, month);
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDateValue();
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
        if (!validateFields()) return;
        dao.save(newInstance);
        finish();
    }

    private boolean validateFields() {
        return
            validateCurrentMileage() &&
            validateLitersRefuelled() &&
            validateRefuellingDate() &&
            validateGasStation();
    }

    private boolean validateCurrentMileage() {

        TextInputLayout tilCurrentMileage = (TextInputLayout) findViewById(R.id.tilCurrentMileage);

        if (etCurrentMileage.getText().length() == 0) {
            tilCurrentMileage.setError(getString(R.string.error_value_null));
            return false;
        }

        Double currentMileage = Double.parseDouble(etCurrentMileage.getText().toString());
        List<Refuelling> refuellings = dao.getAll();

        if (refuellings.size() >= 1) {
            Refuelling lastRefuelling = refuellings.get(refuellings.size() - 1);
            if (currentMileage < lastRefuelling.getCurrentMileage()) {
                tilCurrentMileage.setError(getString(R.string.error_mileage_less_than_last));
                return false;
            }
        }

        newInstance.setCurrentMileage(currentMileage);
        return true;

    }

    private boolean validateLitersRefuelled() {

        TextInputLayout tilLitersRefuelled = (TextInputLayout) findViewById(R.id.tilLitersRefuelled);

        if (etLitersRefuelled.getText().length() == 0) {
            tilLitersRefuelled.setError(getString(R.string.error_value_null));
            return false;
        }

        Double litersRefuelled = Double.parseDouble(etLitersRefuelled.getText().toString());
        newInstance.setLitersRefuelled(litersRefuelled);
        return true;
    }

    private boolean validateRefuellingDate() {
        newInstance.setRefuellingDate(selectedDate);
        return true;
    }

    private boolean validateGasStation() {

        String[] valuesArray = getResources().getStringArray(R.array.gas_station_values);
        int position = spGasStation.getSelectedItemPosition();
        int gasStationId = Integer.valueOf(valuesArray[position]);

        if (gasStationId > 0) {
            newInstance.setGasStation(GasStationDao.getInstance().get(gasStationId));
            return true;
        }

        return false;

    }

}
