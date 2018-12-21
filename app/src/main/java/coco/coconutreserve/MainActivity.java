package coco.coconutreserve;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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

<<<<<<< HEAD
        signIn.setOnClickListener(new View.OnClickListener(){
=======
        signIn.setOnClickListener(new View.OnClickListener()
        {
>>>>>>> 0918b058f2ec03df04b0418d3fc3e52832af97c3
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"User SIGNED UP ",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD
        signUp.setOnClickListener(new View.OnClickListener(){
=======

        signUp.setOnClickListener(new View.OnClickListener() {
>>>>>>> 0918b058f2ec03df04b0418d3fc3e52832af97c3
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"User SIGNED UP ",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
            }
        });



    }
}
