package com.example.usuario.enrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.enrol.bean.Person;

import java.util.ArrayList;
import java.util.List;

import static com.example.usuario.enrol.R.id.txtLastNameF;
import static com.example.usuario.enrol.R.id.txtLastNameM;
import static com.example.usuario.enrol.R.id.txtNombre;

/**
 * Created by Usuario on 17/04/2017.
 */

public class Tab03Contacts extends Fragment{

    public static List<Person> listPerson = new ArrayList<Person>();
    public int personId = 0;

    public static int layout=android.R.layout.simple_list_item_1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab03,container,false);
        // Inflate the layout for this fragment
        ListView listViews = (ListView)view.findViewById(R.id.listViews);
        ArrayAdapter<Person> arrayAdapter= new ArrayAdapter<Person>(getActivity(), layout, listPerson);
        listViews.setAdapter(arrayAdapter);




        listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person)parent.getItemAtPosition(position);
                personId=person.getId();
                Toast.makeText(getActivity(), person.getId()+" Hola: "+person.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floats);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });

        FloatingActionButton ss = (FloatingActionButton) view.findViewById(R.id.edits);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Register.class);
                i.putExtra("personId", personId);
                startActivity(i);
            }
        });
        FloatingActionButton dd = (FloatingActionButton) view.findViewById(R.id.elimP);
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deltePerson(personId);
                Intent e=new Intent(getActivity(),Tab03Contacts.class);
                startActivity(e);
            }
        });



        return view;
    }



    public void goRegister(){
        Intent i = new Intent(getActivity() , Register.class);
        i.putExtra("personId",0);
        startActivity(i);
    }
    public void deltePerson(int personId){

        List<Person> lista2 = new ArrayList<Person>();
        for (Person person:Tab03Contacts.listPerson){
            if (person.getId()!=personId){

                lista2.add(person);

            }
        }

        MainActivity.listPerson=lista2;

    }

}
