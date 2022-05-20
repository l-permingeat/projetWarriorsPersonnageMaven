package fr.ecoleNum.com;

import fr.ecoleNum.com.moteurDuJeu.projetwarriorspersonnage.Game;

public class Main {
    /* ***************************** Execution du code  ********************************************* */
    public static void main(String[] args) {
        String dataBaseOk = null;
        for(int i=0;i< args.length;i++){
            dataBaseOk=args[0];
        }
        Game game = new Game(dataBaseOk);
        game.start();
    } // fin void main
}
