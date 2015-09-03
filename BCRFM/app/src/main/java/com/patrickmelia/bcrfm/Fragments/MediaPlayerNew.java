package com.patrickmelia.bcrfm.Fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.patrickmelia.bcrfm.MainActivity;
import com.patrickmelia.bcrfm.R;

/**
 * Created by Patrick on 25/06/2015.
 */
public class MediaPlayerNew extends Fragment implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener,
        android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnBufferingUpdateListener{

    private MediaPlayer mp = null;
    private String TAG = getClass().getSimpleName();
    private ImageButton play;
    private Button pause;
    private Button stop;
    private TextView txtVStatus;

    private Context _context;

    public MediaPlayerNew(Context context){
        this._context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_player, container, false);

        ((MainActivity)getActivity()).setTitle(R.string.home);
        //isOnline();

        return view;
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        play = (ImageButton) getActivity().findViewById(R.id.btnPlay);
        pause = (Button) getActivity().findViewById(R.id.btnPause);
        stop = (Button) getActivity().findViewById(R.id.btnStop);
        //status = (TextView) findViewById(R.id.txtVStatus);

        pause.setEnabled(false);
        stop.setEnabled(false);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                isOnline();
            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stop();
            }
        });
    }

    private void isOnline() {
        ConnectivityManager cm = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnected()){
            play();
        }
        else{
        new AlertDialog.Builder(_context)
                .setTitle("Whoops!!")
                .setMessage("You must be connected to the internet to tune in! Please activate mobile internet/wifi and try again.")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })

                .setIcon(getResources().getDrawable(R.drawable.ic_warning_black_24dp))
                .show();
        }
    }

    private void play() {

        //HTTP to BCRFM STREAM
        Uri myUri = Uri.parse("http://37.187.193.36:8002");
        try {
            if (mp == null) {
                this.mp = new android.media.MediaPlayer();
            } else {
                mp.stop();
                mp.reset();
            }
            mp.setDataSource(myUri.toString()); // Go to Initialized state)
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setOnPreparedListener(this);
            mp.setOnBufferingUpdateListener(this);

            mp.setOnErrorListener(this);
            mp.prepareAsync();

            Log.d(TAG, "LoadClip Done");
        } catch (Throwable t) {
            Log.d(TAG, t.toString());
        }
    }

    @Override
    public void onPrepared(android.media.MediaPlayer mp) {
        Log.d(TAG, "Stream is prepared");
        final TextView textViewToChange = (TextView) getActivity().findViewById(R.id.txtVStatus);
        textViewToChange.setText("Welcome to BCRfm");
        mp.start();
        play.setEnabled(false);
        pause.setEnabled(true);
        stop.setEnabled(true);

    }

    private void pause() {
        mp.pause();
        final TextView textViewToChange = (TextView) getActivity().findViewById(R.id.txtVStatus);
        textViewToChange.setText("You have paused your feed to BCRfm");
        play.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(true);
    }

    private void stop() {
        final TextView textViewToChange = (TextView) getActivity().findViewById(R.id.txtVStatus);
        textViewToChange.setText(" ");
        play.setEnabled(true);
        pause.setEnabled(false);
        stop.setEnabled(false);
        mp.stop();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onCompletion(android.media.MediaPlayer mp) {
        stop();
    }

    public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
        StringBuilder sb = new StringBuilder();
        sb.append("Media Player Error: ");
        switch (what) {
            case android.media.MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:
                sb.append("Not Valid for Progressive Playback");
                break;
            case android.media.MediaPlayer.MEDIA_ERROR_SERVER_DIED:
                sb.append("Server Died");
                break;
            case android.media.MediaPlayer.MEDIA_ERROR_UNKNOWN:
                sb.append("Unknown");
                break;
            default:
                sb.append(" Non standard (");
                sb.append(what);
                sb.append(")");
        }
        sb.append(" (" + what + ") ");
        sb.append(extra);
        Log.e(TAG, sb.toString());
        return true;
    }
    public void onBufferingUpdate(android.media.MediaPlayer mp, int percent) {
        Log.d(TAG, "PlayerService onBufferingUpdate : " + percent + "%");
    }
}