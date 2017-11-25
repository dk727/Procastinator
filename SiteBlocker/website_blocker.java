package com.example.dalyakhatun.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class website_blocker extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_blocker);
        final EditText url = (EditText)findViewById(R.id.url);

        Button deleteButton= (Button)findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String additem= url.getText().toString();
                arrayList.remove(additem);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Website is on", Toast.LENGTH_SHORT).show();

            }
        });

        Button gotogoogle = (Button)findViewById(R.id.google);
        gotogoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             googleMethod(url);
            }
        });
        listView = (ListView)findViewById(R.id.list);
        String [] website_lists = {};
        arrayList = new ArrayList<>(Arrays.asList(website_lists));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList );
        listView.setAdapter(adapter);
        Button add= (Button)findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //text.setText("working");
                String additem= url.getText().toString();
                arrayList.add(additem);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Website is blocked", Toast.LENGTH_SHORT).show();
                // block website

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                 Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position+1) + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void googleMethod(EditText url) {
        Intent i = new Intent(this, webview.class);
        i.putExtra("url",url.getText().toString());
        i.putExtra("list" , String.valueOf(adapter));
        startActivity(i);
    }

}
