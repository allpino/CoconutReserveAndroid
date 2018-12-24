package coco.coconutreserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.assets.core.Constants;

public class Notifications extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

//// ON THIS PAGE, DISCOUNTS WILL BE SHOWN.

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_notifications);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(Notifications.this, Home.class);
                        intent.putExtra("appType",Constants.CINEMA);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent1 = new Intent(Notifications.this, CinemaDashboard.class);
                        startActivity(intent1);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent2 = new Intent(Notifications.this, Notifications.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

    }

}
