package coco.coconutreserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import coco.coconutreserve.assets.core.Cinema;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Films;
import coco.coconutreserve.assets.core.Init;

public class Dashboard extends AppCompatActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mTextMessage = (TextView) findViewById(R.id.message);
        Init init = new Init(Constants.CINEMA);

        Cinema[] cinemas = (Cinema[]) init.getData();

        ListView listView = (ListView) findViewById(R.id.activity_list_of_films);
        FilmAdaptor filmAdaptor = new FilmAdaptor(this, Films.films);
        listView.setAdapter(filmAdaptor);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(Dashboard.this, Home.class);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent2 = new Intent(Dashboard.this, Dashboard.class);
                        startActivity(intent2);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent3 = new Intent(Dashboard.this, Notifications.class);
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
