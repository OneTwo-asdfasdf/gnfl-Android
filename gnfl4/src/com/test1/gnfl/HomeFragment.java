package com.test1.gnfl;






import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HomeFragment extends Fragment {
	
	int count = 0;


	WebView myWebView;
	ProgressBar mProgressBar;
	  final static String myBlogAddr = "http://118.131.159.227/wordpress";
	  String myUrl;
	
	public HomeFragment(){}
	
	

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
 
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        

        
        ////////////////////////////////////////
        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar1);

        myWebView = (WebView)view.findViewById(R.id.webView1);
        
        

        
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
		   myWebView.getSettings().setPluginsEnabled(true);
		   myWebView.getSettings().setSupportMultipleWindows(true);
		   myWebView.getSettings().setSupportZoom(true);
		   myWebView.getSettings().setBuiltInZoomControls(true);
		   myWebView.getSettings().setLoadsImagesAutomatically(true);
		   myWebView.getSettings().setBlockNetworkImage(false);
		   
		   myWebView.getSettings().setUseWideViewPort(true);
		   myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		   
		   
		   
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
