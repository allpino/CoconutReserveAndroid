package coco.coconutreserve.Transportion;

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
import coco.coconutreserve.assets.core.Transportion;

public class TransportionViewAsList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon_view_as_list);

        Init init = Init.getInstance(Constants.TRANSPORTION);

        Transportion[] transportions = (Transportion[]) init.getData();
        int departureLocationId = getIntent().getExtras().getInt("departureLocationId");
        int arrivalLocationId = getIntent().getExtras().getInt("arrivalLocationId");
        ArrayList<Transportion> avaibleTransportions = new ArrayList<>();

        for (int i = 0; i < transportions.length; i++)
        {
            if (transportions[i].getDepartureLocation().getId() == departureLocationId &&
                    transportions[i].getArrivalLocation().getId() == arrivalLocationId)
            {
                avaibleTransportions.add(transportions[i]);
            }
        }

        Place[] places = new Place[avaibleTransportions.size()];

        for (int i = 0; i < places.length; i++) {
            places[i] = avaibleTransportions.get(i);
        }

        ListView listView = (ListView) findViewById(R.id.listViewSaloon);
        coco.coconutreserve.PlaceAdaptor placeAdaptor = new PlaceAdaptor(this, places);
        listView.setAdapter(placeAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    //                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), SeatSelection.class);
                Transportion selectedTransportion= (Transportion) listView.getItemAtPosition(i);

                intent.putExtra("placeId", selectedTransportion.getId());
                intent.putExtra("appType", Constants.TRANSPORTION);

                startActivity(intent);
            }}
        );
    }
}
