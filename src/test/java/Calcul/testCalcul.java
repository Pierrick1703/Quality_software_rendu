package Calcul;

import org.junit.Before;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class testCalcul
{
    static ArrayList<Integer> result;
    static ArrayList<Integer> result2;
    static calcul c;
    static Error ex;
    static Error ex1;
    static Error ex2;
    static int valeur;
    static int valeur2;
    static int valeur3;
    static int valeur4;
    static int valeur5;
    static int valeur6;
    static String reponseTest;
    static String reponseTest2;

    @DisplayName("Jeu de données")
    @BeforeAll
    static void beforeAll(){
        c = new calcul();
        result = new ArrayList<Integer>();
        result2 = new ArrayList<Integer>();
        valeur = 15;
        valeur2 = 2;
        valeur3 = 101;
        valeur4 = 1001;
        valeur5 = -11;
        valeur6 = -12;
        result.add(1000);
        result.add(100);
        result.add(10);
        result2.add(100);
        result2.add(10);
    }

    @Test
    @DisplayName("Test d'exception")
    public void testThrowError(){
        ex = assertThrows(Error.class,()-> c.calculNombreParfait(valeur,valeur2),"erreur exception");
        ex1 = assertThrows(Error.class,()-> c.calculNombreParfait(valeur5,valeur),"erreur exception");
        ex2 = assertThrows(Error.class,()-> c.calculNombreParfait(valeur4,valeur6),"erreur exception");
    }


    @Test
    @DisplayName("Test d'execution de calcul")
    public void testValeur(){
        assertEquals(result,c.calculNombreParfait(valeur2,valeur4));
        assertEquals(result2,c.calculNombreParfait(valeur2,valeur3));
        reponseTest = "Test execution sur les valeurs : ["+valeur2+","+valeur4+"] et ["+valeur2+","+valeur3+"]";
    }

    @Test
    @DisplayName("Test de temps d'execution")
    public void testTime(){
        int time = 5;
        assertTimeout(
                Duration.ofMillis(time),
                () -> c.calculNombreParfait(valeur,valeur3),
                "Erreur de temps d'exécution"
        );
        reponseTest2 = "Test de temps d'execution correcte en 5 millieme de seconde";
    }


    @AfterAll()
    @DisplayName("Affichage des résultat des test")
    static void afterAll(){
        System.out.println("Résultat du test de message d'erreur : "+ex);
        System.out.println("Résultat du test de message d'erreur :" + ex1);
        System.out.println("Résultat du test de message d'erreur :" + ex2);
        System.out.println(reponseTest);
        System.out.println(reponseTest2);
    }
}
