package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class displayActivity extends AppCompatActivity {

    TextView characterDescription;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().setTitle("Display Character Selection");
        characterDescription = findViewById(R.id.textViewID);
        imageView = findViewById(R.id.imageViewID);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value = extras.getString("number");
            int heroImg = extras.getInt("heropos");
            characterDescription.setGravity(Gravity.CENTER);
            characterDescription.setText(value);
            characterDescription.setTextSize(30);
            imageView.setImageResource(heroImg);

            //characterDescription.setText((parent.getItemAtPosition(position)).toString());
           // characterDescription.setTextSize(30);
            //characterDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(displayActivity.this, SelectionActivity.class));
    }
}