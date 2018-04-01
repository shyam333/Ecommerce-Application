package helloworld.demo.com.ecommerceapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DB HELPER";
    public static final String DATABASE_NAME = "Ecommerce";
    public static final String TABLE_NAME = "Item_Details";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    private static final String CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " ( " +
            COL_1 + " INTEGER PRIMARY KEY ," +
            COL_2 + " TEXT )";

    //CREATING SELECT_QUERY METHOD
    private String SELECT_QUERY = " SELECT " +
            COL_1 + " , " +
            COL_2 +
            " FROM " + TABLE_NAME + " WHERE " + COL_2 + " = ? ";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String checkName(String Name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        try{
            cursor = db.rawQuery(SELECT_QUERY,new String[]{Name});
            if(cursor.getCount()>0)
            {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndex(COL_2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertData(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_2,contact.getName());
        Log.e(TAG,"GETTER NAME EXECUTED");
        long result = db.insert(TABLE_NAME,null,contentvalues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public ArrayList<Contact> getContacts() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Contact> contactlist = new ArrayList<Contact>();
        Cursor c1 = null;
        c1 = db.rawQuery(" SELECT * FROM Item_Details ", null);
        c1.moveToFirst();
                do {
                    Contact contact = new Contact();

                    contact.setID(c1.getString(c1.getColumnIndex(COL_1)));

                    contact.setName(c1.getString(c1.getColumnIndex(COL_2)));

                    contactlist.add(contact);

                } while (c1.moveToNext());

            return contactlist;
    }


}
