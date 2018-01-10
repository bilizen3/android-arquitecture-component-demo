package com.spidev.android_arquitecture_component_demo.ui;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spidev.android_arquitecture_component_demo.R;
import com.spidev.android_arquitecture_component_demo.repository.model.AppDatabase;
import com.spidev.android_arquitecture_component_demo.repository.model.entity.Person;

import java.util.List;

/**
 * Created by Bill on 8/01/2018.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextDni;
    private EditText editTextAddress;
    private Button buttonInsert;
    private Button buttonShow;
    private AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();

        editTextName=findViewById(R.id.editTextName);
        editTextDni=findViewById(R.id.editTextDni);
        editTextAddress=findViewById(R.id.editTextAddress);
        buttonInsert= findViewById(R.id.buttonInsert);
        buttonShow=findViewById(R.id.buttonShow);
        buttonInsert.setOnClickListener(this);
        buttonShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonInsert:

                db.PersonDao().insertAll(new Person(editTextName.getText().toString(),
                        Integer.parseInt(editTextDni.getText().toString()),
                        editTextAddress.getText().toString()));
                Toast.makeText(this, "insert el usuario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonShow:
                String cadena="";
                List<Person> personList=db.PersonDao().getAll();
                for(int i=0;i<personList.size();i++){
                    cadena+=personList.get(i).fullName+"\n";
                }
                Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
