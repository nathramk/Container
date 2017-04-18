package com.example.usuario.enrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.example.usuario.enrol.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Person> listPerson = new ArrayList<Person>();
    public int personId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        //String[] names= {""};
        //listPerson.add(new Person(1,"jenyi","sions","lopez","azaña","sasas"));

        int layout = android.R.layout.simple_list_item_1;
        final ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, layout,listPerson);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person)parent.getItemAtPosition(position);
                personId=person.getId();
                Toast.makeText(MainActivity.this, person.getId()+" Hola: "+person.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });
    }
    public void goRegister(){
        Intent i = new Intent(this , Register.class);
        i.putExtra("personId",0);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_about:
                break;
            case R.id.action_edit:
                Intent i = new Intent(this, Register.class);
                i.putExtra("personId", personId);
                startActivity(i);
                break;
            case R.id.action_Sichronize:
                break;
            case R.id.action_delte:
                deltePerson();
                Intent e=new Intent(this,MainActivity.class);
                startActivity(e);

                break;
            case R.id.action_Tabs:
                Intent io = new Intent(this, TabActvityMain.class);
                startActivity(io);
        }

        return super.onOptionsItemSelected(item);
    }

    public void deltePerson(){

        List<Person> lista2 = new ArrayList<Person>();
        for (Person person:MainActivity.listPerson){
            if (person.getId()!=personId){

                lista2.add(person);

            }
        }

        MainActivity.listPerson=lista2;

    }

}




