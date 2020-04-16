package com.project.battirtourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


public class rest extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    LinearLayoutManager mLayoutManager;
    // Creating DatabaseReference.
    DatabaseReference databaseReference;
    // Creating StorageReference and DatabaseReference object.
    StorageReference storageReference;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    ArrayList<ImageUploadInfo>imagesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_rest);

// Assign activity this to progress dialog.
        progressDialog = new ProgressDialog (rest.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference(MainActivity.Database_Path+"/Restaurants");

        imagesList = new ArrayList<ImageUploadInfo>();

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);

                    imagesList.add(imageUploadInfo);
                }

                ListView listView = findViewById(R.id.list_view);

                ImagesListAdapter adapter =
                        new ImagesListAdapter(getApplicationContext(), R.layout.adapter_view_layout, imagesList);
                listView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });
    }


///// menu





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rest_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items





        switch (item.getItemId()) {

            case R.id.khirbeh: {
                startActivity(new Intent(getApplicationContext(),
                        khirbeh_menu.class));
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

            }
            break;


            case R.id.terrace: {
                startActivity(new Intent(getApplicationContext(),
                        terrace_menu.class));
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
            }
            break;


            case R.id.ain_jami: {
                startActivity(new Intent(getApplicationContext(),
                        ain_jami_menu.class));
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
            }
            break;


            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
    }




   


