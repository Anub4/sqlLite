package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {
    public static final String databaseName = "DictionaryDB";
    public static final int dbVersion = 1;

    private  static final String tblWord = "tblWord";
    private  static final String WordID = "WordID";
    private  static final String Word = "Word";
    private  static final String Meaning ="Meaning";


    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tblWord +
                "(" +
                WordID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Word +" TEXT," +
                Meaning + " TEXT" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long InsertData(String word, String Meaning, SQLiteDatabase db) {
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put("Word", word);
        contentValues.put("Meaning", Meaning);
        id = db.insert(tblWord, null, contentValues);
        return id;
    }

    public List<Word> GetAllWOrds  (){
        List<Word> dictionaryList = new ArrayList<>();
//        Cursor cursor = db.rawQuery("select  * from tblWord",null);
        String[] columns = {WordID,Word,Meaning};
        Cursor cursor = this.getReadableDatabase().query(tblWord,null,null,null,null,null,null);
        if(cursor.getCount() > 0)
        {
            while (cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }
        }
        return dictionaryList;
    }
    public List<Word> GetWordByName(String word){
        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery("select * from  tblWord where Word = ?", new String[]{word} );
        if(cursor.getCount() > 0)
        {
            while (cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }
        }
        return dictionaryList;
    }
}
