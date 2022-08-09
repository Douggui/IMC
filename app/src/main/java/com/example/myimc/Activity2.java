package com.example.myimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {
    private EditText poids,taille;
    private TextView textView;
    private Button calculer;
    float imc;
    private ImageView iv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
textView=findViewById(R.id.textView);
        poids=findViewById(R.id.poids);
        taille=findViewById(R.id.taille);
        calculer=findViewById(R.id.calculer);


        textView.setText(R.string.titre_Appli);
        init();

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("calculer", "onClick:  cliqué");

                String strPoids=poids.getText().toString();

                if(strPoids.equals("")){
                    Toast monToast=Toast.makeText(getApplicationContext(),"le champ poids ne peut pas etre vide" , Toast.LENGTH_LONG);
                    monToast.setGravity(Gravity.BOTTOM,0,0);
                    monToast.show();
                    return;
                }


                int intPoids=Integer.parseInt(strPoids);
                Log.i("poids", "onClick: poids"+intPoids);

                if(intPoids<30){
                    Toast monToast=Toast.makeText(getApplicationContext(),"le poids ne peut pas être en dessous de 30" , Toast.LENGTH_LONG);
                    monToast.setGravity(Gravity.BOTTOM,0,0);
                    monToast.show();
                    return;
                }
                if(intPoids>300){
                    Toast monToast=Toast.makeText(getApplicationContext(),"le poids ne peut pas être au dessus de 300" , Toast.LENGTH_LONG);
                    monToast.setGravity(Gravity.BOTTOM,0,0);
                    monToast.show();
                    return;
                }



                String strTaille=taille.getText().toString();
                strTaille=strTaille.replace(",", ".");

                if(strTaille.equals("")){
                    Toast monToast=Toast.makeText(getApplicationContext(),"le champ taille ne peut pas être vide ",Toast.LENGTH_LONG);
                    monToast.setGravity(Gravity.BOTTOM,0,0);
                    monToast.show();
                    return;
                }
                float floatTaille=Float.parseFloat(strTaille);
                Log.i("taille", "onClick: taille"+floatTaille);

                if(floatTaille<0.80){
                    Toast monToast=Toast.makeText(getApplicationContext(),"la taille  ne peut pas être en dessous de 80 cm " , Toast.LENGTH_LONG);
                    monToast.setGravity(Gravity.BOTTOM,0,0);
                    monToast.show();
                    return;
                }
                if(floatTaille>2.0){
                    Toast monToast=Toast.makeText(getApplicationContext(),"la taille  ne peut pas être au dessus de 2 mètre " , Toast.LENGTH_LONG);
                    monToast.setGravity(Gravity.BOTTOM,0,0);
                    monToast.show();
                    return;
                }





                imc=intPoids/(floatTaille*floatTaille);
                Log.i("imc", "imc: "+imc);
                imc = Math.round(imc*100)/100.0f;



                Intent monIntent1=new Intent(getApplicationContext(),Activity3.class);

                monIntent1.putExtra("imc",imc);
                startActivity(monIntent1);



               /* Intent monIntent=new Intent(getApplicationContext(),Activity3.class);
                monIntent.putExtra("msg",imc);

                startActivity(monIntent);*/

            }
        });




        }
    private void init(){
        poids.setText("");
        taille.setText("");
        poids.requestFocus();
    }
}