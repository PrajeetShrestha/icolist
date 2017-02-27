package com.games.radical.icolist.service;

import android.util.Log;

import com.games.radical.icolist.model.IcoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by prajeetshrestha on 2/14/17.
 */


public class FirebaseDataService {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference seedRef = database.getReference("seed");
    private FirebaseDataServiceDelegate delegate;

    public FirebaseDataService(FirebaseDataServiceDelegate delegate) {
        this.delegate = delegate;
    }


    public void setupSeedData() {
        ArrayList<IcoModel> list = getSeedData();
        for (IcoModel model : list) {
            seedRef.child(model.name).setValue(model);
        }
    }

    public void getData() {
        // Read from the database
        seedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<IcoModel> list = new ArrayList<>();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    IcoModel model = snap.getValue(IcoModel.class);
                    list.add(model);
                }
                delegate.fetchedData(list);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ERROR", "Failed to read value.", error.toException());
            }
        });
    }

    public ArrayList<IcoModel> getSeedData() {
        IcoModel m1 = new IcoModel("Santiment", "14 Mar 2017", "Closes in a month", "Backed by etherium", "https://bitcoin.org/img/icons/opengraph.png");
        IcoModel m2 = new IcoModel("Chronobank", "15 Feb 2017", "Closes in a day", "Super cool", "https://news.bitcoin.com/wp-content/uploads/2015/09/Bitcoin1.jpg");
        IcoModel m3 = new IcoModel("NEM", "1. Apr 2017", "Closes in a month", "Backed by etherium", "https://azurecomcdn.azureedge.net/mediahandler/acomblog/media/Default/blog/a2bcf4f8-9a5d-4f85-873b-cf94ce537eb0.png");

        IcoModel m4 = new IcoModel("LiteCoin", "19 Feb 2017", "Closes in a month", "Backed by anonymous", "https://coinality.com/wp-content/uploads/company_logos/2014/04/logo-cc5-248x250.png");
        IcoModel m5 = new IcoModel("Etherium", "28 Feb 2017", "Closes in a week", "Backed by Bit Coun", "https://upload.wikimedia.org/wikipedia/commons/6/61/MemeCoin_Crypto_Currency_Logo.png");
        ArrayList<IcoModel> seedData = new ArrayList<>();
        seedData.add(m1);
        seedData.add(m2);
        seedData.add(m3);
        seedData.add(m4);
        seedData.add(m5);
        return seedData;
    }
}
