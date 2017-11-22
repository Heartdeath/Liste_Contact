package com.example.e17a742b.s03;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Switch sw;
    TextView txt;
    Button btnMas, btnMenos;
    Person p;
    ArrayList<Person> list;
    Person selectedPerson;
    ArrayAdapter<Person>  myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadElements();
        loadList();
        loadEvents();

    }

    private void loadElements(){

        lv = (ListView) findViewById(R.id.lv);
        sw = (Switch) findViewById(R.id.switch1);
        txt = (TextView) findViewById(R.id.lblName);
        btnMas = (Button) findViewById(R.id.buttonAdd);
        btnMenos = (Button) findViewById(R.id.buttonDel);

    }

    private void loadList(){

        list = p.initPersons();

         myAdapter = new MyArrayAdapter ( MainActivity . this , list );
        lv.setAdapter(myAdapter);
    }

    private void loadEvents(){


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person selected = ((Person)adapterView.getItemAtPosition(i));
                select(selected);
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myAdapter.remove(selectedPerson);
                txt.setText("");
                selectedPerson=null;
                btnMenos.setEnabled(false);

            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             sort();

            }
        });

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,0);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {



        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            Bundle b = data.getExtras();
            String name = b.getString("name");
            int level = b.getInt("level");

            Person p = null;
            switch (level){
                case 0:
                    p = new Person(name, Person.Level.BEGINNER);
                    break;
                case 1:
                    p = new Person(name, Person.Level.USER);
                    break;
                case 2:
                    p = new Person(name, Person.Level.EXPERT);
                    break;
            }
           myAdapter.add(p);
            select(p);
            sort();

        }

    }

    private void sort(){

        if(sw.isChecked()){

            myAdapter.sort(new Person("").LEVEL_PRIORITY);

        }else{
            myAdapter.sort(new Person("").NAME_PRIORITY);


        }

    }

    private void select(Person selected){

        txt.setText(selected.getName());
        selectedPerson = selected;
        btnMenos.setEnabled(true);

    }
}
