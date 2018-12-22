package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.CinemaSaloon;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Films;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Place;
import coco.coconutreserve.assets.core.SeatAndRoom;

public class SeatSelection extends AppCompatActivity {
    Button passBut;
    SeatAndRoom selectedSeat = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        int saloonID = getIntent().getExtras().getInt("saloonId");
        int placeID = getIntent().getExtras().getInt("placeId");
        String appType = getIntent().getExtras().getString("appType");

        Init init = Init.getInstance(Constants.CINEMA);
        Place[] places = init.getData();

        Place selectedPlace = null;
        SeatAndRoom[] seatAndRooms = null;
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
        }
        else
        {
            seatAndRooms = selectedPlace.getSeats();
        }

        GridView gridView = (GridView) findViewById(R.id.gridSeats);
        gridView.setNumColumns(seatAndRooms[0].getColumnCount());
        SeatAdaptor seatAdaptor = new SeatAdaptor(this, seatAndRooms);
        gridView.setAdapter(seatAdaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    //                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                selectedSeat = (SeatAndRoom) gridView.getItemAtPosition(i);

                TextView seatName = (TextView) findViewById(R.id.seatNameInfo);
                TextView seatPrice = (TextView) findViewById(R.id.seatPrice);
                TextView seatCapactiy = (TextView) findViewById(R.id.seatCapacity);

                String name = "Seat: " + selectedSeat.getName();
                seatName.setText(name);
                String price =  "Price: " + selectedSeat.getPrice() + "$";
                seatPrice.setText(price);
                seatCapactiy.setText("Capacity:" + String.valueOf(selectedSeat.getCapacity()));

            }}
        );

        passBut = (Button) findViewById(R.id.pass);

        passBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedSeat != null)
                {
                    Intent intent = new Intent(getApplicationContext(),Payment.class);
                    startActivity(intent);
                }
            }
        });
    }
}
