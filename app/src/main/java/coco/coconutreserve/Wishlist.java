package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.assets.core.Constants;

public class Wishlist extends AppCompatActivity {
    TextView filmInfo, filmInfo2,filmInfo3;
    Button backButton;
    String appType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        appType = getIntent().getExtras().getString("appType");
        filmInfo = findViewById(R.id.filmInfo);
        filmInfo2 = findViewById(R.id.filmInfo2);
        filmInfo3 = findViewById(R.id.filmInfo3);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appType.equals(Constants.CINEMA))
                {
                    Intent intent = new Intent(Wishlist.this, Home.class);
                    intent.putExtra("appType",Constants.CINEMA);
                    startActivity(intent);

                }
                else if(appType.equals(Constants.HOTEL))
                {
                    Intent intent = new Intent(Wishlist.this, Home.class);
                    intent.putExtra("appType",Constants.HOTEL);
                    startActivity(intent);
                }
            }
        });
    }
}
