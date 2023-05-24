package models;

import java.util.*;

public class ABM {

    public static Map<String, Persona> alta(Map<String, Persona> personas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el DNI: ");
        String dni = sc.nextLine();
        System.out.println("Ingrese la Edad: ");
        int edad = sc.nextInt();
        Persona p = new Persona(nombre, dni, edad);
        if (!(personas.containsKey(p.getDni()))) {
            personas.put(p.getDni(), p);
        }
        return personas;
    }

    public static Map<String, Persona> baja(Map<String, Persona> personas, String dni) {
        if (personas.containsKey(dni)) {
            personas.remove(dni);
        }
        return personas;
    }

    public static Map<String, Persona> modificar(Map<String, Persona> personas, String dni) {
        if (personas.containsKey(dni)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el Nombre: ");
            personas.get(dni).setNombre(sc.nextLine());
            System.out.println("Ingrese el DNI: ");
            personas.get(dni).setDni(sc.nextLine());
            System.out.println("Ingrese la edad: ");
            personas.get(dni).setEdad(sc.nextInt());
        }
        return personas;
    }

    public static Map<String, Persona> agregarPersona(Map<String, Persona> personas, Persona p) {
        if (!personas.containsKey(p.getDni())) {
            personas.put(p.getDni(), p);
        }
        return personas;
    }

    public static Map<String, Persona> agregarListaPersonas(Map<String, Persona> personas, List<Persona> lista) {
        for (Persona p : lista) {
            if (!personas.containsKey(p.getDni())) {
                personas.put(p.getDni(), p);
            }
        }
        return personas;
    }

    public static Map<String, Persona> ordenarPorEdad(Map<String, Persona> personas) {
        Map<String, Persona> personasOrdenadas = new TreeMap<>(new ComparadorEdad(personas));

        // Agregar todas las personas del Map original al TreeMap
        personasOrdenadas.putAll(personas);

        return personasOrdenadas;
    }

    static class ComparadorEdad implements Comparator<String> {
        private Map<String, Persona> personas;

        public ComparadorEdad(Map<String, Persona> personas) {
            this.personas = personas;
        }

        @Override
        public int compare(String dni1, String dni2) {
            int edad1 = personas.get(dni1).getEdad();
            int edad2 = personas.get(dni2).getEdad();

            // Comparar por edad de forma descendente
            return Integer.compare(edad1, edad2);
        }
    }
}
