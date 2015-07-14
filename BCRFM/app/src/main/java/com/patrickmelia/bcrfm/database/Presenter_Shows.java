package com.patrickmelia.bcrfm.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 24/03/2015.
 */
public class Presenter_Shows {

    //region Constructors
    private int ID;
    private int Show_Id;
    private int Presenter_Id;


    public Presenter_Shows() {
    }

    public Presenter_Shows(int Id, int show_Id, int presenter_Id) {
        ID = Id;
        Show_Id = show_Id;
        Presenter_Id = presenter_Id;
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

    //region getShowId
    public int getShowId()
    {
        return Show_Id;
    }

    public void getShowId(int show_Id) {
        Show_Id = show_Id;
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
        values.put(BCRfmDbContract.Presenter_Shows.COLUMN_NAME_PresenterShowsID, ID);
        values.put(BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Show_Id, Show_Id);
        values.put(BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Presenter_Id, Presenter_Id);

        return db.insertOrThrow(BCRfmDbContract.Presenter_Shows.TABLE_NAME, null, values);
    }
    //endregion

    //region query all
    public static List<Presenter_Shows> GetAllPresenterFromDatabase(SQLiteDatabase db) {
        Cursor c = db.query(BCRfmDbContract.Presenter_Shows.TABLE_NAME,
                new String[]{BCRfmDbContract.Presenter_Shows.COLUMN_NAME_PresenterShowsID,
                            BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Show_Id,
                            BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Presenter_Id},
                null, null, null, null, null);

        List<Presenter_Shows> allPresenterShowsFromDatabase = new ArrayList<Presenter_Shows>();
        if (c.moveToFirst()) {
            do {
                Presenter_Shows p = new Presenter_Shows(
                        c.getInt(0), c.getInt(1), c.getInt(2)
                );
                allPresenterShowsFromDatabase.add(p);
            }
            while (c.moveToNext());
            {
                return allPresenterShowsFromDatabase;
            }

        } else return allPresenterShowsFromDatabase;
    }


    //endregion

    //region single query
    public static Presenter_Shows GetAllPresenterShowsFromDatabase(SQLiteDatabase db, int presenterId) {

        String where = BCRfmDbContract.Presenter_Shows.COLUMN_NAME_PresenterShowsID + " = " + presenterId;

        Cursor c = db.query(BCRfmDbContract.Presenter_Shows.TABLE_NAME,
                new String[]{BCRfmDbContract.Presenter_Shows.COLUMN_NAME_PresenterShowsID,
                        BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Show_Id,
                        BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Presenter_Id},
                where, null, null, null, null);

        Presenter_Shows ps = new Presenter_Shows();
        if (c.moveToFirst()) {
            ps = new Presenter_Shows(c.getInt(0), c.getInt(1), c.getInt(2));
        }
        return ps;
    }

    //endregion
}
