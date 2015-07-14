package com.patrickmelia.bcrfm.database;

import android.provider.BaseColumns;

/**
 * Created by Patrick on 24/03/2015.
 */
public class BCRfmDbContract {

    public static final String DATABASE_NAME = "BCRfmDb";
    public static final int DATABASE_VERSION = 1;

    public BCRfmDbContract(){}

    //region Presenter
    public static abstract class Presenter implements BaseColumns {
        public static final String TABLE_NAME = "Presenter";
        public static final String COLUMN_NAME_Presenter_ID = "PresenterId";
        public static final String COLUMN_NAME_PresenterName = "PresenterName";
        public static final String COLUMN_NAME_ShortBio = "ShortBio";
        public static final String COLUMN_NAME_IMAGE_URL = "ImageURL";
        public static final String COLUMN_NAME_LongBio = "LongBio";
        public static final String COLUMN_NAME_Num_Shows = "Num_Shows";
        public static final String COLUMN_NAME_Email = "Email";
        public static final String COLUMN_NAME_Tel_No = "Tel_No";
        public static final String COLUMN_NAME_Twitter = "Twitter";
        public static final String COLUMN_NAME_Facebook = "Facebook";
    }
    //endregion

    //region Series
    public static abstract class Series implements BaseColumns {
        public static final String TABLE_NAME = "Series";
        public static final String COLUMN_NAME_Series_ID = "SeriesId";
        public static final String COLUMN_NAME_ShortDes = "ShortDes";
        public static final String COLUMN_NAME_Num_Shows = "Num_Shows";
        public static final String COLUMN_NAME_Last_Ep_Id = "Last_Ep_Id";
        public static final String COLUMN_NAME_LongDes = "LongDes";
        public static final String COLUMN_NAME_Main_Presenter = "Main_Presenter";
        public static final String COLUMN_NAME_Co_Presenter = "Co_Presenter";
    }
    //endregion

    //region Shows
    public static abstract class Shows implements BaseColumns {
        public static final String TABLE_NAME = "Shows";
        public static final String COLUMN_NAME_Show_ID = "ShowId";
        public static final String COLUMN_NAME_Show_Title = "Title";
        public static final String COLUMN_NAME_Presenter = "Presenter";
        public static final String COLUMN_NAME_ShortDes = "ShortDes";
        public static final String COLUMN_NAME_LongDes = "LongDes";
        public static final String COLUMN_NAME_Length = "Length";
        public static final String COLUMN_NAME_Date_Broadcast = "Date_Broadcast";
        public static final String COLUMN_NAME_In_Past = "In_Past";
        public static final String COLUMN_NAME_Listen_Again = "Listen_Again";
        public static final String COLUMN_NAME_Listen_Again_Location = "Listen_Again_Location";
        public static final String COLUMN_NAME_Series = "Series";
    }
    //endregion

    //region Presenter_Series
    public static abstract class Presenter_Series implements BaseColumns {
        public static final String TABLE_NAME = "Presenter_Series";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_Presenter_Id = "Presenter_ID";
        public static final String COLUMN_NAME_Series_Id = "Seris_Id";
    }
    //endregion

    //region Presenter_Shows
    public static abstract class Presenter_Shows implements BaseColumns {
        public static final String TABLE_NAME = "Presenter_Shows";
        public static final String COLUMN_NAME_PresenterShowsID = "ID";
        public static final String COLUMN_NAME_Show_Id = "Show_ID";
        public static final String COLUMN_NAME_Presenter_Id = "Presenter_ID";
    }
    //endregion

}
