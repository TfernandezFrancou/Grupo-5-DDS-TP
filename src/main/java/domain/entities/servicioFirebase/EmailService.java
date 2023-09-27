package domain.entities.servicioFirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

public class EmailService {

    private FirebaseAuth auth;

    public void FirebaseAuthentication() {
        this.auth = FirebaseAuth.getInstance();
    }

    public EmailService(FirebaseAuth auth) {
        this.auth = auth;
    }

    public void createUser(String email, String password) {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = auth.createUser(request);
            System.out.println("Usuario creado: " + userRecord.getUid());
        } catch (FirebaseAuthException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
        }
    }

    public boolean verifyIdToken(String idToken) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            // Aquí puedes acceder a la información del usuario autenticado
            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();
            // Realiza las verificaciones necesarias y lógica de tu aplicación
            return true; // Devuelve true si la autenticación es exitosa
        } catch (FirebaseAuthException e) {
            System.err.println("Error de autenticación: " + e.getMessage());
            return false; // Devuelve false si la autenticación falla
        }
    }
}
