package com.example.fomodorobackend.location;

import com.example.fomodorobackend.User.User;
import com.example.fomodorobackend.User.UserService;
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

    private static final UserService userService = new UserService();

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

    public String getOwner(String description) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("locations").document(description);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        LocationPOJO location = null;
        User owner = null;
        if(document.exists()) {

            location= document.toObject(LocationPOJO.class);
            if(location != null) {
                return location.getOwner();
            }
            else{
                return null;
            }


        }else {
            return null;
        }

    }

    public String updateOwner(String description, String username) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();


        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("locations").document(description).update("ownerUsername", username);
        return collectionsApiFuture.get().getUpdateTime().toString();
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
