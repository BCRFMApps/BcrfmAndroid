package com.patrickmelia.bcrfm.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 24/03/2015.
 */
public class Series {

    //region Constructors
    private int SeriesId;
    private String ShortDes;
    private String Num_Shows;
    private String Last_Ep_Id;
    private String LongDes;
    private String MainPresenter;
    private String CoPresenter;


    public Series() {
    }

    public Series(int seriesId, String shortDes, String numOfShows, String last_Ep_Id,
                  String longDes, String mainPresenter, String coPresenter) {
        SeriesId = seriesId;
        ShortDes = shortDes;
        Num_Shows = numOfShows;
        Last_Ep_Id = last_Ep_Id;
        LongDes = longDes;
        MainPresenter = mainPresenter;
        CoPresenter = coPresenter;
    }
    //endregion

    //region Series

    //region ID
    public int getSeriesIdId() {
        return SeriesId;
    }

    public void setSeriesId(int seriesId) {
        SeriesId = seriesId;
    }

    //endregion

    //region ShortDes

    public String getShortDes() {
        return ShortDes;
    }

    public void setShortDes(String shortDes) {
        ShortDes = shortDes;
    }

    //endregion

    //region Num_Shows

    public String getNum_Shows() {
        return Num_Shows;
    }

    public void setNum_Shows(String num_Shows) {
        Num_Shows = num_Shows;
    }

    //endregion

    //region Last_Ep_Id

    public String getLast_Ep_Id() {
        return Last_Ep_Id;
    }

    public void setLast_Ep_Id(String last_Ep_Id) {
        Last_Ep_Id = last_Ep_Id;
    }

    //endregion

    //region LongBio

    public String getLongDes() {
        return LongDes;
    }

    public void setlongDes(String longDes) {
        LongDes = longDes;
    }

    //endregion

    //region MainPresenter

    public String getMainPresenter() {
        return MainPresenter;
    }

    public void setMainPresenter(String mainPresenter) {
        MainPresenter = mainPresenter;
    }

    //endregion

    //region coPresenter

    public String getCoPresenter() {
        return CoPresenter;
    }

    public void setCoPresenter(String coPresenter) {
        CoPresenter = coPresenter;
    }

    //endregion

    //endregion

    //region InsertIntoDatabase
    public long InsertIntoDatabase(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(BCRfmDbContract.Series.COLUMN_NAME_Series_ID, SeriesId);
        values.put(BCRfmDbContract.Series.COLUMN_NAME_ShortDes, ShortDes);
        values.put(BCRfmDbContract.Series.COLUMN_NAME_Num_Shows, Num_Shows);
        values.put(BCRfmDbContract.Series.COLUMN_NAME_Last_Ep_Id, Last_Ep_Id);
        values.put(BCRfmDbContract.Series.COLUMN_NAME_LongDes, LongDes);
        values.put(BCRfmDbContract.Series.COLUMN_NAME_Main_Presenter, MainPresenter);
        values.put(BCRfmDbContract.Series.COLUMN_NAME_Co_Presenter, CoPresenter);

        return db.insertOrThrow(BCRfmDbContract.Series.TABLE_NAME, null, values);
    }
    //endregion

    //region query all
    public static List<Series> GetAllSeriesFromDatabase(SQLiteDatabase db) {
        Cursor c = db.query(BCRfmDbContract.Series.TABLE_NAME,
                new String[]{BCRfmDbContract.Series.COLUMN_NAME_Series_ID,
                        BCRfmDbContract.Series.COLUMN_NAME_ShortDes,
                        BCRfmDbContract.Series.COLUMN_NAME_Num_Shows,
                        BCRfmDbContract.Series.COLUMN_NAME_Last_Ep_Id,
                        BCRfmDbContract.Series.COLUMN_NAME_LongDes,
                        BCRfmDbContract.Series.COLUMN_NAME_Main_Presenter,
                        BCRfmDbContract.Series.COLUMN_NAME_Co_Presenter},
                null, null, null, null, null);

        List<Series> allSeriesFromDatabase = new ArrayList<Series>();
        if (c.moveToFirst()) {
            do {
                Series s = new Series(
                        c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3),
                        c.getString(4), c.getString(5),
                        c.getString(6)
                );
                allSeriesFromDatabase.add(s);
            }
            while (c.moveToNext());
            return allSeriesFromDatabase;
        } else {
            return allSeriesFromDatabase;
        }
    }

    //endregion

    //region single query
    public static Series GetAllSeriesFromDatabase(SQLiteDatabase db, int seriesId) {

        String where = BCRfmDbContract.Series.COLUMN_NAME_Series_ID + " = " + seriesId;

        Cursor c = db.query(BCRfmDbContract.Series.TABLE_NAME,
                new String[]{BCRfmDbContract.Series.COLUMN_NAME_Series_ID,
                        BCRfmDbContract.Series.COLUMN_NAME_ShortDes,
                        BCRfmDbContract.Series.COLUMN_NAME_Num_Shows,
                        BCRfmDbContract.Series.COLUMN_NAME_Last_Ep_Id,
                        BCRfmDbContract.Series.COLUMN_NAME_LongDes,
                        BCRfmDbContract.Series.COLUMN_NAME_Main_Presenter,
                        BCRfmDbContract.Series.COLUMN_NAME_Co_Presenter},
                where, null, null, null, null);

        Series s = new Series();
        if (c.moveToFirst()) {
            s = new Series(
                    c.getInt(0), c.getString(1),
                    c.getString(2), c.getString(3),
                    c.getString(4), c.getString(5),
                    c.getString(6));
        }
        return s;
    }

    //endregion
}
