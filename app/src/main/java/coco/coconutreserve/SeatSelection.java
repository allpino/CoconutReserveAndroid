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
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.ArrayList;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.CinemaReservation;
import coco.coconutreserve.assets.core.CinemaSaloon;
import coco.coconutreserve.assets.core.CinemaSeat;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Films;
import coco.coconutreserve.assets.core.Hotel;
import coco.coconutreserve.assets.core.HotelReservation;
import coco.coconutreserve.assets.core.HotelRoom;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Place;
import coco.coconutreserve.assets.core.Reservation;
import coco.coconutreserve.assets.core.SeatAndRoom;
import coco.coconutreserve.assets.core.Transportion;
import coco.coconutreserve.assets.core.TransportionReservation;
import coco.coconutreserve.assets.core.TransportionSeat;

public class SeatSelection extends AppCompatActivity {
    Button passBut;
    SeatAndRoom selectedSeat = null;
    Place selectedPlace = null;
    int filmId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        int saloonID = getIntent().getExtras().getInt("saloonId");
        int placeID = getIntent().getExtras().getInt("placeId");
        filmId = getIntent().getExtras().getInt("filmId");
        String appType = getIntent().getExtras().getString("appType");

        Init init = Init.getInstance(appType);
        Place[] places = init.getData();

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
                if (selectedSeat != null && !selectedSeat.isTaken())
                {
                    Intent intent = new Intent(getApplicationContext(),Payment.class);

                    ArrayList<Reservation> reservations = Init.getInstance(appType).getReservations();
                    int id =reservations.size();
                    if (appType.equals(Constants.CINEMA))
                    {

                        Cinema cinema = (Cinema) selectedPlace;
                        CinemaSaloon saloon = cinema.getSaloonByFilm(filmId);
                        reservations.add(new CinemaReservation(id,cinema,saloon,(CinemaSeat)selectedSeat,
                                LocalDateTime.now(),null));
                    }
                    else if (appType.equals(Constants.TRANSPORTION))
                    {
                        reservations.add(new TransportionReservation(id,(Transportion)selectedPlace,
                                (TransportionSeat)selectedSeat,LocalDateTime.now(),null));
                    }
                    else if (appType.equals(Constants.HOTEL))
                    {
                        reservations.add(new HotelReservation(id,(Hotel)selectedPlace,
                                (HotelRoom)selectedSeat,LocalDateTime.now(),null));
                    }


                    intent.putExtra("reservationId",id);
                    intent.putExtra("appType",appType);

                    startActivity(intent);
                }
                else
                    {
                        Toast.makeText(SeatSelection.this, "You must choose an available seat! ", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
