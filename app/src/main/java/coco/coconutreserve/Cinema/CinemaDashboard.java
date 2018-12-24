package coco.coconutreserve.Cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import coco.coconutreserve.Home;
import coco.coconutreserve.Notifications;
import coco.coconutreserve.R;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Films;

public class CinemaDashboard extends AppCompatActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        ListView listView = (ListView) findViewById(R.id.activity_list_of_films);
        FilmAdaptor filmAdaptor = new FilmAdaptor(this, Films.films);
        listView.setAdapter(filmAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),SaloonViewAsList.class);
                Films.Film selectedFilm = (Films.Film) listView.getItemAtPosition(i);
                intent.putExtra("filmId",selectedFilm.getId());
                startActivity(intent);
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(CinemaDashboard.this, Home.class);
                        intent.putExtra("appType",Constants.CINEMA);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent2 = new Intent(CinemaDashboard.this, CinemaDashboard.class);
                        startActivity(intent2);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent3 = new Intent(CinemaDashboard.this, Notifications.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }

/*

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
*/
}
