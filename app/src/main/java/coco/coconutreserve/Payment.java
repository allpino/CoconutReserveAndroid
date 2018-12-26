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

import java.util.ArrayList;

import coco.coconutreserve.assets.core.BuyComponent;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Reservation;
import coco.coconutreserve.assets.core.User;

public class Payment extends AppCompatActivity {
    TextView enterNameTV, paymentChooseTV , seatInfo;
    EditText nameEnter;
    RadioGroup paymentGroup;
    RadioButton payPal, wallet, creditCard, points;
    Button payButton;
    String paymentType = null;
    String appType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        appType = getIntent().getExtras().getString("appType");
        int reservationId = getIntent().getExtras().getInt("reservationId");

        ArrayList<Reservation> reservations = Init.getInstance(appType).getReservations();

        Reservation selectedReservation = reservations.get(reservationId);

        seatInfo = findViewById(R.id.seatInfo);
        seatInfo.setText(selectedReservation.getReservationInfo());
        enterNameTV = findViewById(R.id.enterNameTV);
        paymentChooseTV = findViewById(R.id.paymentTV);
        nameEnter=  findViewById(R.id.enterNameET);
        paymentGroup = findViewById(R.id.paymentGroup) ;
        payPal =  findViewById(R.id.payPalSelect);
        wallet =  findViewById(R.id.useWallet) ;
        creditCard =  findViewById(R.id.creditCard) ;
        payButton =  findViewById(R.id.payButton);
        points = findViewById(R.id.pointsSelect);

        User user = Init.getInstance(appType).getUser();

        if (!appType.equals(Constants.CINEMA))
        {
            points.setVisibility(View.INVISIBLE);
        }
        else if (user.getUserType().equals(Constants.FREE))
        {
            points.setVisibility(View.INVISIBLE);
        }

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentType == null)
                {
                    Toast.makeText(Payment.this, "You must select a payment type ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!paymentType.equals(Constants.WALLET)) {

                        BuyComponent buyComponent = new BuyComponent();
                        if (paymentType.equals(Constants.POINTS))
                        {

                            if (buyComponent.buyWithPoints(user,selectedReservation))
                            {
                                Intent intent = new Intent(Payment.this, PaymentSuccess.class);
                                intent.putExtra("appType",appType);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Payment.this, "You dont have enough points ("+user.getPoints()+")", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            if (buyComponent.buy(paymentType,selectedReservation))
                            {
                                Intent intent = new Intent(Payment.this, PaymentSuccess.class);
                                intent.putExtra("appType",appType);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Payment.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }
                    else
                    {
                        Intent intent = new Intent(Payment.this, WalletPayment.class);
                        intent.putExtra("appType",appType);
                        intent.putExtra("reservationId",reservationId);

                        startActivity(intent);
                    }
                    selectedReservation.setReserverName(nameEnter.getText().toString());
                }
            }
        });

        paymentGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedOne) {
                if( checkedOne == R.id.useWallet)
                {
                    paymentType = Constants.WALLET;
                    Toast.makeText(Payment.this, "Wallet is selected ", Toast.LENGTH_SHORT).show();
                }
                else if(checkedOne == R.id.creditCard)
                {
                    paymentType = Constants.CREDITCARD;
                    Toast.makeText(Payment.this, "Credit Card is selected ", Toast.LENGTH_SHORT).show();
                }
                else if( checkedOne == R.id.payPalSelect)
                {
                    paymentType = Constants.PAYPAL;
                    Toast.makeText(Payment.this, "PayPal  is selected ", Toast.LENGTH_SHORT).show();
                }
                else if ( checkedOne == R.id.pointsSelect)
                {
                    paymentType = Constants.POINTS;
                    Toast.makeText(Payment.this, "Points is selected ", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // if any else button selected go to succes page directly.
    }
}
