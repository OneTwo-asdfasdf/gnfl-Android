package com.test1.gnfl;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup;

public class NinthFragment extends Fragment {
	
	public NinthFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_ninth, container, false);
         
        return rootView;
    }
}