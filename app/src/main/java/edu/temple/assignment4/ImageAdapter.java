package edu.temple.assignment4;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] ValHeroesArray;

    public ImageAdapter(Context context, ArrayList items, int[] ValHeroesArray) {
        this.context = context;
        this.items = items;
        this.ValHeroesArray = ValHeroesArray;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        ImageView imageView;
        textView.setText(items.get(position));

        if (convertView == null) {

            textView = new TextView(context);
            Typeface btf = Typeface.defaultFromStyle(Typeface.BOLD);
            textView.setTypeface(btf);
            textView.setTextColor(Color.WHITE);
            textView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 400));
            textView.setText(items.get(position));
            textView.setGravity(Gravity.CENTER);

            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(30, 25, 30, 25);
        }
        else{
            textView = (TextView) convertView;
        }
       // textView.setPadding(10, 10, 0, 0);
        //textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
       // textView.setTextSize(22);
        textView.setBackgroundResource(ValHeroesArray[position]);
        textView.setText(items.get(position));
        //imageView.setImageResource(ValHeroesArray[position]);
        return textView;
    }

    /*@Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        ImageView imageView;

        LinearLayout linearLayout;

        if (convertView == null) {

            textView = new TextView(context);
            Typeface btf = Typeface.defaultFromStyle(Typeface.BOLD);
            textView.setTypeface(btf);
            textView.setTextColor(Color.BLACK);
            textView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 400));
            textView.setText(items.get(position));
            textView.setGravity(Gravity.CENTER);

            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(30, 25, 30, 25);
        }
        else{
            imageView = (ImageView) convertView;
            linearLayout = new LinearLayout(context);
            textView = new TextView(context);
            imageView = new ImageView(context);
            textView.setPadding(10, 15, 15, 15);
            textView.setTextSize(22);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;
        }
        else{
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt(1);
        }
        imageView.setImageResource(ValHeroesArray[position]);
        textView.setText(items.get(position));

        return linearLayout;
        }
        textView.setBackgroundResource(ValHeroesArray[position]);
        textView.setText(items.get(position));
        //imageView.setImageResource(ValHeroesArray[position]);
        return textView;
    }*/
}
