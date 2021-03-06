package org.techtown.playlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PlayListItemView extends LinearLayout {

    TextView textView;
    ImageView imageView;

    public PlayListItemView(Context context) {
        super(context);

        init(context);
    }

    public PlayListItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // playlist_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.playlist_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

}