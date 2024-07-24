package com.example.myfirstapp;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {


    EditText et_my_name;
    Button my_btn_one;
    TextView tv_my_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et_my_name=(EditText)findViewById(R.id.et_name);
        my_btn_one=(Button)findViewById(R.id.btn_one);
        tv_my_name=(TextView) findViewById(R.id.tv_name);

        my_btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et_my_name.getText().toString();
                tv_my_name.setText("Name: "+name);

                Intent intent = new Intent(MainActivity.this, MyFirstAppActivity2.class);
                startActivity(intent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}