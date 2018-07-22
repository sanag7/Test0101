package com.ebookfrenzy.calculator3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.PublicKey;

public class Adapter extends PagerAdapter{

    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three};
    private LayoutInflater inflater;
    private Context context;

    public Adapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }

    public Object instantiateitem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView2);
        TextView textView = (TextView) v.findViewById(R.id.textView2);
        imageView.setImageResource(images[position]);
        textView.setText((position + 1));
        container.addView(v);
        return v;
    }


    @Override
    public void destroyItem(ViewGroup container,int position, Object object){
        container.invalidate();

    }

}
