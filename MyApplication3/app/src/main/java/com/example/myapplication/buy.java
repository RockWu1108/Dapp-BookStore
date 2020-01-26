package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class buy extends AppCompatActivity {
    EditText edt_pid;
    EditText edt_amount;
    TextView txv_balance;
    Button btn_buy;
    BigInteger pid;
    BigInteger amount;
    BigInteger price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        setId();
        getBlanceOf(MainActivity.credentials.getAddress());

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pid = BigInteger.valueOf(Long.parseLong(edt_pid.getText().toString()));
                amount = BigInteger.valueOf(Long.parseLong(edt_amount.getText().toString()));

                try {
                    //
                   Tuple3<String, BigInteger, BigInteger> result = MainActivity.shop.product(pid).sendAsync().get();

//                  <單位轉換 Wei 轉 Ether>  price = Convert.fromWei(String.valueOf(result.getValue2()), Convert.Unit.ETHER);
                    price = result.getValue2();
//                  System.out.println("price:"+price);





                 TransactionReceipt buy_result = MainActivity.shop.buyProduct(pid,amount,new BigInteger(String.valueOf(price)).multiply(amount)).sendAsync().get();
                  if(buy_result != null){

                      getBlanceOf(MainActivity.credentials.getAddress());
                      Toast.makeText(buy.this,"交易成功!!! \n 交易hash值:"+buy_result.getTransactionHash(),Toast.LENGTH_LONG).show();

                  }
                  else{
                      Toast.makeText(buy.this,"交易失敗!!",Toast.LENGTH_LONG).show();
                  }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });



    }
    //帳戶餘額
    private void getBlanceOf(String address) {

                //BigDecimal 轉 int
                buy.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        BigInteger balance = null;
                        try {
                            balance = MainActivity.admin.ethGetBalance(address, DefaultBlockParameter.valueOf("latest")).sendAsync().get().getBalance();

                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        txv_balance.setText("帳戶餘額："+ Convert.fromWei(String.valueOf(balance), Convert.Unit.ETHER).intValue()+" ether");
                    }
                });

    }


//元件設定
    public void setId(){
        edt_pid = findViewById(R.id.edt_pid);
        edt_amount = findViewById(R.id.edt_amount);
        btn_buy = findViewById(R.id.btn_buy);
        txv_balance = findViewById(R.id.txv_balance);
    }
}
