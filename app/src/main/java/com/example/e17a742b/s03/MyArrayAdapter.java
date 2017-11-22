package com.example.e17a742b.s03;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by E17A742B on 21/11/17.
 */
public class MyArrayAdapter extends ArrayAdapter< Person > {
    public MyArrayAdapter (Context context , List< Person > myList ) {
        super ( context ,
                 R.layout.row,
               R.id.lblName ,
                myList );

    }

    @Override
    public View getView (int position , View convertView , ViewGroup parent ) {
        View view = super . getView ( position , convertView , parent );
        TextView txtLetter = (TextView) view.findViewById(R.id.lblLetter);
        TextView txtName = (TextView) view.findViewById(R.id.lblName);
        TextView txtDesc = (TextView) view.findViewById(R.id.lblDesc);
        TextView txtColor = (TextView) view.findViewById(R.id.lblColor);

        txtLetter.setText(getItem(position).getFirstLetter());
        txtName.setText(getItem(position).getName());
        txtDesc.setText(getItem(position).getShortProfil());
        txtColor.setBackgroundColor(getItem(position).getLevel().getColor());


        return view ;
    }
}