package com.karandeepsingh.scoreupdate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main2Activity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference,reference2;
    EditText e1,e2;
    Button b1;
    Spinner sp,sp2;
    String[] state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1= findViewById(R.id.editText6);
        e2= findViewById(R.id.editText8);
        b1= findViewById(R.id.button2);
        sp= findViewById(R.id.spinner);
        sp2= findViewById(R.id.spinner2);

        state=getResources().getStringArray(R.array.india_states);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,state);

        sp.setAdapter(arrayAdapter);
        sp2.setAdapter(arrayAdapter);

        database= FirebaseDatabase.getInstance();

        reference=database.getReference("Match");
        reference2=reference.child("Match1");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String team=e1.getText().toString();
                final String team2=e2.getText().toString();

                /*String state_name = sp.getSelectedItem().toString();
                String state_name2 = sp2.getSelectedItem().toString();
                Toast.makeText(Main2Activity.this, ""+state_name, Toast.LENGTH_SHORT).show();*/

                reference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Score score1=new Score();
                        score1.setTeam1Name(team);
                        score1.setTeam2Name(team2);

                        reference.setValue(score1);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
