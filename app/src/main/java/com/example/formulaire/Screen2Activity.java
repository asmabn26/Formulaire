package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activité de récapitulatif affichant les informations saisies dans le formulaire.
 * Cette classe reçoit les données via un Intent et les formate pour l'affichage.
 */
public class Screen2Activity extends AppCompatActivity {

    // Composants graphiques pour l'affichage et l'interaction
    private TextView viewSummary;
    private Button btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Chargement de l'interface graphique de résumé
        setContentView(R.layout.activity_screen2);

        // Liaison des variables avec les éléments du fichier XML
        viewSummary = findViewById(R.id.recap);
        btnGoBack   = findViewById(R.id.btnRetour);

        // Récupération de l'objet Intent contenant les données transférées
        Intent dataReceived = getIntent();

        if (dataReceived != null) {
            // Extraction des chaînes de caractères par leurs clés respectives
            String name  = dataReceived.getStringExtra("user_name");
            String mail  = dataReceived.getStringExtra("user_mail");
            String tel   = dataReceived.getStringExtra("user_phone");
            String loc   = dataReceived.getStringExtra("user_address");
            String town  = dataReceived.getStringExtra("user_city");

            // Construction dynamique de la chaîne de caractères à afficher
            StringBuilder sb = new StringBuilder();
            sb.append("Identité : ").append(clean(name)).append("\n");
            sb.append("E-mail : ").append(clean(mail)).append("\n");
            sb.append("Tél : ").append(clean(tel)).append("\n");
            sb.append("Adresse : ").append(clean(loc)).append("\n");
            sb.append("Ville : ").append(clean(town));

            // Mise à jour du composant TextView avec le résumé complet
            viewSummary.setText(sb.toString());
        }

        // Action de retour : ferme l'activité actuelle pour revenir à la précédente
        btnGoBack.setOnClickListener(v -> finish());
    }

    /**
     * Méthode utilitaire pour traiter les chaînes de caractères nulles ou vides.
     * @param input La chaîne à vérifier.
     * @return La chaîne nettoyée ou un texte par défaut.
     */
    private String clean(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Non spécifié";
        }
        return input.trim();
    }
}
