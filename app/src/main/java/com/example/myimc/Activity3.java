package com.example.myimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView resultatImc,interpretation;
    private Button recalculer;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        resultatImc=findViewById(R.id.resultatImc);
        interpretation=findViewById(R.id.interpretation);
        recalculer=findViewById(R.id.recalculer);
        imageView3=findViewById(R.id.imageView3);


        float imc=getIntent().getExtras().getFloat("imc");

        resultatImc.setText("Votre IMC est de :"+imc);


        Log.i("", "onCreate: "+resultatImc);

        if(imc<18.5){
            interpretation.setTextColor(Color.GREEN);
            interpretation.setText("Attention votre IMC est dans la zone : Insuffisance pondérale (maigreur)" );
            imageView3.setImageResource(R.drawable.maigre);

        }
        if(imc>=18.5 && imc<25){
            interpretation.setTextColor(Color.GREEN);
            interpretation.setText(" votre IMC est dans la zone : Corpulence normale" );
            imageView3.setImageResource(R.drawable.moyen);

        }
        if(imc>=25 && imc<30){
            interpretation.setTextColor(Color.YELLOW);
            interpretation.setText(" votre IMC est dans la zone : Surpoids" );
            imageView3.setImageResource(R.drawable.moyeno);
        }
        if(imc>=30 && imc<35){
            interpretation.setTextColor(Color.YELLOW);
            interpretation.setText("Attention votre IMC est dans la zone : Obésité modérée" );
            imageView3.setImageResource(R.drawable.groso);

        }
        if(imc>=35 && imc<40){
            interpretation.setTextColor(Color.RED);
            interpretation.setText("Attention votre IMC est dans la zone : Obésité sévère" );
            imageView3.setImageResource(R.drawable.gros);

        }
        if(imc>=40 ){
            interpretation.setTextColor(Color.RED);
            interpretation.setText("Attention votre IMC est dans la zone : Obésité morbide ou massive" );
            imageView3.setImageResource(R.drawable.img9);

        }

        recalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent monIntent1=new Intent(getApplicationContext(),Activity2.class);
                startActivity(monIntent1);
            }
        });




    }
}