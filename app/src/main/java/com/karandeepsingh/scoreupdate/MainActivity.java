package com.karandeepsingh.scoreupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.maxLength;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e14;
    Button b1,b2;
    TextView t1,t2;

    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);
       // e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editText4);
        e5= (EditText) findViewById(R.id.editText5);
        e14= (EditText) findViewById(R.id.editText14);

        b1= (Button) findViewById(R.id.button3);

        t1= (TextView) findViewById(R.id.textView2);
        t2= (TextView) findViewById(R.id.textView);

        e1.setFilters(new InputFilter[] {new InputFilter.LengthFilter(2)});
        e2.setFilters(new InputFilter[] {new InputFilter.LengthFilter(2)});
        e4.setFilters(new InputFilter[] {new InputFilter.LengthFilter(2)});
        e5.setFilters(new InputFilter[] {new InputFilter.LengthFilter(2)});
        e14.setFilters(new InputFilter[] {new InputFilter.LengthFilter(2)});

        database= FirebaseDatabase.getInstance();

        reference=database.getReference("Score_Updates");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Score score=dataSnapshot.getValue(Score.class);
                /*t1.setText(""+score.getTeam1Name());
                t2.setText(""+score.getTeam2Name());*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String team=e1.getText().toString();
                        String team2=e2.getText().toString();
                        String foul=e4.getText().toString();
                        String foul2=e5.getText().toString();
                        //String escore1=e14.getText().toString();
                        //String escore2=e15.getText().toString();
                        String name1=t1.getText().toString();
                        String name2=t2.getText().toString();

                        Score score1=new Score();
                        score1.setTeam1Score(team);
                        score1.setTeam1Foul(foul);
                        score1.setTeam2Score(team2);
                        score1.setTeam2Foul(foul2);
                       // score1.setEscore1(escore1);
                        //score1.setEscore2(escore2);
                        score1.setTeam1Name(name1);
                        score1.setTeam2Name(name2);
                        reference.setValue(score1);

                        Toast.makeText(MainActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

        });
    }
}
