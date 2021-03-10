package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {


    TextView tvinstruct;
    int[] ValHeroesArray;
    GridView gview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        getSupportActionBar().setTitle("Valorant Character Selection");

        gview = findViewById(R.id.gridviewid);
        tvinstruct = findViewById(R.id.tvinstruct);
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


        gview.setAdapter(imageAdapter);

        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int heroPos = ValHeroesArray[position];
                String value = (String)Valheros.get(position);
                Intent launchIntent = new Intent(SelectionActivity.this, displayActivity.class);
                launchIntent.putExtra("number", value);
                launchIntent.putExtra("heropos", heroPos);
                startActivity(launchIntent);

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /*private void showPicture(int position) {
        imageView.setImageResource(ValHeroesArray[position]);
    }*/
}
