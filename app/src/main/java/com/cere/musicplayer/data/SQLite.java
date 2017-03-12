package com.cere.musicplayer.data;

import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;

/**
 * Created by CeRe on 2017/3/4.
 */

public class SQLite {
    public static LiteOrm getLiteOrm(Context context){
        DataBaseConfig config = new DataBaseConfig(context);
        config.dbName = "Music.db";
        config.dbVersion = 1;
        config.debugged = false;
        config.onUpdateListener = null;
        return LiteOrm.newSingleInstance(config);
    }
}
