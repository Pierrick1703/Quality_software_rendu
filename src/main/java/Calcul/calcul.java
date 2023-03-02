package Calcul;

import java.util.ArrayList;
import java.util.List;

public class calcul {

    /* Fonction de test si les valeurs en paramètres sont bien exploitable (A < B)*/
    boolean testValeur(int A, int B){
        boolean result = false;
        if(A < 0){
            throw new Error("Il faut que le nombre soit positif : "+A);
        } else if(B < 0){
            throw new Error("Il faut que le nombre soit positif : "+B);
        }
        else if(A < B){
            result = true;
        } else{
            throw new Error("Il faut que le premier nombre soit strictement supérieur au second");
        }
        return result;
    }

/**
 * Fonction publique qui retourne un ArrayList d'entier correspondant aux nombres parfaits
 * avec en paramètre un nombre de départ et un d'arriver
 * */
    public ArrayList<Integer> calculNombreParfait(int A, int B){
        ArrayList<Integer>  result = new ArrayList<Integer>();
        if(testValeur(A,B)){//vérification que le nombre A est plus petit que B
            int intervalle = B - A;
            for(int i = 0; i < intervalle; i++){//Boucle pour vérifier chaque valeur dans l'intervalle entre A et B
                int chiffre = B - i + 1;
                String number = String.valueOf(chiffre);
                char[] digit = number.toCharArray();
                int sum = 0;
                for(int j = 0; j < digit.length;j++){//Boucle pour séparer et calculer chaque digit pour chacun des nombres de l'intervalle
                    int valeur = Integer.parseInt(Character.toString(digit[j]));//transformation d'un type char en string puis en int
                    sum += valeur*valeur;
                }
                if(sum == 1){
                    result.add(chiffre);
                }
            }
        }else{ //Les nombres fournit ne sont pas dans un ordre A < B
            throw new Error("Fin du programme problème dans les paramètres");
        }
        return result;
    }
}
