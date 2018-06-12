package com.verity.datlashiv.adminpanel;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s3 = (Spinner) findViewById(R.id.spinner3);

        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position==0) {
                    String[] list = {"- -Select Subcategory- -"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter);

                }
                if (position == 1) {
                    String[] list = {"Linux", "Mac", "Windows"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter);
                }
                if (position == 2) {
                    String[] list = {"C", "C#", "Java"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter);
                }
                if (position == 3) {
                    String[] list = {"Orcle", "SQL", "MongoDB"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        s2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String result = (String) parent.getSelectedItem();

                if (position==0) {
                    String[] list = {"--Select Topic--"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);

                }


                if (result.matches("Linux")) {
                    String[] list = {"Linux Directories ", "Linux Files", "Linux Man Pages"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }
                if (result.matches("Mac")) {
                    String[] list = {"Mac Directories", "Mac Files", "Mac Man Pages"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }
                if (result.matches("Windows")) {
                    String[] list = {"Windows 7", "Windows 8", "Windows 10"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }

                if (result.matches("C")) {
                    String[] list = {"Arrays", "Functions", "Control Statements"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }
                if (result.matches("C#")) {
                    String[] list = {"C# Object Class", "C# Inheritance", "C# Polymorphism"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }
                if (result.matches("Java")) {
                    String[] list = {"OOPS", "Collections", "Exception Handling"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }


                if (result.matches("Orcle")) {
                    String[] list = {"Oracle Tables", "Oracle Views", "Oracle Query"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }
                if (result.matches("SQL")) {
                    String[] list = {"SQL Database", "SQL Table", "SQL Select"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }
                if (result.matches("MongoDB")) {
                    String[] list = {"CRUD: Documents", "Miscellaneous", "Connectivity"};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
                    dataAdapter.notifyDataSetChanged();
                    s3.setAdapter(dataAdapter);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
