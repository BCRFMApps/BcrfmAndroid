package com.patrickmelia.bcrfm.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.patrickmelia.bcrfm.MainActivity;
import com.patrickmelia.bcrfm.R;

/**
 * Created by Patrick on 25/06/2015.
 */
public class ContactFragment extends Fragment {

    Button btnCall, btnFacebook, btnTwitter, btnGoogle;
    //Button btnEmail;
    //Button btnText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contact, container, false);

        ((MainActivity)getActivity()).setTitle(R.string.contact);

        btnCall = (Button) view.findViewById(R.id.btnCall);
        btnCall.setOnClickListener(myhandler1);

        btnFacebook = (Button) view.findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(fbhandler);

        btnTwitter = (Button) view.findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(tweethandler);

        return view;
    }

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            // implements your things
            //TODO: change number
            String number = "3539620050";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    };


    View.OnClickListener tweethandler = new View.OnClickListener() {
        public void onClick(View v) {
            TweetFragment newFragment = new TweetFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    };

    View.OnClickListener fbhandler = new View.OnClickListener() {
        public void onClick(View v) {
            FbookFragment newFragment = new FbookFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    };

    /*View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            // implements your things
            //TODO: change number
            String number = "0857892864";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    };

    View.OnClickListener myhandler3 = new View.OnClickListener() {
        public void onClick(View v) {
            // implements your things
            //TODO: change number
            String number = "0857892864";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    };*/
}

