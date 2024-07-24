package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        EditText Weight, Height, inches;
        Button Btn;
        TextView textView;

        Weight=findViewById(R.id.etWeight);
        Height=findViewById(R.id.etHeight);
        inches=findViewById(R.id.etInch);
        Btn=findViewById(R.id.btncalculator);
        textView=findViewById(R.id.tvRes);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wt=Integer.parseInt(Weight.getText().toString());
                int Ht=Integer.parseInt(Height.getText().toString());
                int Inch=Integer.parseInt(inches.getText().toString());

                int totalInch=Ht*12+Inch;
                double totalCm=totalInch*2.53;
                double totalMeter=(totalCm/100);

                double bmi= wt/(totalMeter*totalMeter);

                if (bmi>25)
                {
                    textView.setText("you are Crossing the limit");
                } else if (bmi<18) {
                    textView.setText(" You are Unhealthy");

                }
                else {
                    textView.setText(" Healthy");
                }

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}