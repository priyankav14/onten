package com.onten.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by zhenting on 3/11/2015.
 */
public class DiscreteFourierTransformActivity extends Fragment {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigation;
    WebView myWebView;
    private RelativeLayout container;
    private Button nextButton, closeButton;
    private EditText findSearch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.determinants, container, false);
        // Retrieve UI elements
        myWebView = (WebView) view.findViewById(R.id.webView1);

        // Initialize the WebView
        myWebView.getSettings().setJavaScriptEnabled(true);
        //myWebView.loadUrl("http://onten.eee.ntu.edu.sg/node/11");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load the URLs inside the WebView, not in the external web browser
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                myWebView.loadUrl("javascript:(function() { " +
                        //hide the main menu and courses
                        "document.getElementsByClassName('region region-sidebar-first sidebar')[0].style.display='none'; " +
                        //hide the footer
                        "document.getElementsByTagName('footer')[0].style.display='none'; " +
                        //hide the survey feedback
                        "document.getElementsByClassName('webform-grid webform-grid-5 sticky-enabled')[0].style.display='none'; " +
                        //align and justify the text
                        "document.getElementsByClassName('node-content')[0].style.textAlign = 'justify'; " +
                        //spaces between the text height
                        "document.getElementsByClassName('node-content')[0].style.lineHeight = '200%'; " +
                        "})()");
            }
        });

        if (savedInstanceState == null) {
            // Load a page
            myWebView.loadUrl("http://onteneee.ddns.net/node/37");

            //myWebView.loadUrl("http://onten.eee.ntu.edu.sg/node/11");
        }
        return view;
    }

}
