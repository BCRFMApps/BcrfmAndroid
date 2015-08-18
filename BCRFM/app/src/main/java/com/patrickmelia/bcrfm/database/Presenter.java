package com.patrickmelia.bcrfm.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.patrickmelia.bcrfm.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Patrick on 24/03/2015.
 */
public class Presenter {

        //region Constructors
        private int PresenterId;
        private String PresenterName;
        private String ShortBio;
        private String ImageURL;
        private String LongBio;
        private String NumOfShows;
        private String Email;
        private String TelNo;
        private String Twitter;
        private String Facebook;

        //Todo: Get Image URL
        String url_images_root = "";


        public Presenter() {
        }

        public Presenter(int presenterId, String presenterName, String shortBio,
        String imageURL, String longBio, String numOfShows, String email,
        String telNo, String twitter, String facebook)
        {
            PresenterId = presenterId;
            PresenterName = presenterName;
            ShortBio = shortBio;
            ImageURL = imageURL;
            LongBio = longBio;
            NumOfShows = numOfShows;
            Email = email;
            TelNo = telNo;
            Twitter = twitter;
            Facebook = facebook;
        }

        //endregion

        //region PresentersDb_Structure

        //region ID
        public int getPresenterId() {
            return PresenterId;
        }

        public void setPresenterId(int presenterId) {
            PresenterId = presenterId;
        }

        //endregion

        //region Name

        public String getPresenterName() {
            return PresenterName;
        }

        public void setPresenterName(String presenterName) {
            PresenterName = presenterName;
        }

        //endregion

        //region ShortBio

        public String getShortBio() {
            return ShortBio;
        }

        public void setShortBio(String shortBio) {
            ShortBio = shortBio;
        }

        //endregion

        //region Image

        public String getImageName() {
            return ImageURL;
        }

        public void setImageURL(String imageURL) {
            ImageURL = imageURL;
        }

        //endregion

        //region LongBio

        public String getLongBio() {
            return LongBio;
        }

        public void setLongBio(String longBio) {
            LongBio = longBio;
        }

        //endregion

        //region NumOfShows

        public String getNumOfShows() {
            return NumOfShows;
        }

        public void setNumOfShows(String numOfShows) {
            NumOfShows = numOfShows;
        }

        //endregion

        //region Email

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        //endregion

        //region TelNo

        public String getTelNo() {
            return TelNo;
        }

        public void setTelNo(String telNo) {
            TelNo = telNo;
        }

        //endregion

        //region Twitter

        public String getTwitter() {
            return Twitter;
        }

        public void setTwitter(String twitter) {
            Twitter = twitter;
        }

        //endregion

        //region Facebook

        public String getFacebook() {
            return Facebook;
        }

        public void setFacebook(String facebook) {
            Facebook = facebook;
        }

        //endregion

        //endregion

        //region InsertIntoDatabase
        public long InsertIntoDatabase(SQLiteDatabase db){
            ContentValues values = new ContentValues();
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_Presenter_ID , PresenterId);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_PresenterName, PresenterName);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_ShortBio, ShortBio);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_IMAGE_URL, ImageURL);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_LongBio, LongBio);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_Num_Shows, NumOfShows);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_Email, Email);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_Tel_No , TelNo);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_Twitter, Twitter);
            values.put(BCRfmDbContract.Presenter.COLUMN_NAME_Facebook, Facebook);


            return db.insertOrThrow(BCRfmDbContract.Presenter.TABLE_NAME, null, values);
        }
        //endregion

        //region query all
        public static List<Presenter> GetAllPresenterFromDatabase(SQLiteDatabase db) {
            Cursor c = db.query(BCRfmDbContract.Presenter.TABLE_NAME,
                    new String[]{BCRfmDbContract.Presenter.COLUMN_NAME_Presenter_ID,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Presenter_ID,
                            BCRfmDbContract.Presenter.COLUMN_NAME_PresenterName,
                            BCRfmDbContract.Presenter.COLUMN_NAME_ShortBio,
                            BCRfmDbContract.Presenter.COLUMN_NAME_IMAGE_URL,
                            BCRfmDbContract.Presenter.COLUMN_NAME_LongBio,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Num_Shows,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Email,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Tel_No,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Twitter,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Facebook},
                    null, null, null, null, null);

            List<Presenter> allPresentersFromDatabase = new ArrayList<Presenter>();
            if (c.moveToFirst()) {
                do {
                    Presenter p = new Presenter(
                            c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4),
                            c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9)
                    );
                    allPresentersFromDatabase.add(p);
                }
                while (c.moveToNext());
                {
                    return allPresentersFromDatabase;
                }

            } else return allPresentersFromDatabase;
        }


        //endregion

        //region single query
        public static Presenter GetAllPresenterFromDatabase(SQLiteDatabase db, int presenterId) {

            String where = BCRfmDbContract.Presenter.COLUMN_NAME_Presenter_ID + " = " + presenterId;

            Cursor c = db.query(BCRfmDbContract.Presenter.TABLE_NAME,
                    new String[]{BCRfmDbContract.Presenter.COLUMN_NAME_Presenter_ID,
                            BCRfmDbContract.Presenter.COLUMN_NAME_PresenterName,
                            BCRfmDbContract.Presenter.COLUMN_NAME_ShortBio,
                            BCRfmDbContract.Presenter.COLUMN_NAME_IMAGE_URL,
                            BCRfmDbContract.Presenter.COLUMN_NAME_LongBio,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Num_Shows,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Email,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Tel_No,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Twitter,
                            BCRfmDbContract.Presenter.COLUMN_NAME_Facebook},
                    where, null, null, null, null);

            Presenter p = new Presenter();
            if (c.moveToFirst()) {
                p = new Presenter(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4),
                        c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9));
            }
            return p;
        }

        //endregion

        //region Bitmap Image

        public Bitmap GetImage(Context context)
        {
            String imageName = "";

            Bitmap theImage;

            File file;
            //check if there is text in the imageurl string
            if (getImageURL().isEmpty())
            {
                Resources res = context.getResources();
                theImage = BitmapFactory.decodeResource(res,R.drawable.bcrfm101white);
            }
            else {

                file = new File(context.getFilesDir(), "/" + getImageURL());

                //might not be downloaded
                if(!file.exists())
                {
                    Resources res = context.getResources();
                    theImage = BitmapFactory.decodeResource(res, R.drawable.bcrfm101white);
                }else
                {
                    theImage = BitmapFactory.decodeFile(file.getAbsolutePath());
                }
            }


            return theImage;
        }

        public String getImageURL(){
            return url_images_root + getImageName();
        }

        //endregion
}
