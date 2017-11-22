package com.example.e17a742b.s03;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends Activity {

    RadioGroup rd;
    EditText txtEdit;
    Button btnOk;
    RadioButton rdB, rdU,rdE;
    int lvl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadElements();
        loadEvents();
    }

    public void loadElements(){

        rd = (RadioGroup) findViewById(R.id.rd);
        txtEdit = (EditText) findViewById(R.id.editText);
        btnOk = (Button) findViewById(R.id.button);

        rdB = (RadioButton) findViewById(R.id.rdBeginner);
        rdU = (RadioButton) findViewById(R.id.rdUser);
        rdE = (RadioButton) findViewById(R.id.rdExpert);
        rdB.setChecked(true);

    }

    public void loadEvents(){

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = "";
                name = txtEdit.getText().toString();

                if(name.equals("")){
                    Toast.makeText(getApplicationContext(),"You have to enter a name", Toast.LENGTH_SHORT).show();
                }else{
                    Person p = null;

                    Intent i = new Intent();
                    i.putExtra("name",name);
                    i.putExtra("level",lvl);
                    setResult(Activity.RESULT_OK,i);
                    finish();

                }


            }
        });

        rdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvl = 0;
            }
        });

        rdU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvl = 1;
            }
        });

        rdE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvl = 2;
            }
        });



    }

}
