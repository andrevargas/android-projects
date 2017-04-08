package sisnet.univali.br.calculadora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String ADDITION = "ADDITION";
    private static final String SUBTRACTION = "SUBTRACTION";
    private static final String MULTIPLICATION = "MULTIPLICATION";
    private static final String DIVISION = "DIVISION";

    private EditText etFirstOperand;
    private EditText etSecondOperand;
    private RadioGroup rgOperations;
    private TextView tvResult;

    private Double firstOperand;
    private Double secondOperand;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etFirstOperand = (EditText) findViewById(R.id.etFirstOperand);
        etSecondOperand = (EditText) findViewById(R.id.etSecondOperand);
        rgOperations = (RadioGroup) findViewById(R.id.rgOperations);
        tvResult = (TextView) findViewById(R.id.tvResult);

    }

    public void calculate(View target) {

        tvResult.setText("");

        if (!validateOperands()) return;
        if (!validateOperation()) return;

        Double result;

        switch (operation) {
            case ADDITION:
                result = firstOperand + secondOperand;
                break;
            case SUBTRACTION:
                result = firstOperand - secondOperand;
                break;
            case MULTIPLICATION:
                result = firstOperand * secondOperand;
                break;
            case DIVISION:
                result = firstOperand / secondOperand;
                break;
            default:
                result = 0.0;
                break;
        }

        tvResult.setText(getResources().getString(R.string.result_info, result));

    }

    private boolean validateOperands() {

        Resources res = getResources();

        if (etFirstOperand.getText().length() < 1) {
            Toast.makeText(this, res.getString(R.string.first_operand_null_warning), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etSecondOperand.getText().length() < 1) {
            Toast.makeText(this, res.getString(R.string.second_operand_null_warning), Toast.LENGTH_SHORT).show();
            return false;
        }

        firstOperand = Double.parseDouble(etFirstOperand.getText().toString());
        secondOperand = Double.parseDouble(etSecondOperand.getText().toString());

        return true;

    }

    private boolean validateOperation() {

        int checkedRadioId = rgOperations.getCheckedRadioButtonId();

        switch (checkedRadioId) {
            case R.id.rbAddition:
                operation = ADDITION;
                break;
            case R.id.rbSubtraction:
                operation = SUBTRACTION;
                break;
            case R.id.rbMultiplication:
                operation = MULTIPLICATION;
                break;
            case R.id.rbDivision:
                operation = DIVISION;
                break;
            default:
                operation = null;
        }

        Resources res = getResources();

        if (operation == null) {
            Toast.makeText(this, res.getString(R.string.operation_null_warning), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (secondOperand == 0.0 && DIVISION.equals(operation)) {
            Toast.makeText(this, res.getString(R.string.division_by_zero_warning), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }

}
