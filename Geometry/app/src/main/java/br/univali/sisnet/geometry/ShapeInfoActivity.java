package br.univali.sisnet.geometry;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShapeInfoActivity extends AppCompatActivity {

    private EditText etRadius;
    private EditText etBase;
    private EditText etHeight;

    private String shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_info);

        etRadius = (EditText) findViewById(R.id.etRadius);
        etBase = (EditText) findViewById(R.id.etBase);
        etHeight = (EditText) findViewById(R.id.etHeight);

        shape = getIntent().getStringExtra("shape");

        configUiForShape(shape);

    }

    public void configUiForShape(String shape) {

        TextView tvShapeInfo = (TextView) findViewById(R.id.tvShapeInfo);
        TextView tvRadius = (TextView) findViewById(R.id.tvRadius);
        TextView tvBase = (TextView) findViewById(R.id.tvBase);
        TextView tvHeight = (TextView) findViewById(R.id.tvHeight);

        switch (shape) {
            case "square":
                tvShapeInfo.setText(getResources().getString(R.string.shape_info, "quadrado"));
                tvRadius.setVisibility(View.INVISIBLE);
                etRadius.setVisibility(View.INVISIBLE);
                tvBase.setVisibility(View.VISIBLE);
                etBase.setVisibility(View.VISIBLE);
                tvHeight.setVisibility(View.VISIBLE);
                etHeight.setVisibility(View.VISIBLE);
                break;
            case "triangle":
                tvShapeInfo.setText(getResources().getString(R.string.shape_info, "triângulo"));
                tvRadius.setVisibility(View.INVISIBLE);
                etRadius.setVisibility(View.INVISIBLE);
                tvBase.setVisibility(View.VISIBLE);
                etBase.setVisibility(View.VISIBLE);
                tvHeight.setVisibility(View.VISIBLE);
                etHeight.setVisibility(View.VISIBLE);
                break;
            case "circle":
                tvShapeInfo.setText(getResources().getString(R.string.shape_info, "círculo"));
                tvRadius.setVisibility(View.VISIBLE);
                etRadius.setVisibility(View.VISIBLE);
                tvBase.setVisibility(View.INVISIBLE);
                etBase.setVisibility(View.INVISIBLE);
                tvHeight.setVisibility(View.INVISIBLE);
                etHeight.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }

    }

    private Double getResult() {

        Double radius;
        Double base;
        Double height;

        switch (shape) {
            case Constants.SQUARE:
                base = Double.parseDouble(etBase.getText().toString());
                height = Double.parseDouble(etHeight.getText().toString());
                return base * height;
            case Constants.TRIANGLE:
                base = Double.parseDouble(etBase.getText().toString());
                height = Double.parseDouble(etHeight.getText().toString());
                return (base * height) / 2;
            case Constants.CIRCLE:
                radius = Double.parseDouble(etRadius.getText().toString());
                return Math.PI * Math.pow(radius, 2);
            default:
                return null;
        }

    }

    public void next(View target) {

        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra("shape", shape);
        intent.putExtra("result", getResult());

        startActivity(intent);

    }

}
