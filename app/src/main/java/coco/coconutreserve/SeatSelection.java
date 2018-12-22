package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Films;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Place;
import coco.coconutreserve.assets.core.SeatAndRoom;

public class SeatSelection extends AppCompatActivity {
    Button passBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        int saloonID = getIntent().getExtras().getInt("saloonID");
        int placeID = getIntent().getExtras().getInt("placeID");
        String appType = getIntent().getExtras().getString("appType");

        Init init = Init.getInstance(Constants.CINEMA);
        Place[] places = init.getData();

        Place selectedPlace = null;
        SeatAndRoom[][] seatAndRooms = null;
        for (int i = 0; i < places.length; i++)
        {
            if (places[i].getId() == placeID)
            {
                selectedPlace = places[i];
                break;
            }
        }

        if (appType.equals(Constants.CINEMA))
        {
            if (selectedPlace != null)
            {
                seatAndRooms = selectedPlace.getSeats(saloonID);
            }
            else
            {
                seatAndRooms = selectedPlace.getSeats();
            }
        }





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
