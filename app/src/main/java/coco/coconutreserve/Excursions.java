package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import coco.coconutreserve.Hotel.HotelDashboard;

public class Excursions extends AppCompatActivity {
    TextView excursions;
    Button backbuttton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursions);

        excursions = findViewById(R.id.excurison);
        backbuttton = findViewById(R.id.backButton);

        // to be continued...
        excursions.setText("SA ");
        backbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Excursions.this, HotelDashboard.class);
                startActivity(intent);
            }
        });

    }
}
