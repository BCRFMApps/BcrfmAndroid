package com.patrickmelia.bcrfm.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 14/07/2015.
 */
public class Presenter_Series {

    //region Constructors
    private int ID;
    private int Presenter_Id;
    private int Series_Id;


    public Presenter_Series() {
    }

    public Presenter_Series(int Id, int presenter_Id, int series_Id) {
        ID = Id;
        Presenter_Id = presenter_Id;
        Series_Id = series_Id;
    }

    //region getId
    public int getId()
    {
        return ID;
    }

    public void getId(int id) {
        ID = id;
    }
    //endregion

    //region getSeriesId
    public int getSeriesId()
    {
        return Series_Id;
    }

    public void getSeriesId(int series_Id) {
        Series_Id = series_Id;
    }
    //endregion

    //region getPresenter_Id
    public int getPresenter_Id()
    {
        return Presenter_Id;
    }

    public void getID(int presenter_Id) {
        Presenter_Id = presenter_Id;
    }
    //endregion

    //endregion

    //region InsertIntoDatabase
    public long InsertIntoDatabase(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(BCRfmDbContract.Presenter_Series.COLUMN_NAME_ID, ID);
        values.put(BCRfmDbContract.Presenter_Series.COLUMN_NAME_Series_Id, Series_Id);
        values.put(BCRfmDbContract.Presenter_Series.COLUMN_NAME_Presenter_Id, Presenter_Id);

        return db.insertOrThrow(BCRfmDbContract.Presenter_Series.TABLE_NAME, null, values);
    }
    //endregion

    //region query all
    public static List<Presenter_Series> allPresenterSeriesFromDatabase(SQLiteDatabase db) {
        Cursor c = db.query(BCRfmDbContract.Presenter_Series.TABLE_NAME,
                new String[]{BCRfmDbContract.Presenter_Series.COLUMN_NAME_ID,
                        BCRfmDbContract.Presenter_Series.COLUMN_NAME_Series_Id,
                        BCRfmDbContract.Presenter_Series.COLUMN_NAME_Presenter_Id},
                null, null, null, null, null);

        List<Presenter_Series> allPresenterSeriesFromDatabase = new ArrayList<Presenter_Series>();
        if (c.moveToFirst()) {
            do {
                Presenter_Series p = new Presenter_Series(
                        c.getInt(0), c.getInt(1), c.getInt(2)
                );
                allPresenterSeriesFromDatabase.add(p);
            }
            while (c.moveToNext());
            {
                return allPresenterSeriesFromDatabase;
            }

        } else return allPresenterSeriesFromDatabase;
    }


    //endregion

    //region single query
    public static Presenter_Series allPresenterSeriesFromDatabase(SQLiteDatabase db, int presenterId) {

        String where = BCRfmDbContract.Presenter_Series.COLUMN_NAME_Presenter_Id + " = " + presenterId;

        Cursor c = db.query(BCRfmDbContract.Presenter_Series.TABLE_NAME,
                new String[]{BCRfmDbContract.Presenter_Series.COLUMN_NAME_ID,
                        BCRfmDbContract.Presenter_Series.COLUMN_NAME_Series_Id,
                        BCRfmDbContract.Presenter_Series.COLUMN_NAME_Presenter_Id},
                where, null, null, null, null);

        Presenter_Series p = new Presenter_Series ();
        if (c.moveToFirst()) {
            p = new Presenter_Series(c.getInt(0), c.getInt(1), c.getInt(2));
        }
        return p;
    }

    //endregion
}
