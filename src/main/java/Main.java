import Calcul.calcul;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        calcul c = new calcul();
        int A =  (int) -11;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = c.calculNombreParfait((int) A,101);
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}