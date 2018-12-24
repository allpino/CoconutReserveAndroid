package coco.coconutreserve.Hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import coco.coconutreserve.PlaceAdaptor;
import coco.coconutreserve.R;
import coco.coconutreserve.SeatSelection;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Hotel;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Place;

public class LocationViewAsList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon_view_as_list);

        Init init = Init.getInstance(Constants.HOTEL);

        Hotel[] hotels = (Hotel[]) init.getData();
        int locationId = getIntent().getExtras().getInt("locationId");
        ArrayList<Hotel> avaibleHotels = new ArrayList<>();

        for (int i = 0; i < hotels.length; i++)
        {
            if (hotels[i].getLocation().getId() == locationId)
            {
                avaibleHotels.add(hotels[i]);
            }
        }

        Place[] places = new Place[avaibleHotels.size()];

        for (int i = 0; i < places.length; i++) {
            places[i] = avaibleHotels.get(i);
        }

        ListView listView = (ListView) findViewById(R.id.listViewSaloon);
        coco.coconutreserve.PlaceAdaptor placeAdaptor = new PlaceAdaptor(this, places);
        listView.setAdapter(placeAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), SeatSelection.class);
                Hotel selectedHotel= (Hotel) listView.getItemAtPosition(i);

                intent.putExtra("placeId", selectedHotel.getId());
                intent.putExtra("appType", Constants.HOTEL);

                startActivity(intent);
            }}
        );
    }
}