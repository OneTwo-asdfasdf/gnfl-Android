package com.test1.gnfl;





import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class FirstFragment extends Fragment {
	WebView myWebView;
	ProgressBar mProgressBar;
	  final static String myBlogAddr = "http://118.131.159.227/wordpress/?cat=2";
	  String myUrl;
	
	public FirstFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		View view = inflater.inflate(R.layout.fragment_first, container, false);
        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar2);

        myWebView = (WebView)view.findViewById(R.id.webView2);
        myWebView.setWebChromeClient(new WebChromeClient(){
			   public void onProgressChanged(WebView view, int progress) {
		            mProgressBar.setVisibility(View.VISIBLE);
		            mProgressBar.setProgress(progress);
		            if (progress == 100) {
		                mProgressBar.setVisibility(View.GONE); // Make the bar disappear after URL is loaded
		            }
		        }

		   });
        mProgressBar.setVisibility(View.VISIBLE);

		   
		   myWebView.getSettings().setJavaScriptEnabled(true);                
		   myWebView.setWebViewClient(new MyWebViewClient());
		   
		   
		   
		   if(myUrl == null){
		    myUrl = myBlogAddr;
		   }
		   myWebView.loadUrl(myUrl);
		   myWebView.setDownloadListener(new DownloadListener() {
		        public void onDownloadStart(String url, String userAgent,
		                        String contentDisposition, String mimetype,
		                        long contentLength) {

		                                      Uri uri = Uri.parse(url);
		       Intent intent = new Intent(Intent.ACTION_VIEW,uri);
		                startActivity(intent);
		        }
		});
		   myWebView.setOnKeyListener(new OnKeyListener(){

	            public boolean onKey(View v, int keyCode, KeyEvent event) {
	                  if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
	                        myWebView.goBack();
	                        return true;
	                    }
	                    return false;
	            }

	        });

		       
		         return view;
		         

		  }
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
         myUrl = url;
            view.loadUrl(url);
            return true;
        }
    }
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	   super.onActivityCreated(savedInstanceState);
	   setRetainInstance(true);
	  }
}
