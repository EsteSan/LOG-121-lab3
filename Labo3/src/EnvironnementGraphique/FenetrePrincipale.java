package EnvironnementGraphique;

import Vues.DeuxiemeVue;
import Vues.PremiereVue;
import Vues.TroisiemeVue;

import javax.swing.*;

import Controleur.ControlVueTranslation;

import java.awt.*;
import java.io.IOException;

public class FenetrePrincipale extends JFrame {
    /**
     * CRÉATION DE LA FENÊTRE PRINCIPALE
     */
    //Attributs
    private static final String TITRE = "Laboratoire3 - Fenêtre principale";
    private static final Dimension DIMENSION = new Dimension(1400,840);
    public static PremiereVue vue1;
    public FenetrePrincipale() throws IOException {

        PanneauPrincipal pan = new PanneauPrincipal();
        setContentPane(pan);
        //L'on passe la fenêtre principale à sauvegarder en paramètre dans Menu
         vue1 = new PremiereVue();
        DeuxiemeVue vue2 = new DeuxiemeVue();
        TroisiemeVue vue3 = new TroisiemeVue();
        

       
        Menu menu = new Menu(this,vue1,vue2,vue3);

        //Ajout de la barre de menu dans le panneau
        pan.add(menu);
        //Ajout des trois vues
        pan.add(vue1);
        pan.add(vue2);
        pan.add(vue3);

        setTitle(TITRE);
        setSize(DIMENSION);
        // Centrer la fenêtre
        setLocationRelativeTo(null);
        // Redimensionnement impossible
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }

}
