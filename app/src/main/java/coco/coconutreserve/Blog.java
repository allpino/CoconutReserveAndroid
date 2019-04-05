package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.Hotel.HotelDashboard;
import coco.coconutreserve.Transportion.TransportionDashboard;
import coco.coconutreserve.assets.core.Constants;

public class Blog extends AppCompatActivity {
    private Button dashboard;
    private TextView blogTextView;
    private ImageView blogImage;
    private String appType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        dashboard = findViewById(R.id.dashboardButton);
        blogImage = findViewById(R.id.blogImage);
        blogTextView = findViewById(R.id.blogPost);
        appType = getIntent().getExtras().getString("appType");


        dashboard.setOnClickListener(new View.OnClickListener() {
            Intent intent = null;
            public void onClick(View v) {
                if (appType.equals(Constants.CINEMA))
                {
                    intent = new Intent(Blog.this, CinemaDashboard.class);
                }
                else if (appType.equals(Constants.HOTEL))
                {

                    intent = new Intent(Blog.this, HotelDashboard.class);
                }
                else if (appType.equals(Constants.TRANSPORTION))
                {
                    intent = new Intent(Blog.this, TransportionDashboard.class);
                }
                intent.putExtra("appType",appType);
                startActivity(intent);
            }
        });


        blogTextView.setText( "Hello there, this place is actually really nice to stay ! " );



    }
}
