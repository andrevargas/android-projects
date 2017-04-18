package br.univali.sisnet.geometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgShapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgShapes = (RadioGroup) findViewById(R.id.rgShapes);

    }

    public void next(View target) {

        String shape = null;

        switch (rgShapes.getCheckedRadioButtonId()) {
            case R.id.rbSquare:
                shape = Constants.SQUARE;
                break;
            case R.id.rbTriangle:
                shape = Constants.TRIANGLE;
                break;
            case R.id.rbCircle:
                shape = Constants.CIRCLE;
                break;
            default:
                break;
        }

        Intent intent = new Intent(this, ShapeInfoActivity.class);
        intent.putExtra("shape", shape);

        startActivity(intent);

    }

}
