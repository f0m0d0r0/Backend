package com.example.fomodorobackend.User;

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
public class UserService {




    public User getUserInfo(String username) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(username);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user = null;
        if(document.exists()) {
            user= document.toObject(User.class);
            return user;
        }else {
            return null;
        }

}
    public String saveUserDetails(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getUsername()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateUserPoints(String username, int points) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(username).update("points", points);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    //deprecated stuff
//    public String deleteUser(String name) {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(name).delete();
//        return "Document with User ID "+name+" has been deleted";
//    }

    public String addUserOwnedLocations(String username, String locationName) throws ExecutionException, InterruptedException {

        User tempUser = getUserInfo(username);

        tempUser.addOwnedLocations(locationName);

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(username).set(tempUser);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUserOwnedLocation(String username, String locationName) throws ExecutionException, InterruptedException {
        User tempUser = getUserInfo(username);

        if (tempUser.deleteOwnedLocation(locationName)) {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(username).set(tempUser);
            return collectionsApiFuture.get().getUpdateTime().toString();
        }
        else {
            return "Location not owned by user. Returned";
        }
    }




}
