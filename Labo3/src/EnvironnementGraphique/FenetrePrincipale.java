package EnvironnementGraphique;

import Vues.DeuxiemeVue;
import Vues.PremiereVue;
import Vues.TroisiemeVue;

import javax.swing.*;
import java.awt.*;

public class FenetrePrincipale extends JFrame {
    /**
     * CRÉATION DE LA FENÊTRE PRINCIPALE
     */
    //Attributs
    private static final String TITRE = "Laboratoire3 - Fenêtre principale";
    private static final Dimension DIMENSION = new Dimension(1400,840);
    public FenetrePrincipale(){

        PanneauPrincipal pan = new PanneauPrincipal();
        setContentPane(pan);
        //L'on passe la fenêtre principale à sauvegarder en paramètre dans Menu
        Menu menu = new Menu(this);
        PremiereVue vue1 = new PremiereVue();
        DeuxiemeVue vue2 = new DeuxiemeVue();
        TroisiemeVue vue3 = new TroisiemeVue();

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
