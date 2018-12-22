package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import coco.coconutreserve.assets.core.Films;

public class SeatSelection extends AppCompatActivity {
    Button passBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        passBut = (Button) findViewById(R.id.pass);

        passBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Payment.class); /// burda önce filmler mi olucak yoksa sinemalar mı gözükecek ?
                startActivity(intent);
            }
        });
    }
}
