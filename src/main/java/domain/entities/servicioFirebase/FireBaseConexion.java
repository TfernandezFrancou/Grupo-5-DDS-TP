package domain.entities.servicioFirebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FireBaseConexion {

    static Firestore db;
    public static void conectarFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("resources/firebase.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
        System.out.println("La conexion fue exitosa");

    }
}
