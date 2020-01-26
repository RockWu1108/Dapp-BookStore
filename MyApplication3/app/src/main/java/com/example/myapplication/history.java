package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.web3j.tuples.generated.Tuple2;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class history extends AppCompatActivity {
    EditText edt_pid;
    Button btn_send;
    BigInteger pid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setId();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pid = BigInteger.valueOf(Long.parseLong(edt_pid.getText().toString()));
                try {
                    Tuple2<String, BigInteger> result  =MainActivity.shop.getHistory(pid).sendAsync().get();
                    if(result.getValue1().equals("")) {
                        Toast.makeText(history.this, "您未購滿買過此書", Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(history.this, result.getValue1() + "你購買了:" + result.getValue2() + "本", Toast.LENGTH_LONG).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setId(){
        edt_pid = findViewById(R.id.edt_pid);
        btn_send = findViewById(R.id.btn_send);
    }
}
