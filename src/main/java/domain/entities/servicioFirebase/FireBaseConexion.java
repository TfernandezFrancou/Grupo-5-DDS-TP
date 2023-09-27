package domain.entities.servicioFirebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FireBaseConexion {


    public void conectar() throws IOException {

        // Inicializa FirebaseApp con la configuración de tu proyecto Firebase.
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tu-proyecto.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);

        // Inicializa FirebaseAuth
        FirebaseAuth auth = FirebaseAuth.getInstance();
    }

}
