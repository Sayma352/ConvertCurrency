package com.example.currencyconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button btnClear, btnCalculate;
    EditText edtxt;
    RadioButton rdUSDtoBDT, rdBDTtoUSD, rdINRtoUSD;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate=findViewById(R.id.btnCalculate);
        btnClear=findViewById(R.id.btnClear);
        edtxt=findViewById(R.id.edtxt);
        rdUSDtoBDT=findViewById(R.id.rdUSDtoBDT);
        rdBDTtoUSD=findViewById(R.id.rdBDTtoUSD);
        rdINRtoUSD=findViewById(R.id.rdINRtoUSD);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double input=new Double(edtxt.getText().toString());

                if(rdBDTtoUSD.isChecked()){
                    double result=ConvertCurrency.bdtUSD(input);
                    edtxt.setText(new Double(result).toString());
                } else if (rdUSDtoBDT.isChecked()) {
                    double result=ConvertCurrency.usdBDT(input);
                    edtxt.setText(new Double(result).toString());

                } else if (rdINRtoUSD.isChecked()) {
                    double result=ConvertCurrency.inrUSD(input);
                    edtxt.setText(new Double(result).toString());

                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxt.setText(" ");
            }
        });
    }
}