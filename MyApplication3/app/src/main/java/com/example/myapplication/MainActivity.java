package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public static Admin admin;
    public static Credentials credentials;
    public static Shop shop;
    TextView txv_account ;
    Button btn_register;
    Button btn_setProduct;
    Button btn_buy;
    Button btn_history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin = Admin.build(new HttpService("http://10.0.2.2:7545"));//連線到Server
        //商家私鑰
        credentials =Credentials.create("0aa52c6d1678e831dcb959e40e507028d6409f741c153c8b45bbb8bd242eb02e");

        //顧客私鑰
        //credentials =Credentials.create("3db413cb17c594e8c7258c274f5cef54cc3043e3f756827b2505a1b4c213e1c1");

        setId();
        setContract();

        //註冊事件
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                     Boolean result =shop.isRegister(credentials.getAddress()).sendAsync().get();

                     if(result == true){

                         Toast.makeText(MainActivity.this,"你已經註冊",Toast.LENGTH_LONG).show();

                     }
                     else{

                         shop.register().sendAsync().get();
                         Toast.makeText(MainActivity.this,"註冊完成",Toast.LENGTH_LONG).show();
                     }

                } catch (Exception e) {

                    e.printStackTrace();
                }



            }
        });

        //購買按鈕
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(MainActivity.this,buy.class);
                startActivity(it);
            }
        });

        //上架按鈕
        btn_setProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(MainActivity.this,setproduct.class);
                startActivity(it);
            }
        });

        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(MainActivity.this,history.class);
                startActivity(it);
            }
        });
    }


    //UI元件設定
    public void setId(){
        txv_account = findViewById(R.id.txv_account);
        btn_register = findViewById(R.id.btn_regiser);
        btn_setProduct = findViewById(R.id.btn_setproduct);
        btn_history = findViewById(R.id.btn_history);
        btn_buy = findViewById(R.id.btn_buy);
        txv_account.setText("帳戶 :" +credentials.getAddress());

    }


    //連接合約設定
    public void setContract(){
        BigInteger GAS_PRICE = BigInteger.valueOf(15_000_000_000L); //手續費價格設定
        BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000L);  // 交易Gas上限
        String contractAddr = "0xd5d9291494f095b2d8057c41554bcf1f772580d7"; //合約地址
        shop = Shop.load(
                contractAddr,
                admin,
                credentials,
                GAS_PRICE,
                GAS_LIMIT);

    }
}
