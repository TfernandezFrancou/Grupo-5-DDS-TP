package domain.entities.servicioFirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class GoogleService {

        public static String verificarTokenGoogle(String idToken) throws FirebaseAuthException {
            FirebaseToken tokenGoogle = FirebaseAuth.getInstance().verifyIdToken(idToken);
            return tokenGoogle.getUid();
        }
}
