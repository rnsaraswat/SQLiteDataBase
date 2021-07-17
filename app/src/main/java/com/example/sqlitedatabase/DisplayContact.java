package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayContact extends AppCompatActivity  {

    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb ;

    TextView name;
    TextView midname;
    TextView surname;
    TextView email;
    TextView houseno;
    TextView building;
    TextView street;
    TextView area;
    TextView place;
    TextView phone;
    TextView homephone;
    TextView mob1phone;
    TextView mob2phone;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        name = (TextView) findViewById(R.id.editTextName);
        midname = (TextView) findViewById(R.id.editTextMidName);
        surname = (TextView) findViewById(R.id.editTextSurName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        homephone = (TextView) findViewById(R.id.editTextHomePhone);
        mob1phone = (TextView) findViewById(R.id.editTextMob1Phone);
        mob2phone = (TextView) findViewById(R.id.editTextMob2Phone);
        email = (TextView) findViewById(R.id.editTextEmail);
        houseno = (TextView) findViewById(R.id.editTextHouseNo);
        building = (TextView) findViewById(R.id.editTextBuilding);
        area = (TextView) findViewById(R.id.editTextArea);
        street = (TextView) findViewById(R.id.editTextStreet);
        place = (TextView) findViewById(R.id.editTextCity);

        Log.d("Ravi", "DisplayContact onCreate Start 16 " + midname);
        mydb = new DBHelper(DisplayContact.this);

        Log.d("Ravi", "DisplayContact onCreate Start 17 " + midname);
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            int Value = extras.getInt("id");
            Log.d("Ravi", "DisplayContact onCreate Start 18 " + Value);
            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();
                Log.d("Ravi", "DisplayContact onCreate Start 19 "+ rs);

                String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
                Log.d("Ravi", "DisplayContact onCreate Start 190 " + rs + " " + nam);
                String midnam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_MIDNAME));
                Log.d("Ravi", "DisplayContact onCreate Start 191" + rs + " " + nam + " " + midnam);
                String surnam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_SURNAME));
                String phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
                String homephon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_HPHONE));
                String mob1phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_MOB1PHONE));
                String mob2phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_MOB2PHONE));
                String emai = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));
                String housen = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_HOUSE));
                String buildin = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_BULD));
                String are = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_AREA));
                String stree = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_STREET));
                String plac = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));
                Log.d("Ravi", "DisplayContact onCreate Start 20");

                if (!rs.isClosed())  {
                    Log.d("Ravi", "DisplayContact onCreate Start 21");
                    rs.close();
                }
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                name.setText((CharSequence)nam);
                name.setFocusable(false);
                name.setClickable(false);

                midname.setText((CharSequence)midnam);
                midname.setFocusable(false);
                midname.setClickable(false);

                surname.setText((CharSequence)surnam);
                surname.setFocusable(false);
                surname.setClickable(false);

                phone.setText((CharSequence)phon);
                phone.setFocusable(false);
                phone.setClickable(false);

                homephone.setText((CharSequence)homephon);
                homephone.setFocusable(false);
                homephone.setClickable(false);

                mob1phone.setText((CharSequence)mob1phon);
                mob1phone.setFocusable(false);
                mob1phone.setClickable(false);

                mob2phone.setText((CharSequence)mob2phon);
                mob2phone.setFocusable(false);
                mob2phone.setClickable(false);

                email.setText((CharSequence)emai);
                email.setFocusable(false);
                email.setClickable(false);

                houseno.setText((CharSequence)housen);
                houseno.setFocusable(false);
                houseno.setClickable(false);

                building.setText((CharSequence)buildin);
                building.setFocusable(false);
                building.setClickable(false);

                street.setText((CharSequence)stree);
                street.setFocusable(false);
                street.setClickable(false);

                area.setText((CharSequence)are);
                area.setFocusable(false);
                area.setClickable(false);

                place.setText((CharSequence)plac);
                place.setFocusable(false);
                place.setClickable(false);
                Log.d("Ravi", "DisplayContact onCreate Start 22");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Log.d("Ravi", "DisplayContact onCreateOptionsMenu Start 23");
        Bundle extras = getIntent().getExtras();

        if(extras !=null) {
            Log.d("Ravi", "DisplayContact onCreateOptionsMenu Start 24");
            int Value = extras.getInt("id");
            if(Value>0){
                Log.d("Ravi", "DisplayContact onCreateOptionsMenu Start 25");
                getMenuInflater().inflate(R.menu.display_contact, menu);
            } else{
                Log.d("Ravi", "DisplayContact onCreateOptionsMenu Start 26");
                getMenuInflater().inflate(R.menu.menu_main, menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.Edit_Contact:
                Log.d("Ravi", "DisplayContact onOptionsItemSelected Start 27");
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                midname.setEnabled(true);
                midname.setFocusableInTouchMode(true);
                midname.setClickable(true);

                surname.setEnabled(true);
                surname.setFocusableInTouchMode(true);
                surname.setClickable(true);

                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);

                homephone.setEnabled(true);
                homephone.setFocusableInTouchMode(true);
                homephone.setClickable(true);

                mob1phone.setEnabled(true);
                mob1phone.setFocusableInTouchMode(true);
                mob1phone.setClickable(true);

                mob2phone.setEnabled(true);
                mob2phone.setFocusableInTouchMode(true);
                mob2phone.setClickable(true);

                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);

                houseno.setEnabled(true);
                houseno.setFocusableInTouchMode(true);
                houseno.setClickable(true);

                building.setEnabled(true);
                building.setFocusableInTouchMode(true);
                building.setClickable(true);

                street.setEnabled(true);
                street.setFocusableInTouchMode(true);
                street.setClickable(true);

                area.setEnabled(true);
                area.setFocusableInTouchMode(true);
                area.setClickable(true);

                place.setEnabled(true);
                place.setFocusableInTouchMode(true);
                place.setClickable(true);

                return true;
            case R.id.Delete_Contact:
                Log.d("Ravi", "DisplayContact onOptionsItemSelected Start 28");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteContact(id_To_Update);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });

                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void run(View view) {
        Log.d("Ravi", "DisplayContact run Start 29");
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            Log.d("Ravi", "DisplayContact run Start 30");
            int Value = extras.getInt("id");
            if(Value>0){
                Log.d("Ravi", "DisplayContact run Start 31");
                if(mydb.updateContact(id_To_Update, name.getText().toString(), midname.getText().toString(), surname.getText().toString(),
                        phone.getText().toString(), homephone.getText().toString(), mob1phone.getText().toString(), mob2phone.getText().toString(), email.getText().toString(),
                        houseno.getText().toString(), building.getText().toString(), street.getText().toString(), area.getText().toString(), place.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    Log.d("Ravi", "DisplayContact run Start 32");
                    startActivity(intent);
                } else{
                    Log.d("Ravi", "DisplayContact run Start 33");
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            } else{
                Log.d("Ravi", "DisplayContact run Start 34");
                if(mydb.insertContact(name.getText().toString(), midname.getText().toString(), surname.getText().toString(),
                        phone.getText().toString(), homephone.getText().toString(), mob1phone.getText().toString(), mob2phone.getText().toString(), email.getText().toString(),
                        houseno.getText().toString(), building.getText().toString(), street.getText().toString(), area.getText().toString(), place.getText().toString())){
                    Toast.makeText(getApplicationContext(), "done",
                            Toast.LENGTH_SHORT).show();
                    Log.d("Ravi", "DisplayContact run Start 35");
                } else{
                    Log.d("Ravi", "DisplayContact run Start 36");
                    Toast.makeText(getApplicationContext(), "not done",
                            Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                Log.d("Ravi", "DisplayContact run Start 37");
                startActivity(intent);
                Log.d("Ravi", "DisplayContact run Start 38");
            }
        }

    }
}