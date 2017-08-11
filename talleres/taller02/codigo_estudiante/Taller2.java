/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.util.*;

/**
 *
 * @author ctezna2
 */
public class Taller2 {
//    public static void main(String[] args){
//        int[] n = {0,1,2,3,4};
//        esValido(n);
//    }
    public static boolean sumaGrupo(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target == 0;
        }
        return sumaGrupo(start + 1, nums, target - nums[start]) || sumaGrupo(start + 1, nums, target);
    }

    public static ArrayList<String> combinations(String s) {
        ArrayList<String> list = new ArrayList<>();
        combinations("", s,list);
        //System.out.println(list.toString());
        return list;
    }

    private static void combinations(String pre, String pos, ArrayList<String> list) {
        int n = pos.length();
        if (n == 0){ 
            list.add(pre);
        } else {
            combinations(pre + pos.charAt(0),  pos.substring(0+1,n), list);
            combinations(pre ,  pos.substring(0+1,n), list);
        }
    }

    public static ArrayList<String> permutations(String s) {
        ArrayList<String> list = new ArrayList<>();
        permutations("", s,list);
        //System.out.println(list.toString());
        return list;
    }

    private static void permutations(String pre, String pos, ArrayList<String> list) {
        int n = pos.length();
        if (n == 0){ 
            list.add(pre);
        } else {
            for (int i = 0; i < n; i++){
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i+1, n),list);
            }
        }
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i){
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
//    public static boolean esValido(int[] tablero) {
//        int n = tablero.length;
//        String str = "";
//        String st = "";
//        StringBuilder a = new StringBuilder();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            a.append(tablero[i]);
//            sb.append(i);
//        }
//        str = a.toString();
//        st = sb.toString();
//        String s = "";
//        ArrayList<String> list = permutations(str);
//        int count = 0;
//        for (int j = 0; j < list.size(); j++) {
//            s = list.get(j);
//            char[] c = s.toCharArray();
//            for (int i = 0; i < n; i++) {
//                if (((int) c[i] - (int) c[n-1]) == (n - i)) {
//                    //return false;
//                    count++;
//                }
//                if (((int) c[n-1] - (int) c[i]) == (n - i)) {
//                    //return false;
//                    count++;
//                }
//            }
//        }
//         if (count == 0) {
//                int solution = Integer.parseInt(s);
//                System.out.println(solution);
//                return true;
//            }
//            return false;
//        }
    public static boolean esValido(int[] tablero) {
        String str = "";
        String st = "";
        StringBuilder a = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int n = tablero.length;
        for (int i = 0; i < n; i++) {
            a.append(tablero[i]);
            sb.append(i);
        }
        str = a.toString();
        st = sb.toString();
        String s = "";
        int count = 0;
        ArrayList<String> list = permutations(str);
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            for (int j = 0; j < s.length() - 1; j++) {
                for (int k = 1; k < s.length(); k++) {
                    int x = (int) s.charAt(j);
                    int y = (int) s.charAt(k);
                    int z = (int) st.charAt(j);
                    int w = (int) st.charAt(k);
                    if (Math.abs(x - y) == Math.abs(z - w)) {
                        count++;
                    }
                }
            }        
            if (count == 0) {
                int solution = Integer.parseInt(s);
                System.out.println(solution);
                return true;
            }
        }
        return false;
    }

     public static void queens(int n) {
         int [] board = new int[n];
         int queens = 0;
         for(int i = 0; i < n; i++){
             board[i] = i;
         }
         
         System.out.println(queens); 
     }
}
