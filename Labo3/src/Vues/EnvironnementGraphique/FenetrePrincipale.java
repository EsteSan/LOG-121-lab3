package Vues.EnvironnementGraphique;

import Modele.Sauvegarde;
import Vues.DeuxiemeVue;
import Vues.PremiereVue;
import Vues.TroisiemeVue;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class FenetrePrincipale extends JFrame {
    /**
     * CR�ATION DE LA FEN�TRE PRINCIPALE
     */
    //Attributs
    private static final String TITRE = "Laboratoire3 - Fenetre principale";
    private static final Dimension DIMENSION = new Dimension(1400,840);
    public static PremiereVue vue1;

    //CONSTRUCTEUR
    public FenetrePrincipale() throws IOException {

        //L'objet de type Sauvegarde qui servira a sauvegarder les donnees
        Sauvegarde sauve= new Sauvegarde();

        PanneauPrincipal pan = new PanneauPrincipal();
        setContentPane(pan);

        vue1 = new PremiereVue();
        DeuxiemeVue vue2 = new DeuxiemeVue();
        TroisiemeVue vue3 = new TroisiemeVue();


        //L'on passe la fen�tre principale � sauvegarder en param�tre dans Menu
        Menu menu = new Menu(this,vue1,vue2,vue3,sauve);

        //Ajout de la barre de menu dans le panneau
        pan.add(menu);
        //Ajout des trois vues
        pan.add(vue1);
        pan.add(vue2);
        pan.add(vue3);

        /**
         * Proprietes de la fenetre
         */
        setTitle(TITRE);
        setSize(DIMENSION);
        // Centrer la fen�tre
        setLocationRelativeTo(null);
        // Rendre le redimensionnement impossible
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }

}
