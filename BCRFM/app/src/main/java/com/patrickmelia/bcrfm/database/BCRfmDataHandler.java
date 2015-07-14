package com.patrickmelia.bcrfm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Patrick on 24/03/2015.
 */
public class BCRfmDataHandler {

    Context ctx;
    BCRfmDataHandler bcrfmHelper;
    SQLiteDatabase db;

    public SQLiteDatabase WritableDb(){
        return db;
    }

    public BCRfmDataHandler(Context ctx){
        this.ctx = ctx;
        bcrfmHelper = new BCRfmDataHandler(ctx);
    }

    public BCRfmDataHandler open(){
        db = this.WritableDb();
        return this;
    }

    public void close(){
        bcrfmHelper.close();
    }

    public long insertData(){
        ContentValues content = new ContentValues();
        return 1;
    }
}
