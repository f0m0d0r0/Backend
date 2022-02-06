package com.example.fomodorobackend.location;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class LocationService {




    public LocationPOJO getLocationInfo(String description) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("locations").document(description);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        LocationPOJO location = null;
        if(document.exists()) {
            location= document.toObject(LocationPOJO.class);
            return location;
        }else {
            return null;
        }

    }

    public String saveLocationDetails(LocationPOJO location) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("locations").document(location.getDescription()).set(location);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    //unnecessary
    public String updateLocationDetails(LocationPOJO location) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("locations").document(location.getDescription()).set(location);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
