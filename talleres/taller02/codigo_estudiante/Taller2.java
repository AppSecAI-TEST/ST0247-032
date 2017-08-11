/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.util.*;

/**
 *
 * @author ctezna2-Nicolas Gonzalez
 */
public class Taller2 {
//    public static void main(String[] args){
//        int[] v = {2,0,4,1,3};
//        esValido(v);
//        queens(8);
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
    public static boolean esValido(int[] tablero){
        int n = tablero.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 1; j < n; j++){
                if(Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) return false;
            }
        }
        return true;
    }

     public static int queens(int n) {
         String s = "";
         int queensCount = 0;
         for(int i = 0; i < n; i++){
             String x = Integer.toString(i);
             s += x;
         }
         ArrayList<String> list = permutations(s);
         String str = "";
         for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
            int [] board = new int[n];
            for(int j = 0; j < n; j++){
                board[j] = Integer.parseInt(str.valueOf(str.charAt(j)));
             }
             if (esValido(board)) {
                 queensCount++;
             }
         }
         //System.out.println(queensCount);
         return queensCount;
     }
}
