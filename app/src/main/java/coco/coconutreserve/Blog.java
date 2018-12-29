package coco.coconutreserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
            @Override
            public void onClick(View v) {
            /*    if()
                {

                }
                else if()
                {

                }
                else if()
                {

                }*/
            }
        });

        //blog yazıısnı çek al koy

        blogTextView.setText( "Hello there, this place is actually really nice to stay ! " );



    }
}
