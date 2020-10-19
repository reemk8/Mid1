package com.example.mid1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class activity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_3 );


        public class MainActivity extends AppCompatActivity {
            MediaPlayer asniPlayer;
            GridView gridView;
            ArrayList<String> arrayList;
            ArrayAdapter asniAdapter;


            Integer[] Animals = {R.drawable.bird, R.drawable.cat4, R.drawable.cricket,
                    R.drawable.turtle,
                    R.drawable.wolf9,
                    R.drawable.zebra};
            ImageView pic;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate ( savedInstanceState );
                setContentView ( R.layout.activity_main );

                gridView = findViewById ( R.id.gridView );
                arrayList = new ArrayList<String> ();
                Field[] fields = R.raw.class.getFields ();
                for (int i = 0; i < fields.length; i++) {
                    arrayList.add ( fields[i].getName () );
                }

                asniAdapter = new ArrayAdapter ( this, android.R.layout.simple_list_item_1, arrayList );


                gridView.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        if (asniPlayer != null) {
                            asniPlayer.release ();
                        }

                        int resId = getResources ().getIdentifier ( arrayList.get ( i ), "raw", getPackageName () );
                        asniPlayer = MediaPlayer.create ( MainActivity.this, resId );
                        asniPlayer.start ();


                    }
                } );

                GridView grid = (GridView) findViewById ( R.id.gridView );
                final ImageView pic = (ImageView) findViewById ( R.id.imageBird );
                grid.setAdapter ( new ImageAdapter ( this ) );
                grid.setOnItemClickListener ( new AdapterView.OnItemClickListener () {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText ( getBaseContext (), "Selected species" + (position + 1),
                                Toast.LENGTH_SHORT ).show ();
                        pic.setImageResource ( Animals[position] );

                    }
                } );
            }

            public class ImageAdapter extends BaseAdapter {
                private Context context;

                public ImageAdapter(Context c) {
                    context = c;
                }

                @Override
                public int getCount() {
                    return Animals.length;
                }

                @Override
                public Object getItem(int i) {
                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    pic = new ImageView ( context );
                    pic.setImageResource ( Animals[position] );
                    pic.setScaleType ( ImageView.ScaleType.FIT_XY );
                    pic.setLayoutParams ( new GridView.LayoutParams ( 330, 330 ) );
                    return pic;


                }
            }

        }