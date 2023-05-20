import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. Cree un programa que solicite al usuario que ingrese una cadena de texto y
        //luego cuente el número de veces que cada carácter aparece en la cadena.
        //Utilice un HashMap para almacenar los resultados y muestre el mapa al
        //usuario al final.

//        Map<Character, Integer> frecuencias = new HashMap<Character, Integer>();
//        String cadena;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Ingrese una cadena de texto: ");
//        cadena = sc.nextLine();
//        for(int i=0; i<cadena.length(); i++){
//            char caracter = cadena.charAt(i);
//            if(frecuencias.containsKey(caracter)){
//                frecuencias.put(caracter, frecuencias.get(caracter) + 1);
//            }else {
//                frecuencias.put(caracter, 1);
//            }
//        }
//        System.out.println("Frecuencia de caracteres: ");
//        for(Map.Entry<Character, Integer> entry : frecuencias.entrySet()){
//            char caracter = entry.getKey();
//            int frecuencia = entry.getValue();
//            System.out.println("'" + caracter + "': " + frecuencia);
//        }

        //2. Escriba un programa que genere una lista de números aleatorios, la ordene y
        //luego elimine los duplicados. Utilice un HashSet para almacenar los números
        //únicos y un ArrayList para la lista original

        List<Integer> numerosAleatorios = generarNumerosAleatorios(10, 1, 10);
        Collections.sort(numerosAleatorios);
        System.out.println(numerosAleatorios.toString());

        List<Integer> numerosSinDuplicados = eliminarDuplicados(numerosAleatorios);
        System.out.println(numerosSinDuplicados.toString());

        //3. Escriba un programa que solicite al usuario que ingrese una lista de nombres
        //de personas y sus edades, y luego ordene la lista por edad. Utilice un
        //TreeMap para almacenar los nombres y las edades.

//        String nombre;
//        int edad;
//        TreeMap<Integer, String> personas = new TreeMap<Integer, String>();
//        for(int i=0; i<5; i++){
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Ingrese el nombre: ");
//            nombre = sc.nextLine();
//            System.out.println("Ingrese la edad: ");
//            edad = sc.nextInt();
//            personas.put(edad, nombre);
//        }
//        for(Map.Entry<Integer, String> entry : personas.entrySet()){
//            System.out.println("El nombre es " + entry.getValue() + " y su edad es " + entry.getKey());
//        }

        //4. Escriba un programa que lea una lista de números enteros y luego calcule la
        //suma y el promedio. Utilice un ArrayList para almacenar los números y una
        //HashMap para calcular la frecuencia de cada número. (Averiguar cómo hacer
        //una suma de elementos de una lista con streams). Stream es un flujo de
        //datos que a través de métodos concatenados podemos filtrarlos, modificarlos
        //y realizar distintas operaciones que devuelvan un flujo totalmente diferente.

//        List<Integer> numeros = new ArrayList<Integer>();
//        numeros.add(50);
//        numeros.add(10);
//        numeros.add(35);
//        numeros.add(20);
//        numeros.add(55);
//        int suma = numeros.stream().mapToInt(Integer::intValue).sum();
//        System.out.println("La suma de los numeros es: " + suma);
//        double promedio = numeros.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
//        System.out.println("El promedio de los numeros es: " + promedio);

        //5. Escriba un programa que lea una lista de números enteros y luego ordene la
        //lista en orden ascendente y descendente. Utilice un TreeSet para almacenar
        //los números y mostrarlos en orden ascendente y descendente.

        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(18);
        numeros.add(5);
        numeros.add(10);
        numeros.add(17);
        numeros.add(3);
        numeros.add(31);
        Set<Integer> numerosOrdenadosAsc = new TreeSet<>(numeros);
        System.out.println("Numeros ordenados en orden ascendente: " + numerosOrdenadosAsc);

        Comparator<Integer> ordenDescendente = Comparator.reverseOrder();
        Set<Integer> numerosOrdenadosDesc = new TreeSet<>(ordenDescendente);
        numerosOrdenadosDesc.addAll(numeros);
        System.out.println("Numeros ordenados en orden descendente: " + numerosOrdenadosDesc);

    }

    public static List<Integer> generarNumerosAleatorios(int cantidad, int min, int max){
        List<Integer> numeros = new ArrayList<>();
        for(int i=0; i<cantidad; i++){
            int numero = (int) (Math.random()*max+min);
            numeros.add(numero);
        }
        return numeros;
    }

    public static List<Integer> eliminarDuplicados(List<Integer> numeros){
        return new ArrayList<>(new LinkedHashSet<>(numeros));
    }
}