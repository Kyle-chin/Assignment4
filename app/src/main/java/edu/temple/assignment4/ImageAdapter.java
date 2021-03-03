package edu.temple.assignment4;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] ValHeroesArray;

    public ImageAdapter(Context context, ArrayList items, int[] ValHeroesArray ){
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
        textView.setText(items.get(position));

        textView.setPadding(10, 10, 0,0);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize(22);

        return textView;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){
        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;

        if(convertView == null) {
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
}
