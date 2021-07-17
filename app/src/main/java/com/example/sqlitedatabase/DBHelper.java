package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_MIDNAME = "midname";
    public static final String CONTACTS_COLUMN_SURNAME = "surname";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_HOUSE = "houseno";
    public static final String CONTACTS_COLUMN_BULD = "building";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_AREA = "area";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    public static final String CONTACTS_COLUMN_HPHONE = "homephone";
    public static final String CONTACTS_COLUMN_MOB1PHONE = "mob1phone";
    public static final String CONTACTS_COLUMN_MOB2PHONE = "mob2phone";
    private HashMap hp;


    public DBHelper(MainActivity context) {
        super(context, DATABASE_NAME , null, 2);
    }

    public DBHelper(DisplayContact context) {
        super(context, DATABASE_NAME , null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        Log.d("Ravi", "DBHelper onCreate Start 42");
//        db.execSQL("DROP TABLE contacts");
//        Log.d("Ravi", "DBHelper onCreate Start 421");
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text, midname text, surname text, email text, houseno text, building text, street text, area text, place text, phone text, homephone text, mob1phone text, mob2phone text)"
        );
        Log.d("Ravi", "DBHelper onCreate Start 43");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.d("Ravi", "DBHelper onUpgrade Start 43");
        db.execSQL("DROP TABLE IF EXISTS contacts");
        Log.d("Ravi", "DBHelper onUpgrade Start 44");
        onCreate(db);
        Log.d("Ravi", "DBHelper onUpgrade Start 45");
    }

    public boolean insertContact (String name, String midname, String surname, String email, String houseno, String bulding, String street, String area, String place, String phone, String homephone, String mob1phone, String mob2phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("midname", midname);
        contentValues.put("surname", surname);
        contentValues.put("email", email);
        contentValues.put("houseno", houseno);
        contentValues.put("building", bulding);
        contentValues.put("street", street);
        contentValues.put("area", area);
        contentValues.put("place", place);
        contentValues.put("phone", phone);
        contentValues.put("homephone", homephone);
        contentValues.put("mob1phone", mob1phone);
        contentValues.put("mob2phone", mob2phone);
        Log.d("Ravi", "DBHelper insertContact Start 46");
        db.insert("contacts", null, contentValues);
        Log.d("Ravi", "DBHelper insertContact Start 461");
        return true;
    }

    public Cursor getData(int id) {
        Log.d("Ravi", "DBHelper Cursor Start 47");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        Log.d("Ravi", "DBHelper Cursor Start 48 " + res);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("Ravi", "DBHelper numberOfRows Start 49");
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        Log.d("Ravi", "DBHelper numberOfRows Start 50" + numRows);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String midname, String surname, String email, String houseno, String bulding, String street, String area, String place, String phone, String homephone, String mob1phone, String mob2phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Log.d("Ravi", "DBHelper updateContact Start 51" + contentValues);
        contentValues.put("name", name);
        contentValues.put("midname", midname);
        contentValues.put("surname", surname);
        contentValues.put("email", email);
        contentValues.put("houseno", houseno);
        contentValues.put("building", bulding);
        contentValues.put("street", street);
        contentValues.put("area", area);
        contentValues.put("place", place);
        contentValues.put("phone", phone);
        contentValues.put("homephone", homephone);
        contentValues.put("mob1phone", mob1phone);
        contentValues.put("mob2phone", mob2phone);
        Log.d("Ravi", "DBHelper updateContact Start 52" + contentValues);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        Log.d("Ravi", "DBHelper updateContact Start 53" + contentValues);
        return true;
    }

    public Integer deleteContact (Integer id) {
        Log.d("Ravi", "DBHelper deleteContact Start 54" + id);
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("Ravi", "DBHelper deleteContact Start 55" + id);
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllCotacts() {
        Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 56");
        ArrayList<String> array_list = new ArrayList<String>();
        Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 57");

//        hp = new HashMap();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 58" + res);
        res.moveToFirst();
        Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 59" + res);

        while(res.isAfterLast() == false){
            Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 60" + res);
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 61" + res);
            res.moveToNext();
            Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 62" + res);
        }
        Log.d("Ravi", "DBHelper Cursor ArrayList<String> Start 63" + res);
        return array_list;
    }
}
