package br.univali.sisnet.geometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String shape = getIntent().getStringExtra("shape");
        Double result = getIntent().getDoubleExtra("result", 0);

        ImageView ivShape = (ImageView) findViewById(R.id.ivShape);
        TextView tvResultArea = (TextView) findViewById(R.id.tvResultArea);

        switch (shape) {
            case Constants.SQUARE:
                ivShape.setImageResource(R.drawable.ic_stop_black_24dp);
                break;
            case Constants.TRIANGLE:
                ivShape.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                break;
            case Constants.CIRCLE:
                ivShape.setImageResource(R.drawable.ic_brightness_1_black_24dp);
                break;
            default:
                break;
        }

        tvResultArea.setText(getResources().getString(R.string.result_area, result));

    }

    public void startAgain(View target) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);

    }
}
