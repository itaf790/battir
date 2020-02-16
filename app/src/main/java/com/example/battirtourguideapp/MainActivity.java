package com.example.battirtourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;


    public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

        private BottomNavigationView bottomNavigationView;

        // hay ll slideshow
        private int[] mImages = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate (savedInstanceState);
            setContentView (R.layout.activity_main);

            // button OnClich
            Button arch = findViewById (R.id.arch);
            Button torist = findViewById (R.id.tourist);
            Button hotel = findViewById (R.id.hotel1);
            Button rest = findViewById (R.id.rest1);

            arch.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent int1 = new Intent (MainActivity.this, arch.class);
                    startActivity (int1);
                }
            });

            hotel.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent int2 = new Intent (MainActivity.this, hotel.class);
                    startActivity (int2);
                }
            });


            rest.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent int3 = new Intent (MainActivity.this, rest.class);
                    startActivity (int3);
                }
            });

            torist.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent int4 = new Intent (MainActivity.this, tourist.class);
                    startActivity (int4);
                }
            });
            //had ll slideshow

            CarouselView carouselView = findViewById (R.id.carouselView);
            carouselView.setPageCount (mImages.length);
            carouselView.setImageListener (new ImageListener () {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource (mImages[position]);

                }
            });
            // carouselView.setImageClickListener (new ImageClickListener () {
            // @Override
            // public void onClick(int position) {
            // Toast.makeText (MainActivity.this, mImagesTitle[position], Toast.LENGTH_SHORT).show ();

            //ll navigation


            bottomNavigationView = findViewById (R.id.nav_view);
            setListeners ();

        }

        private void setListeners() {
            bottomNavigationView.setOnNavigationItemSelectedListener (this);
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            //  If item is Checked make it unchecked
            if (item.isChecked ())
                item.setChecked (false);
            switch (item.getItemId ()) {
                case R.id.navigation_home:
                    // Check the Item

                    item.setChecked (true);
                    break;
                case R.id.navigation_qr:
                    //Check the Item

                    item.setChecked (true);
                    break;
                case R.id.navigation_map:
                    startActivity (new Intent (getApplicationContext (),
                            MapsActivity.class));
                    overridePendingTransition (0, 0);
                    return true;
                    
            }
            return false;
        }


    }




