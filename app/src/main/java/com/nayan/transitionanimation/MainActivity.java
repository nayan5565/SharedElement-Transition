package com.nayan.transitionanimation;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Model> arrayList;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        model = new Model();
        model.setColor(Color.GRAY);
        model.setDesc(getString(R.string.android));
        model.setHeader("Android");
        model.setSub("Java");
        arrayList.add(model);

        model = new Model();
        model.setColor(Color.RED);
        model.setDesc(getString(R.string.ios));
        model.setHeader("ios");
        model.setSub("Swift");
        arrayList.add(model);

        model = new Model();
        model.setColor(Color.YELLOW);
        model.setDesc(getString(R.string.phonegap));
        model.setHeader("PhoneGap");
        model.setSub("HTML CSS and JScript");
        arrayList.add(model);

        model = new Model();
        model.setColor(Color.MAGENTA);
        model.setDesc(getString(R.string.xamarin));
        model.setHeader("Xamarin");
        model.setSub("C#");
        arrayList.add(model);

//        final ArrayList<String[]> values = new ArrayList<String[]>();
//        values.add(new String[]{"Android", "Java", getString(R.string.android), '#' + Integer.toHexString(getResources().getColor(R.color.md_light_green_900))});
//        values.add(new String[]{"iOS", "Swift", getString(R.string.ios), '#' + Integer.toHexString(getResources().getColor(R.color.md_amber_A700))});
//        values.add(new String[]{"Xamarin", "C#", getString(R.string.xamarin), '#' + Integer.toHexString(getResources().getColor(R.color.md_pink_A700))});
//        values.add(new String[]{"PhoneGap", "HTML CSS and JScript", getString(R.string.phonegap), '#' + Integer.toHexString(getResources().getColor(R.color.md_brown_800))});


        ListView listView = (ListView) findViewById(R.id.list_view);
        CustomAdapter adapter = new CustomAdapter(this, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("array", values.get(position));
                intent.putExtra("pos",position);
                // Get the transition name from the string
//                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options =

                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                                view,   // Starting view
                                "transit"    // The String
                        );
//                startActivity(intent);

                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });
    }
}
