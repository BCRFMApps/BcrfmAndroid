package com.patrickmelia.bcrfm.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.patrickmelia.bcrfm.MainActivity;
import com.patrickmelia.bcrfm.R;

/**
 * Created by Patrick on 18/08/2015.
 */
public class WebSiteFragment extends Fragment {

    WebView wv;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.activity_website, container, false);

        ((MainActivity)getActivity()).setTitle(R.string.website);

        wv=(WebView)view.findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://www.bcrfm.ie");

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        return view;
    }
}
