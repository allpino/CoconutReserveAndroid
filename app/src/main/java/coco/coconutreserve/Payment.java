package coco.coconutreserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Payment extends AppCompatActivity {
    TextView enterNameTV, paymentChooseTV;
    EditText nameEnter;
    RadioGroup paymentGroup;
    RadioButton payPal, wallet, creditCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        enterNameTV = (TextView) findViewById(R.id.enterNameTV);
        paymentChooseTV = (TextView) findViewById(R.id.paymentTV);
        nameEnter= (EditText) findViewById(R.id.enterNameET);
        paymentGroup = (RadioGroup) findViewById(R.id.paymentGroup) ;
        payPal =  (RadioButton) findViewById(R.id.payPalSelect);
        wallet = (RadioButton) findViewById(R.id.useWallet) ;
        creditCard = (RadioButton) findViewById(R.id.creditCard) ;

        // add  on click for wallet create a wallet interface. go there and then go back to success page.

        // if any else button selected go to succes page directly.
    }
}
