package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.Hotel.HotelDashboard;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Hotel;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.User;
import coco.coconutreserve.assets.core.Utils;

public class PaymentSuccess extends AppCompatActivity {

    TextView pointsTv, pointsValue;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        String appType = getIntent().getExtras().getString("appType");

        pointsTv = findViewById(R.id.pointsTv);
        pointsValue = findViewById(R.id.pointsNumberTv);

        pointsTv.setVisibility(View.INVISIBLE);
        pointsValue.setVisibility(View.INVISIBLE);

        if (appType.equals(Constants.CINEMA))
        {
            pointsTv.setVisibility(View.VISIBLE);
            pointsValue.setVisibility(View.VISIBLE);

            User user = Init.getInstance(appType).getUser();
            user.addPoints(Utils.randomWithRange(10,50));
            pointsValue.setText(user.getPoints()+"");
        }

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;
                if (appType.equals(Constants.CINEMA))
                {
                    intent = new Intent(PaymentSuccess.this, CinemaDashboard.class);
                }
                else if (appType.equals(Constants.HOTEL))
                {

                    intent = new Intent(PaymentSuccess.this, HotelDashboard.class);
                }

                startActivity(intent);
            }
        });

    }
}
