package edu.temple.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        tvinstruct.setText("Please Select a Character...");
        tvinstruct.setTextSize(30);

        Resources res = getResources();
        String[] chars = res.getStringArray(R.array.ValChars_array);
        List<String> list= Arrays.asList(chars);
        ArrayList ValDesc = new ArrayList<String>(list);


        /*ValDesc.add("Killjoy - Mechanic Controller");
        ValDesc.add("Omen - Smoke and Mind Game Controller");
        ValDesc.add("Phoenix - Fire Duelist");
        ValDesc.add("Sage - Combat Medic");
        ValDesc.add("Sova - Technological Hunter");
        ValDesc.add("Yoru - Rift Walker");*/


        ArrayList Valheros = new ArrayList<String>();
        /*Valheros.add("Killjoy");
        Valheros.add("Omen,");
        Valheros.add("Phoenix");
        Valheros.add("Sage");
        Valheros.add("Sova");
        Valheros.add("Yoru");
        */

        ValHeroesArray = new int[]{ R.drawable.killjoy, R.drawable.omen, R.drawable.phoenix_artwork, R.drawable.sage, R.drawable.sova, R.drawable.yoru};

        //ArrayAdapter adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, Valheros);
        ImageAdapter imageAdapter = new ImageAdapter(this, Valheros, ValHeroesArray);


        gview.setAdapter(imageAdapter);

        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int heroPos = ValHeroesArray[position];
                String value = (String) ValDesc.get(position);
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
