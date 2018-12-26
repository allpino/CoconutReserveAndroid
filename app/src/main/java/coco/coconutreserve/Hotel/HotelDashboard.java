package coco.coconutreserve.Hotel;

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
import coco.coconutreserve.LocationAdaptor;
import coco.coconutreserve.Notifications;
import coco.coconutreserve.R;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Locations;

public class HotelDashboard extends AppCompatActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        ListView listView = (ListView) findViewById(R.id.activity_list_of_films);
        LocationAdaptor locationAdaptor = new LocationAdaptor(this, Locations.locations);
        listView.setAdapter(locationAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),HotelViewAsList.class);
                Locations.Location selectedLocation = (Locations.Location) listView.getItemAtPosition(i);
                intent.putExtra("locationId",selectedLocation.getId());
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
                        Intent intent = new Intent(HotelDashboard.this, Home.class);
                        intent.putExtra("appType",Constants.HOTEL);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent2 = new Intent(HotelDashboard.this, HotelDashboard.class);
                        intent2.putExtra("appType",Constants.HOTEL);
                        startActivity(intent2);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent3 = new Intent(HotelDashboard.this, Notifications.class);
                        intent3.putExtra("appType",Constants.HOTEL);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }
}
