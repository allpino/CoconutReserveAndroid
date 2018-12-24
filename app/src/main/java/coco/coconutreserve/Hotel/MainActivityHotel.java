package coco.coconutreserve.Hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import coco.coconutreserve.R;

public class MainActivityHotel extends AppCompatActivity {
    TextView welcomeMessage;
    EditText email;
    EditText password;
    Button signIn;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMessage = (TextView) findViewById(R.id.welcomeText);
        email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passwordText);
        signIn = (Button) findViewById(R.id.signIn);
        signUp = (Button) findViewById(R.id.signUp);
        signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"User SIGNED IN  ",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HotelDashboard.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"User SIGNED UP ",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HotelDashboard.class);
                startActivity(intent);
            }
        });



    }
}
