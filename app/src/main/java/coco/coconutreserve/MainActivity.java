package coco.coconutreserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Films;
import coco.coconutreserve.assets.core.Init;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Init init = new Init(Constants.CINEMA);

        Cinema[] cinemas = (Cinema[]) init.getData();

        ListView listView = (ListView) findViewById(R.id.activity_list_of_films);
        FilmAdaptor filmAdaptor = new FilmAdaptor(this, Films.films);
        listView.setAdapter(filmAdaptor);

    }
}
