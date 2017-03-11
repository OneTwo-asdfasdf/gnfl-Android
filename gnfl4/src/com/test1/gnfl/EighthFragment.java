package com.test1.gnfl;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class EighthFragment extends Fragment {
	
	public EighthFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_eighth, container, false);
        ImageButton button1 = (ImageButton)rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener()
        {
             public void onClick(View v)
             {
                Intent intent = new Intent(getActivity(), come.class);
                startActivity(intent);

             } 

        });

        return rootView;
    }
}