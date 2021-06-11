package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView textName, textView, textAns;
    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btAdd, btSub, btMul, btDiv, btEqu, btFac, btC, btB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        textName = findViewById(R.id.textName);
        textName.setText(name);

        textView = findViewById(R.id.textView6);
        textAns = findViewById(R.id.textView7);

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        btAdd = findViewById(R.id.btAdd);
        btSub = findViewById(R.id.btSub);
        btMul = findViewById(R.id.btMul);
        btDiv = findViewById(R.id.btDiv);
        btEqu = findViewById(R.id.btEqu);
        btFac = findViewById(R.id.btFac);
        btC = findViewById(R.id.btC);
        btB = findViewById(R.id.btB);

        bt0.setOnClickListener(myListener);
        bt1.setOnClickListener(myListener);
        bt2.setOnClickListener(myListener);
        bt3.setOnClickListener(myListener);
        bt4.setOnClickListener(myListener);
        bt5.setOnClickListener(myListener);
        bt6.setOnClickListener(myListener);
        bt7.setOnClickListener(myListener);
        bt8.setOnClickListener(myListener);
        bt9.setOnClickListener(myListener);
        btAdd.setOnClickListener(myListener);
        btSub.setOnClickListener(myListener);
        btMul.setOnClickListener(myListener);
        btDiv.setOnClickListener(myListener);
        btEqu.setOnClickListener(myListener);
        btFac.setOnClickListener(myListener);
        btB.setOnClickListener(myListener);
        btC.setOnClickListener(myListener);

    }

    private Button.OnClickListener myListener = new Button.OnClickListener() {
        private String st;
        @Override
        public void onClick(View view) {
            Button btn = (Button) findViewById(view.getId());
            if (btn.getText().toString().equals("B")) {
                st = st.substring(0, st.length() - 1);
            } else if (btn.getText().toString().equals("C")) {
                st = "";
            } else if (btn.getText().toString().equals("X!")) {
                int a = 1;
                int i;
                int n = Integer.valueOf(st);
                for (i = 1; i <= n; i++) {
                    a = a * i;
                }
                textAns.setText(Integer.toString(a));
            } else if (btn.getText().toString().equals("=")) {
                for (int i = 0; i < st.length(); i++) {
                    if (st.charAt(i) == '*' || st.charAt(i) == '/') {
                        int j;
                        String f = "";
                        for (j = i - 1; j >= 0; j--) {
                            if (st.charAt(j) == '*' || st.charAt(j) == '/' || st.charAt(j) == '+' || st.charAt(j) == '-')
                                break;
                            else f = st.charAt(j) + f;
                        }
                        int k;
                        String b = "";
                        for (k = i + 1; k < st.length(); k++) {
                            if (st.charAt(k) == '*' || st.charAt(k) == '/' || st.charAt(k) == '+' || st.charAt(k) == '-')
                                break;
                            else b = b + st.charAt(k);
                        }
                        int temp;
                        if (st.charAt(i) == '*') temp = Integer.valueOf(f) * Integer.valueOf(b);
                        else temp = Integer.valueOf(f) / Integer.valueOf(b);
                        st = temp + st.substring(k,st.length());
                        i = j;
                    }
                }
                if(st.charAt(0) != '-') st = "+" + st;
                int ans = 0;
                for (int i = 0; i < st.length(); ) {
                    if (st.charAt(i) == '+' || st.charAt(i) == '-') {
                        int j;
                        String t = "";
                        for (j = i + 1; j < st.length(); j++) {
                            if (st.charAt(j) == '+' || st.charAt(j) == '-') break;
                            else t = t + st.charAt(j);
                        }if (st.charAt(i) == '+') ans = ans + Integer.valueOf(t) ;
                        else ans = ans - Integer.valueOf(t);
                        i = j;
                    }
                }st = "";
                textView.setText(st);
                textAns.setText(Integer.toString(ans));
            }else{
                st = textView.getText().toString() + btn.getText().toString();
            }
            textView.setText(st);
        }
    };
}