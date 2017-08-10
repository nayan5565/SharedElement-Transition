package com.nayan.transitionanimation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Nayan on 8/10/2017.
 */
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        String[] array = getIntent().getStringArrayExtra("array");
        int pos = getIntent().getIntExtra("pos", 0);
        Model model = MainActivity.arrayList.get(pos);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout);
//        rl.setBackgroundColor(Color.parseColor(array[3]));
        rl.setBackgroundColor(model.getColor());

        TextView textView = (TextView) findViewById(R.id.heading);
//        textView.setText(array[0]);
        textView.setText(model.getHeader());
        TextView type = (TextView) findViewById(R.id.language);
//        type.setText(array[1]);
        type.setText(model.getSub());
        TextView desc = (TextView) findViewById(R.id.desc);
//        desc.setText(array[2]);
        desc.setText(model.getDesc());

    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }
}
