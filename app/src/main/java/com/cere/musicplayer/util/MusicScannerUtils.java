package com.cere.musicplayer.util;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.MediaStore;

import com.cere.musicplayer.data.SQLite;
import com.cere.musicplayer.model.Music;

import java.util.ArrayList;

/**
 * Created by CeRe on 2017/3/3.
 */

public class MusicScannerUtils extends AsyncTask<Void, Void, ArrayList<Music>> {
    private Context context;
    private boolean showDialog = false;

    public MusicScannerUtils(Context context, boolean showDialog) {
        this.context = context;
        this.showDialog = showDialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Music> doInBackground(Void... params) {
        ArrayList<Music> mMusicList = new ArrayList<Music>();
        String[] project = new String[]{MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Albums.ARTIST,
                MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.DATA};
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, project, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                String album_artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST));
                String time = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

                Music mMusic = new Music();
                mMusic.setTitle(title);
                mMusic.setArtist(artist);
                mMusic.setAlbum(album);
                mMusic.setAlbumArtist(album_artist);
                mMusic.setTime(time);
                mMusic.setPath(path);
                mMusicList.add(mMusic);
            }
            SQLite.getLiteOrm(context).save(mMusicList);
        }
        return mMusicList;
    }

    @Override
    protected void onPostExecute(ArrayList<Music> musics) {
        super.onPostExecute(musics);
    }
}
