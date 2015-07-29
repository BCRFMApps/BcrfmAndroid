package com.patrickmelia.bcrfm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Patrick on 24/03/2015.
 */
public class BCRfmHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    public BCRfmHelper(Context context) {
        super(context, BCRfmDbContract.DATABASE_NAME, null, BCRfmDbContract.DATABASE_VERSION);
    }

    //region SQL_CREATE

    //region SQL_CREATE_PRESENTERS_ENTRIES
    private static final String SQL_CREATE_PRESENTERS_ENTRIES =
            "CREATE TABLE " + BCRfmDbContract.Presenter.TABLE_NAME + " (" +
                    BCRfmDbContract.Presenter.COLUMN_NAME_Presenter_ID + " INTEGER PRIMARY KEY," +
                    BCRfmDbContract.Presenter.COLUMN_NAME_PresenterName + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_ShortBio + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_IMAGE_URL + TEXT_TYPE +
                    BCRfmDbContract.Presenter.COLUMN_NAME_LongBio + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_Num_Shows + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_Email + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_Tel_No + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_Twitter + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Presenter.COLUMN_NAME_Facebook + TEXT_TYPE +
                    " )";
    //endregion

    //region SQL_CREATE_SERIES_ENTRIES
    private static final String SQL_CREATE_SERIES_ENTRIES =
            "CREATE TABLE " + BCRfmDbContract.Series.TABLE_NAME + " (" +
                    BCRfmDbContract.Series.COLUMN_NAME_Series_ID + " INTEGER PRIMARY KEY," +
                    BCRfmDbContract.Series.COLUMN_NAME_ShortDes + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Series.COLUMN_NAME_Num_Shows + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Series.COLUMN_NAME_Last_Ep_Id + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Series.COLUMN_NAME_LongDes + TEXT_TYPE +
                    BCRfmDbContract.Series.COLUMN_NAME_Main_Presenter + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Series.COLUMN_NAME_Co_Presenter + TEXT_TYPE +
                    " )";
    //endregion

    //region SQL_CREATE_SHOWS_ENTRIES
    private static final String SQL_CREATE_SHOWS_ENTRIES =
            "CREATE TABLE " + BCRfmDbContract.Shows.TABLE_NAME + " (" +
                    BCRfmDbContract.Shows.COLUMN_NAME_Show_ID + " INTEGER PRIMARY KEY," +
                    BCRfmDbContract.Shows.COLUMN_NAME_Show_Title + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Shows.COLUMN_NAME_Presenter + " INTEGER PRIMARY KEY," +
                    BCRfmDbContract.Shows.COLUMN_NAME_ShortDes + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Shows.COLUMN_NAME_LongDes + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Shows.COLUMN_NAME_Length + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Shows.COLUMN_NAME_Date_Broadcast + TEXT_TYPE +
                    BCRfmDbContract.Shows.COLUMN_NAME_In_Past + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Shows.COLUMN_NAME_Listen_Again + TEXT_TYPE + COMMA_SEP +
                    BCRfmDbContract.Shows.COLUMN_NAME_Listen_Again_Location + TEXT_TYPE +
                    BCRfmDbContract.Shows.COLUMN_NAME_Series + " INTEGER PRIMARY KEY," +
                    " )";
    //endregion

    //region SQL_CREATE_PRESENTER_SERIES_ENTRIES
    private static final String SQL_CREATE_PRESENTER_SERIES_ENTRIES =
            "CREATE TABLE " + BCRfmDbContract.Presenter_Series.TABLE_NAME + " (" +
                    BCRfmDbContract.Presenter_Series.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    BCRfmDbContract.Presenter_Series.COLUMN_NAME_Presenter_Id + "INTERGER ," +
                    BCRfmDbContract.Presenter_Series.COLUMN_NAME_Series_Id + "INTERGER ," +
                    " )";

    //endregion

    //region SQL_CREATE_PRESENTER_SHOWS_ENTRIES
    private static final String SQL_CREATE_PRESENTER_SHOWS_ENTRIES =
            "CREATE TABLE " + BCRfmDbContract.Presenter_Shows.TABLE_NAME + " (" +
                    BCRfmDbContract.Presenter_Shows.COLUMN_NAME_PresenterShowsID + " INTEGER PRIMARY KEY," +
                    BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Show_Id + "INTERGER ," +
                    BCRfmDbContract.Presenter_Shows.COLUMN_NAME_Presenter_Id + "INTERGER ," +
                    " )";

    //endregion


    //endregion

    //region SQL_DELETE
    static final String SQL_DELETE_PRESENTERS_ENTRIES =
            "DROP TABLE IF EXISTS " + BCRfmDbContract.Presenter.TABLE_NAME;
    static final String SQL_DELETE_SERIES_ENTRIES =
            "DROP TABLE IF EXISTS " + BCRfmDbContract.Series.TABLE_NAME;
    static final String SQL_DELETE_SHOWS_ENTRIES =
            "DROP TABLE IF EXISTS " + BCRfmDbContract.Shows.TABLE_NAME;
    static final String SQL_DELETE_PRESENTER_SHOWS_ENTRIES =
            "DROP TABLE IF EXISTS " + BCRfmDbContract.Shows.TABLE_NAME;

    //endregion

    //region CRUD
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_PRESENTERS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_SERIES_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_SHOWS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_PRESENTER_SHOWS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(SQL_DELETE_PRESENTERS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_SERIES_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_SHOWS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_PRESENTER_SHOWS_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void ResetDatabaseDefault(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(SQL_DELETE_PRESENTERS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_SERIES_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_SHOWS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_PRESENTER_SHOWS_ENTRIES);
        onCreate(sqLiteDatabase);
    }
    //endregion
}
