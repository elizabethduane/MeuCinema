package infocefetcontagem.meucinema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import infocefetcontagem.meucinema.CinemaContract.FilmeTable;

public class CinemaDbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cinema.db";

    public CinemaDbHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Execute the SQL statement
        sqLiteDatabase.execSQL(FilmeTable.SQL_CREATE_FILME_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Execute the SQL statement
        sqLiteDatabase.execSQL(FilmeTable.SQL_DELETE_FILME_TABLE);
    }
}
