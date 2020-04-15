package com.example.currencylikeappwin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvAgg1, tvAgg2, tvCurrency, tvUpdate;
    private TextView edtIn1, edtIn2;
    private Spinner spnIn1, spnIn2;
    ImageButton btnDel;
    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, btnDot, btnCE;
    double money;
    StringBuilder toMoney;
    int in1 = 0, in2 = 0;
    boolean isOne = true;
    double multi;
    NumberFormat nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        toMoney = new StringBuilder();
        toMoney.append("0");
        nf = NumberFormat.getInstance(new Locale("en", "US"));
        tvUpdate.setText("Updated 15-Apr-20 00:06");
        spnIn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                in1 = position;
                if(position == 0) tvAgg1.setText("₫");
                else if(position == 1) tvAgg1.setText("€");
                else if(position == 2) tvAgg1.setText("¥");
                else if(position == 3) tvAgg1.setText("$");
                else if(position == 4) tvAgg1.setText("£");
                Conver1();
                SetText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnIn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                in2 = position;
                if(position == 0) tvAgg2.setText("₫");
                else if(position == 1) tvAgg2.setText("€");
                else if(position == 2) tvAgg2.setText("¥");
                else if(position == 3) tvAgg2.setText("$");
                else if(position == 4) tvAgg2.setText("£");
                Conver1();
                SetText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    private void Mapping() {
        tvAgg1 = findViewById(R.id.tvAgg1);
        tvAgg2 = findViewById(R.id.tvAgg2);
        edtIn1 = findViewById(R.id.edtIn1);
        edtIn2 = findViewById(R.id.edtIn2);
        spnIn1 = findViewById(R.id.spnIn1);
        spnIn2 = findViewById(R.id.spnIn2);
        btnDel = findViewById(R.id.btnDel);
        btnCE = findViewById(R.id.btnCE);
        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);
        btnDot = findViewById(R.id.btnDot);
        tvUpdate = findViewById(R.id.tvUpdate);
        tvCurrency = findViewById(R.id.tvCurrency);

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        edtIn1.setOnClickListener(this);
        edtIn2.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapterIn1 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);

        adapterIn1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterIn2 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);

        adapterIn2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnIn1.setAdapter(adapterIn1);
        spnIn2.setAdapter(adapterIn2);

    }
    private void Conver1(){
       if(in1 == 0){
           if(in2 == 0){
               tvCurrency.setText("1 VND = 1 VND");
               multi = 1;
           }else if(in2 == 1){
               tvCurrency.setText("1 VND = 0.00003894 EUR");
               multi = 0.00003894;
           }else if(in2 == 2){
               tvCurrency.setText("1 VND = 0.00457 JPY");
               multi = 0.00457;
           }else if(in2 == 3){
               tvCurrency.setText("1 VND = 0.00004266 USD");
               multi = 0.00457;

           }else if(in2 == 4){
               tvCurrency.setText("1 VND = 0.00003397 GBD");
               multi = 0.00457;
           }
       }
        if(in1 == 1){
            if(in2 == 0){
                tvCurrency.setText("1 EUR = 25682.0423 VND");
                multi = 25682.0423;
            }else if(in2 == 1){
                tvCurrency.setText("1 EUR = 1 EUR");
                multi = 1;
            }else if(in2 == 2){
                tvCurrency.setText("1 EUR = 117.377 JPY");
                multi = 117.377;
            }else if(in2 == 3){
                tvCurrency.setText("1 EUR = 0.9127 USD");
                multi = 0.9127;
            }else if(in2 == 4){
                tvCurrency.setText("1 EUR = 1.1462 GBD");
                multi = 1.1462;
            }
        }
        if(in1 == 2){
            if(in2 == 0){
                tvCurrency.setText("1 JPY = 218.7996 VND");
                multi = 218.7996;
            }else if(in2 == 1){
                tvCurrency.setText("1 JPY = 0.00852 EUR");
                multi = 0.00852;
            }else if(in2 == 2){
                tvCurrency.setText("1 JPY = 1 JPY");
                multi = 1;
            }else if(in2 == 3){
                tvCurrency.setText("1 JPY = 0.009334 USD");
                multi = 0.009334;
            }else if(in2 == 4){
                tvCurrency.setText("1 JPY = 0.007433 GBD");
                multi = 0.007433;
            }
        }
        if(in1 == 3){
            if(in2 == 0){
                tvCurrency.setText("1 USD = 23440 VND");
                multi = 23440;
            }else if(in2 == 1){
                tvCurrency.setText("1 USD = 0.9127 EUR");
                multi = 0.9127;
            }else if(in2 == 2){
                tvCurrency.setText("1 USD = 107.13 JPY");
                multi = 107.13;
            }else if(in2 == 3){
                tvCurrency.setText("1 USD = 1 USD");
                multi = 1;
            }else if(in2 == 4){
                tvCurrency.setText("1 USD = 0.7963 GBD");
                multi = 0.7963;
            }
        }
        if(in1 == 4){
            if(in2 == 0){
                tvCurrency.setText("1 GBD = 29436.1422 VND");
                multi = 29436.1422;
            }else if(in2 == 1){
                tvCurrency.setText("1 GBD = 1.1462 EUR");
                multi = 1.1462;
            }else if(in2 == 2){
                tvCurrency.setText("1 GBD = 134.5347 JPY");
                multi = 134.5347;
            }else if(in2 == 3){
                tvCurrency.setText("1 GBD = 1.2558 USD");
                multi = 1.2558;
            }else if(in2 == 4){
                tvCurrency.setText("1 GBD = 1 GBD");
                multi = 1;
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnNum0:
                toMoney.append("0");
                break;
            case R.id.btnNum1:
                toMoney.append("1");
                break;
            case R.id.btnNum2:
                toMoney.append("2");
                break;
            case R.id.btnNum3:
                toMoney.append("3");
                break;
            case R.id.btnNum4:
                toMoney.append("4");
                break;
            case R.id.btnNum5:
                toMoney.append("5");
                break;
            case R.id.btnNum6:
                toMoney.append("6");
                break;
            case R.id.btnNum7:
                toMoney.append("7");
                break;
            case R.id.btnNum8:
                toMoney.append("8");
                break;
            case R.id.btnNum9:
                toMoney.append("9");
                break;
            case R.id.edtIn1:
                isOne = true;
                break;
            case R.id.edtIn2:
                isOne = false;
                break;
            case R.id.btnCE:
                toMoney = new StringBuilder();
                toMoney.append("0");
                break;
            case R.id.btnDel:
                toMoney.deleteCharAt(toMoney.length() - 1);
                break;
        }
        SetText();

    }

    private void SetText() {
        money = Integer.parseInt(toMoney.toString());
        String varMoney = nf.format(money);
        if(isOne){
            edtIn1.setText(""+varMoney);
            String var = nf.format(money * multi);
            edtIn2.setText(var);
        }else {
            edtIn2.setText(""+varMoney);
            String var = nf.format(money / multi);
            edtIn1.setText(var);
        }
    }
}
