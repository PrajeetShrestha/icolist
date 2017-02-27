package com.games.radical.icolist.service;

import com.games.radical.icolist.model.IcoModel;

import java.util.ArrayList;

public interface FirebaseDataServiceDelegate {
    void fetchedData(ArrayList<IcoModel> list);
}
