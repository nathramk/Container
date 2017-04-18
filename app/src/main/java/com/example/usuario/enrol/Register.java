package com.example.usuario.enrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.enrol.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Register extends AppCompatActivity {

    EditText txtNombre;
    EditText txtLastNameF;
    EditText txtLastNameM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtLastNameF = (EditText) findViewById(R.id.txtLastNameF);
        txtLastNameM = (EditText) findViewById(R.id.txtLastNameM);
        Button btnSave = (Button) findViewById(R.id.btnSave);


        Bundle parameters = getIntent().getExtras();
        final int personId = (int) parameters.getInt("personId");

        /*if(personId!=0){
            Person person = getPersonById(personId);
            txtNombre.setText(person.getName());
            txtLastNameF.setText(person.getLastNameF());
            txtLastNameM.setText(person.getLastNameM());
        }*/

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(personId!=0){
                    Random rn = new Random();
                    int answer = rn.nextInt(1000) + 1;
                    MainActivity.listPerson.add(new Person(answer,txtNombre.getText().toString(),txtLastNameF.getText().toString(),txtLastNameM.getText().toString(),"www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
                    goMain();>
                }else{
                    //modifique*/
                if(personId==0) {
                    Random rn = new Random();
                    int answer = rn.nextInt(1000) + 1;
                    MainActivity.listPerson.add(new Person(answer, txtNombre.getText().toString(),
                            txtLastNameF.getText().toString(), txtLastNameM.getText().toString(), "dsad", "asd"));

                    Tab03Contacts.listPerson.add(new Person(answer, txtNombre.getText().toString(),
                            txtLastNameF.getText().toString(), txtLastNameM.getText().toString(), "dsad", "asd"));
                    goMain();
                }else{

                    editPerson(personId,txtNombre.getText().toString(),txtLastNameF.getText().toString(),txtLastNameM.getText().toString());
                    editPersons(personId,txtNombre.getText().toString(),txtLastNameF.getText().toString(),txtLastNameM.getText().toString());

                }
                goMain();
            }
        });


    }
    public void ingresar(){

    }

    public void editPerson(int personId, String name, String lastNameF, String lastNameM){

        List<Person> lista2 = new ArrayList<Person>();
        for (Person person:MainActivity.listPerson){
            if (person.getId()==personId){

                person.setName(name);
                person.setLastNameF(lastNameF);
                person.setLastNameM(lastNameM);

            }
            lista2.add(person);
        }

        MainActivity.listPerson=lista2;

    }
    public void editPersons(int personId, String name, String lastNameF, String lastNameM){

        List<Person> lista3 = new ArrayList<Person>();
        for (Person person:Tab03Contacts.listPerson){
            if (person.getId()==personId){

                person.setName(name);
                person.setLastNameF(lastNameF);
                person.setLastNameM(lastNameM);

            }
            lista3.add(person);
        }

        MainActivity.listPerson=lista3;

    }
    public void goMain(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_back:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public Person getPersonById(int personId){
        List<Person> listPerson = MainActivity.listPerson ;

        for (Person person:listPerson){
            if(person.getId()==personId){
                return person;
            }
        }
        return null;
    }

}
