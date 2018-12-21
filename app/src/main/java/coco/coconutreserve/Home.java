package coco.coconutreserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(Home.this, Home.class);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent1 = new Intent(Home.this, Dashboard.class);
                        startActivity(intent1);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent2 = new Intent(Home.this, Notifications.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }


}
