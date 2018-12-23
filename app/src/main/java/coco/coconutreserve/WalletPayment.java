package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import coco.coconutreserve.assets.core.BuyComponent;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Reservation;
import coco.coconutreserve.assets.core.Wallet;

// pay from wallet

public class WalletPayment extends AppCompatActivity {
    TextView walletName, paymentNumeric, payment, balance, currentWalletInfo, walletBalance, walletNameInfo;
    Button pay;
    Wallet wallet;
    int currentPayment;
    BuyComponent buyComponent;
    Reservation reservation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_payment);
        walletName = findViewById(R.id.walletName);
        paymentNumeric = findViewById(R.id.paymentNumeric);
        payment = findViewById(R.id.payment);
        balance = findViewById(R.id.balance);
        currentWalletInfo = findViewById(R.id.currentWalletInfo);
        walletBalance = findViewById(R.id.walletBalance);
        walletNameInfo = findViewById(R.id.walletNameInfo);
        pay = findViewById(R.id.pay);
        // user wallet info.
        wallet = new Wallet(100, Constants.CINEMA);
        currentPayment = 25;
        buyComponent = new BuyComponent();
        // instance of wallet is created.
        //GET BUY COMPONENT WORK PROPERLY.

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPayment > wallet.getAmount())
                {
                    Toast.makeText( getApplicationContext()," Your wallet does not have enough money. ",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // BUY COMPONENT, BUY WITH WALLET.

                    Intent intent1 = new Intent(WalletPayment.this, PaymentSuccess.class);
                    startActivity(intent1);
                }


            }
        });
    }
}
