package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class setproduct extends AppCompatActivity {

    EditText edt_pid;
    EditText edt_pname;
    EditText edt_price;
    Button btn_send;
    TextView txv_hash;
    BigInteger pid;
    String pname;
    BigInteger price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setproduct);
        setID();
          //上架商品按鈕
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                pid = BigInteger.valueOf(Long.parseLong(edt_pid.getText().toString()));
                pname = edt_pname.getText().toString();
                price = BigInteger.valueOf(Long.parseLong(edt_price.getText().toString()));
                try {
                    TransactionReceipt result = MainActivity.shop.setProduct(pid,pname,price).sendAsync().get();
                    txv_hash.setText("交易Hash值:"+"\n"+result.getTransactionHash());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                                try {
//                                    TransactionReceipt result = MainActivity.shop.setProduct(pid,pname,price).send();
//                                    setproduct.this.runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Toast.makeText(setproduct.this,"上架成功",Toast.LENGTH_SHORT).show();
//                                            txv_hash.setText("交易Hash值:"+"\n"+result.getBlockHash());
//                                        }
//                                    });
//                                } catch (Exception e) {
//                                    Toast.makeText(setproduct.this,"上架失敗",Toast.LENGTH_SHORT).show();
//                                    e.printStackTrace();
//                                }
//                            }
//                }).start();

            }
        });
    }

    public void setID(){
        edt_pid = findViewById(R.id.edt_pid);
        edt_pname = findViewById(R.id.edt_pname);
        edt_price =findViewById(R.id.edt_price);
        btn_send =findViewById(R.id.btn_send);
        txv_hash =findViewById(R.id.txv_hash);
    }
}
