package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activité principale gérant la saisie des informations du formulaire.
 */
public class MainActivity extends AppCompatActivity {

    // Déclaration des composants de l'interface utilisateur
    private EditText inputFullName, fieldMail, fieldMobile, editLocation, editCity;
    private Button actionSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Liaison de la classe avec son fichier de mise en page XML
        setContentView(R.layout.activity_main);

        // Initialisation des vues par leurs identifiants uniques
        inputFullName = findViewById(R.id.inputFullName);
        fieldMail     = findViewById(R.id.fieldMail);
        fieldMobile   = findViewById(R.id.fieldMobile);
        editLocation  = findViewById(R.id.editLocation);
        editCity      = findViewById(R.id.editCity);
        actionSubmit  = findViewById(R.id.actionSubmit);

        // Configuration de l'écouteur de clic pour le bouton de validation
        actionSubmit.setOnClickListener(view -> {
            // Récupération et nettoyage des données saisies par l'utilisateur
            String valName    = inputFullName.getText().toString().trim();
            String valEmail   = fieldMail.getText().toString().trim();
            String valPhone   = fieldMobile.getText().toString().trim();
            String valAddr    = editLocation.getText().toString().trim();
            String valCity    = editCity.getText().toString().trim();

            // Vérification sommaire de la présence des informations essentielles
            if (valName.isEmpty() || valEmail.isEmpty()) {
                Toast.makeText(this, "Identité et Courriel sont obligatoires", Toast.LENGTH_SHORT).show();
                return; // Interruption du processus si les données sont manquantes
            }

            // Création de l'objet Intent pour naviguer vers l'écran de résumé
            Intent nextScreen = new Intent(this, Screen2Activity.class);
            
            // Transfert des données vers la seconde activité via des 'extras'
            nextScreen.putExtra("user_name", valName);
            nextScreen.putExtra("user_mail", valEmail);
            nextScreen.putExtra("user_phone", valPhone);
            nextScreen.putExtra("user_address", valAddr);
            nextScreen.putExtra("user_city", valCity);
            
            // Lancement effectif de l'activité de destination
            startActivity(nextScreen);
        });
    }
}
