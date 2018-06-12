package com.verity.datlashiv.adminpanel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner s1, s2, s3;
    private DatabaseReference reference;
    private Button btn_Submit;
    ArrayList<Model> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s3 = (Spinner) findViewById(R.id.spinner3);
       btn_Submit = (Button)findViewById(R.id.btnsubmit);

       reference = FirebaseDatabase.getInstance().getReference().child("userinfo");
       modelArrayList = new ArrayList<>();

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

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = s1.getSelectedItem().toString();
                String subcategory = s2.getSelectedItem().toString();
                String topic = s3.getSelectedItem().toString();
                int position = 0;

                if(category.equals("-- Select Category--")|| subcategory.equals("- -Select Subcategory- -") ||  topic.equals("--Select Topic--")){
                    Toast.makeText(MainActivity.this, "please select the fields", Toast.LENGTH_SHORT).show();

                }else{
                    String id = reference.push().getKey();
               Model model = new Model(id, category,subcategory,topic);
                reference.child(id).setValue(model);
                Intent i = new Intent(MainActivity.this,PdfActivity.class);
                startActivity(i);
            }}
        });


    }

}
