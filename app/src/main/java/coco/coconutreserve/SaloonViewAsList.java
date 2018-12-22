package coco.coconutreserve;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.CinemaSaloon;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Place;

public class SaloonViewAsList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon_view_as_list);

        Init init = new Init(Constants.CINEMA);

        Cinema[] cinemas = (Cinema[]) init.getData();
        int filmId = getIntent().getExtras().getInt("filmId");
        ArrayList<Cinema> avaibleCinemas = new ArrayList<>();

        for (int i = 0; i < cinemas.length; i++)
        {
            CinemaSaloon[] cinemaSaloons = cinemas[i].getCinemaSaloons();
            for (int j = 0; j < cinemaSaloons.length ; j++)
            {
                if (cinemaSaloons[j].getFilm().getId() == filmId )
                {
                    avaibleCinemas.add(cinemas[i]);
                }
            }
        }

        Place[] places = new Place[avaibleCinemas.size()];

        for (int i = 0; i < places.length; i++) {
            places[i] = avaibleCinemas.get(i);
        }

        ListView listView = (ListView) findViewById(R.id.listViewSaloon);
        PlaceAdaptor placeAdaptor = new PlaceAdaptor(this,places);
        listView.setAdapter(placeAdaptor);



    }
}
