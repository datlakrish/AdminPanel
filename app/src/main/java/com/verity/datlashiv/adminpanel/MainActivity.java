package com.verity.datlashiv.adminpanel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spi, spi2;
    String result[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spi = (Spinner) findViewById(R.id.cat);
        spi2 = (Spinner) findViewById(R.id.sub_cat);

        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    result = new String[]{"Linux", "Windows", "Mac"};
                }
                if (position == 1) {
                    result = new String[]{"Java", "Php", ".NET"};
                }
                if (position == 2) {
                    result = new String[]{"SQL", "Orcle", "MySql"};
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
