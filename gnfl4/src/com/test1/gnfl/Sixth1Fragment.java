package com.test1.gnfl;


import java.util.ArrayList;
import java.util.HashMap;


import learn2crack.listview.library.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Sixth1Fragment extends Fragment {
	ListView list;
	TextView ver;
	TextView name;
	TextView api;
	
	ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
	ArrayList<HashMap<String, String>> oslis = new ArrayList<HashMap<String, String>>();
	
	//URL to get JSON Array
	private static String url = "http://118.131.159.227/parsingxml/fuckm.json";
	
	//JSON Node Names 
	private static final String TAG_OS = "year";
	private static final String TAG_VER = "day";
	private static final String TAG_NAME = "event";
	private static final String TAG_API = "date";
	
	JSONArray android = null;
	public Sixth1Fragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_sixth1, container, false);
        new JSONParse().execute();
        return rootView;
    }
	private class JSONParse extends AsyncTask<String, String, JSONObject> {
   	 private ProgressDialog pDialog;
   	@Override
       protected void onPreExecute() {
           super.onPreExecute();
            ver = (TextView)getActivity().findViewById(R.id.vers);
			 name = (TextView)getActivity().findViewById(R.id.name);
			 api = (TextView)getActivity().findViewById(R.id.api);
           pDialog = new ProgressDialog(Sixth1Fragment.this.getActivity());
           pDialog.setMessage("Getting Data ...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(true);
           pDialog.show();
           
           
           
   	}
   	
   	@Override
       protected JSONObject doInBackground(String... args) {
   		
   		JSONParser jParser = new JSONParser();

   		// Getting JSON from URL
   		JSONObject json = jParser.getJSONFromUrl(url);
   		return json;
   	}
   	 @Override
        protected void onPostExecute(JSONObject json) {
   		 pDialog.dismiss();
   		 try {
   				// Getting JSON Array from URL
   				android = json.getJSONArray(TAG_OS);
   				for(int i = 0; i < android.length(); i++){
   				JSONObject c = android.getJSONObject(i);
   				
   				// Storing  JSON item in a Variable
   				
   				String name = c.getString(TAG_NAME);
   				String api = c.getString(TAG_API);
   				
   				

   				// Adding value HashMap key => value

   				HashMap<String, String> map = new HashMap<String, String>();

   				map.put(TAG_NAME, name);
   				map.put(TAG_API, api);
   				oslist.add(map);
   				list=(ListView)getActivity().findViewById(R.id.list);
   				ListAdapter adapter = new SimpleAdapter(Sixth1Fragment.this.getActivity(), oslist,
   						R.layout.list_v,
   						new String[] { TAG_NAME, TAG_API }, new int[] {
   								R.id.name, R.id.api});

   				list.setAdapter(adapter);
   				

   				}
   		} catch (JSONException e) {
   			e.printStackTrace();
   		}

   		 
   	 }
   }
}