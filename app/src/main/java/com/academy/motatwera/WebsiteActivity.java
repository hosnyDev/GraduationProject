package com.academy.motatwera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class WebsiteActivity extends AppCompatActivity {

	 // view
	 private TextView txt;
	 private GifImageView img;
	 private ProgressBar progressBarWeb;
	 private WebView mWebView;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_website);

		  // view

		  img = findViewById(R.id.imgLoadHome);
		  txt = findViewById(R.id.textImgLoadHome);
		  progressBarWeb = findViewById(R.id.progressBarWeb);


		  mWebView = findViewById(R.id.webView);


		  CheckInternetConn conn = new CheckInternetConn(this);

		  Boolean ch = conn.isConnection();

		  if ( ch ) {
			   progressBarWeb.setVisibility(View.VISIBLE);
			   mWebView.getSettings().setJavaScriptEnabled(true);
			   mWebView.getSettings().setLoadWithOverviewMode(true);
			   mWebView.getSettings().setUseWideViewPort(true);
			   mWebView.getSettings().setBuiltInZoomControls(true);
			   mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

			   mWebView.setWebViewClient(new webView());
			   mWebView.loadUrl("http://www.advancedacademy.edu.eg/Haram/RootPages/Default.aspx");
			   progressBarWeb.setVisibility(View.INVISIBLE);
		  } else {
			   img.setVisibility(View.VISIBLE);
			   txt.setVisibility(View.VISIBLE);
			   mWebView.setVisibility(View.INVISIBLE);
		  }

	 }

	 private class webView extends WebViewClient {
		  @Override
		  public boolean shouldOverrideUrlLoading(WebView view , String url) {
			   return false;
		  }

	 }

	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
		  if (event.getAction() == KeyEvent.ACTION_DOWN) {
			   switch (keyCode) {
					case KeyEvent.KEYCODE_BACK:
						 if (mWebView.canGoBack()) {
							  mWebView.goBack();
						 } else {
							  finish();
						 }
						 return true;
			   }

		  }
		  return super.onKeyDown(keyCode, event);
	 }

}
