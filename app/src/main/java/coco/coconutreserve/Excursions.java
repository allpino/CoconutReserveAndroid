package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import coco.coconutreserve.Hotel.HotelDashboard;
import coco.coconutreserve.assets.core.Constants;

public class Excursions extends AppCompatActivity {
    TextView excursions;
    Button backbuttton;
    String appType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursions);
        appType = getIntent().getExtras().getString("appType");
        excursions = findViewById(R.id.excurison);
        backbuttton = findViewById(R.id.backButton);

        // to be continued...
        excursions.setText("Hello ");
        backbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Excursions.this, HotelDashboard.class);
                intent.putExtra("appType",Constants.HOTEL);
                startActivity(intent);
            }
        });

    }
}
