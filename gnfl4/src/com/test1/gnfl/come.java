package com.test1.gnfl;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.NMapActivity;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager.OnCalloutOverlayListener;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;


public class come extends NMapActivity 
	implements OnMapStateChangeListener, OnCalloutOverlayListener {
		public static final String API_Key = "f27cd7a0fd108acde3a87a4d82f61f8e";
		NMapController mMapController = null;
		NMapView mMapView = null;
		LinearLayout MapContainer;
		NMapViewerResourceProvider mMapViewerResourceProvider = null;
		NMapOverlayManager mOverlayManager;

	@Override

	protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);

	setContentView(R.layout.come);
	
	Button button02 = (Button)findViewById(R.id.button2);
	button02.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v) {
		 finish();		}
	});
	
	
	
	
	MapContainer = (LinearLayout) findViewById(R.id.map);
	mMapView = new NMapView(this);
	mMapController = mMapView.getMapController();
	mMapView.setApiKey(API_Key);
	MapContainer.addView(mMapView);
	mMapView.setClickable(true);
	mMapView.setBuiltInZoomControls(true, null);
	mMapView.setOnMapStateChangeListener(this);
	
	mMapViewerResourceProvider = new NMapViewerResourceProvider(this);
	mOverlayManager = new NMapOverlayManager(this, mMapView, mMapViewerResourceProvider);
	int markedId = NMapPOIflagType.PIN;
	
	NMapPOIdata poiData = new NMapPOIdata(1, mMapViewerResourceProvider);
	poiData.beginPOIdata(1);
	poiData.addPOIitem(129.01328802108765, 35.39664162375841, "�泲�ܱ������б�", markedId, 0);
	poiData.endPOIdata();
	
	NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);
	poiDataOverlay.showAllPOIdata(0);
	
	mOverlayManager.setOnCalloutOverlayListener(this);
	
	
	}
	
	

	

	@Override
	public void onAnimationStateChange(NMapView arg0, int animType, int animState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapCenterChange(NMapView mapview, NGeoPoint center) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapCenterChangeFine(NMapView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMapInitHandler(NMapView mapview, NMapError errorInfo) {
		if (errorInfo == null) {
			mMapController.setMapCenter(new NGeoPoint(129.01328802108765, 35.39664162375841), 11);
			
		}
		else {
			android.util.Log.e("���̹�����", "�������� =" + errorInfo.toString());
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onZoomLevelChange(NMapView mapView, int level) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public NMapCalloutOverlay onCreateCalloutOverlay(NMapOverlay arg0,
			NMapOverlayItem arg1, Rect arg2) {
		Toast.makeText(this, arg1.getTitle(), Toast.LENGTH_LONG).show();
		
		
	
		
		return null;
	}
	    
	    






			
			
			
		
		
		

	

}