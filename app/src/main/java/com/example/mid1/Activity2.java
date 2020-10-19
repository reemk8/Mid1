package com.example.mid1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {
    Button btn_activity1,btn_activity3,click;
    private TextView reservation;
    EditText name,year;




    String gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btn_activity1 = (Button)findViewById(R.id.btn_activity1);
        btn_activity3 = (Button)findViewById(R.id.btn_activity3);


        name = (EditText)findViewById(R.id.name);
        year = (EditText)findViewById(R.id.birth);


        RadioGroup radioGender=(RadioGroup)findViewById(R.id.radioGender);

        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                int childCount = group.getChildCount();

                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);


                    if(btn.getId()==R.id.radioMale){
                        btn.setText("M");
                    }else{
                        btn.setText("F");
                    }
                    if (btn.getId() == checkedId) {

                        gender=btn.getText().toString();// here gender will contain M or F.

                    }

                }


            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()&&!year.getText().toString().isEmpty()&&gender.compareTo("")!=0)
                {
                    if(gender.compareTo("M")==0)
                    {
                        Toast.makeText(Activity2.this,"Hi Mr "+name+", You are "+year.getText().toString()+" years old",Toast.LENGTH_LONG).show();
                    }
                    else if(gender.compareTo("F")==0)
                    {
                        Toast.makeText(Activity2.this,"Hi Miss "+name+", You are "+year.getText().toString()+" years old",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        btn_activity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this,activity_3.class);
                startActivity(intent);
            }
        });


    }

reservation=(TextView) findViewById(R.id.txtReservation);
    Button button=(Button)findViewById(R.id.bttn2);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Calendar c = Calendar.getInstance ();
            DateFormat txtDate = DateFormat.getDateInstance ();
            DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener () {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    c.set ( Calendar.YEAR, year );
                    c.set ( Calendar.MONTH, monthOfYear );
                    c.set ( Calendar.DAY_OF_MONTH, dayOfMonth );
                    reservation.setText ( String.format ( "Your reservation is " + txtDate.format ( c.getTime () ) ) );

                }


            };
            public boolean onOptionsItemSelected (MenuItem item){
                int id = item.getItemId ();
                if (id == R.id.action_settings) {

                    return true;
                }

                return super.onOptionsItemSelected ( item );
            }

        }





