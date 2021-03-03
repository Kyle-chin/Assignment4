package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    Spinner ValCharacters;

    TextView ttv;
    int[] ValHeroesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        getSupportActionBar().setTitle("Valorant Character Selection");
        ValCharacters = findViewById(R.id.spinner_Valorant);

        ttv = findViewById(R.id.trialTV);
        ArrayList Valheros = new ArrayList<String>();
        Valheros.add("Select a Character...");
        Valheros.add("Killjoy, Mechanic Controller");
        Valheros.add("Omen, Smoke and Mind Game Controller");
        Valheros.add("Phoenix, Fire Duelist");
        Valheros.add("Sage, Combat Medic");
        Valheros.add("Sova, Technological Hunter");
        Valheros.add("Yoru, Rift Walker");

        ValHeroesArray = new int[]{0, R.drawable.killjoy, R.drawable.omen, R.drawable.phoenix_artwork, R.drawable.sage, R.drawable.sova, R.drawable.yoru};

        //ArrayAdapter adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, Valheros);
        ImageAdapter imageAdapter = new ImageAdapter(this, Valheros, ValHeroesArray);


        ValCharacters.setAdapter(imageAdapter);

        ValCharacters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Select a Character...")){

                }
                else{
                    /*String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " +item, Toast.LENGTH_SHORT).show();*/


                    String value = (String)Valheros.get(position);
                    int heroPos = ValHeroesArray[position];
                    Intent launchIntent = new Intent(SelectionActivity.this, displayActivity.class);
                    launchIntent.putExtra("number", value);
                    launchIntent.putExtra("heropos", heroPos);
                    startActivity(launchIntent);

                    Toast.makeText(SelectionActivity.this, "Character Selected", Toast.LENGTH_SHORT).show();
                    //showPicture(position);
                    //characterDescription.setText((parent.getItemAtPosition(position)).toString());
                    //characterDescription.setTextSize(30);
                    //characterDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /*private void showPicture(int position) {
        imageView.setImageResource(ValHeroesArray[position]);
    }*/
}
