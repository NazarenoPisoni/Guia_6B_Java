import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //1. Cree un programa que solicite al usuario que ingrese una cadena de texto y
        //luego cuente el número de veces que cada carácter aparece en la cadena.
        //Utilice un HashMap para almacenar los resultados y muestre el mapa al
        //usuario al final.

        Map<Character, Integer> frecuencias = new HashMap<Character, Integer>();
        String cadena;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto: ");
        cadena = sc.nextLine();
        for(int i=0; i<cadena.length(); i++){
            char caracter = cadena.charAt(i);
            if(frecuencias.containsKey(caracter)){
                frecuencias.put(caracter, frecuencias.get(caracter) + 1);
            }else {
                frecuencias.put(caracter, 1);
            }
        }
        System.out.println("Frecuencia de caracteres: ");
        for(Map.Entry<Character, Integer> entry : frecuencias.entrySet()){
            char caracter = entry.getKey();
            int frecuencia = entry.getValue();
            System.out.println("'" + caracter + "': " + frecuencia);
        }
        
    }
}