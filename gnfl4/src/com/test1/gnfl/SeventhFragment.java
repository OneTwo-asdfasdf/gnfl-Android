package com.test1.gnfl;


import android.app.Fragment;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup;
import android.widget.TextView;

public class SeventhFragment extends Fragment {
	
	public SeventhFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_seventh, container, false);
        TextView txtPhone1 = (TextView)rootView.findViewById(R.id.tel1);
        Linkify.addLinks(txtPhone1, Linkify.PHONE_NUMBERS);
        
        TextView txtPhone2 = (TextView)rootView.findViewById(R.id.tel2);
        Linkify.addLinks(txtPhone2, Linkify.PHONE_NUMBERS);
        
        TextView txtPhone3 = (TextView)rootView.findViewById(R.id.tel3);
        Linkify.addLinks(txtPhone3, Linkify.PHONE_NUMBERS);
        
        TextView txtPhone4 = (TextView)rootView.findViewById(R.id.tel4);
        Linkify.addLinks(txtPhone4, Linkify.PHONE_NUMBERS);
        
        TextView txtPhone5 = (TextView)rootView.findViewById(R.id.tel5);
        Linkify.addLinks(txtPhone5, Linkify.PHONE_NUMBERS);
        
        TextView txtPhone6 = (TextView)rootView.findViewById(R.id.tel6);
        Linkify.addLinks(txtPhone6, Linkify.PHONE_NUMBERS);
        
        TextView txtPhone7 = (TextView)rootView.findViewById(R.id.tel7);
        Linkify.addLinks(txtPhone7, Linkify.PHONE_NUMBERS);
        

        return rootView;
    }
}