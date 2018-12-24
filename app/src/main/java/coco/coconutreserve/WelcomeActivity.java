package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import coco.coconutreserve.Cinema.MainActivity;
import coco.coconutreserve.Hotel.MainActivityHotel;

public class WelcomeActivity extends AppCompatActivity {
    TextView welcome;
    Button cinemaButton,hotelButton , transportation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        cinemaButton = findViewById(R.id.cinemaApp);
        hotelButton = findViewById(R.id.hotelApp);
        transportation = findViewById(R.id.transportApp);

        cinemaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to cinema
                Intent intent1 = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        hotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to hotel
                Intent intent1 = new Intent(WelcomeActivity.this, MainActivityHotel.class);
                startActivity(intent1);
            }
        });

        transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// go to transportation
             //   Intent intent1 = new Intent(WelcomeActivity.this, PaymentSuccess.class);
                //startActivity(intent1);
            }
        });
    }
}
