package coco.coconutreserve;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    TextView enterNameTV, paymentChooseTV , filmInformation;
    EditText nameEnter;
    RadioGroup paymentGroup;
    RadioButton payPal, wallet, creditCard;
    Button payButton;
    Boolean isWalletSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        filmInformation = findViewById(R.id.filmInfo);
        enterNameTV = findViewById(R.id.enterNameTV);
        paymentChooseTV = findViewById(R.id.paymentTV);
        nameEnter=  findViewById(R.id.enterNameET);
        paymentGroup = findViewById(R.id.paymentGroup) ;
        payPal =  findViewById(R.id.payPalSelect);
        wallet =  findViewById(R.id.useWallet) ;
        creditCard =  findViewById(R.id.creditCard) ;
        payButton =  findViewById(R.id.payButton);
        isWalletSelected = false;
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isWalletSelected) {
                Intent intent = new Intent(Payment.this, PaymentSuccess.class);
                startActivity(intent);}
                else {
                    Intent intent = new Intent(Payment.this, WalletPayment.class);
                    startActivity(intent);}
            }
        });

        paymentGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedOne) {
                if( checkedOne == R.id.useWallet)
                {
                    isWalletSelected = true;
                    Toast.makeText(Payment.this, "Wallet is selected ", Toast.LENGTH_SHORT).show();
                }
                else if(checkedOne == R.id.creditCard)
                {
                    Toast.makeText(Payment.this, "Credit Card is selected ", Toast.LENGTH_SHORT).show();
                }
                else if( checkedOne == R.id.payPalSelect)
                {
                    Toast.makeText(Payment.this, "PayPal  is selected ", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // if any else button selected go to succes page directly.
    }
}
