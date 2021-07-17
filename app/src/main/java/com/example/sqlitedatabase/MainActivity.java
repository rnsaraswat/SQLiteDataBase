package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Ravi", "Start 1");

        mydb = new DBHelper(MainActivity.this);
        ArrayList array_list = mydb.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        Log.d("Ravi", "Start 2");

        obj = (ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Log.d("Ravi", "Start 3");
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Log.d("Ravi", "Start 4");
                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);

                Log.d("Ravi", "Start 5");
                intent.putExtras(dataBundle);
                startActivity(intent);
                Log.d("Ravi", "Start 6");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Log.d("Ravi", "onCreateOptionsMenu Start 7");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("Ravi", "onCreateOptionsMenu Start 8");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        Log.d("Ravi", "onOptionsItemSelected Start 9");


        switch(item.getItemId()) {
            case R.id.item1:Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Log.d("Ravi", "onOptionsItemSelected Start 10");
                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
                intent.putExtras(dataBundle);
                Log.d("Ravi", "onOptionsItemSelected Start 11");
                startActivity(intent);
                return true;
            default:
                Log.d("Ravi", "onOptionsItemSelected Start 12");
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        Log.d("Ravi", "onKeyDown Start 13");
        if (keycode == KeyEvent.KEYCODE_BACK) {
            Log.d("Ravi", "onKeyDown Start 14");
            moveTaskToBack(true);
        }
        Log.d("Ravi", "onKeyDown Start 15");
        return super.onKeyDown(keycode, event);
    }
}