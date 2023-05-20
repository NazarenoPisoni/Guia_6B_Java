package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABM {
    private Map<String, Persona> personas = new HashMap<>();

    public void alta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el DNI: ");
        String dni = sc.nextLine();
        System.out.println("Ingrese la Edad: ");
        int edad = sc.nextInt();
        Persona p = new Persona(nombre, dni, edad);
        if(!(personas.containsKey(p.getDni()))){
            personas.put(p.getDni(), p);
        }else System.out.println("ERROR. La persona ya se encuentra agregada en la base. ");

    }
    public void baja(String dni){
        if(personas.containsKey(dni)){
            personas.remove(dni);
        }else System.out.println("ERROR. El DNI ingresado no existe en la base de datos.");

    }
    public void modificar(String dni){
        if(personas.containsKey(dni)){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el Nombre: ");
            personas.get(dni).setNombre(sc.nextLine());
            System.out.println("Ingrese el DNI: ");
            personas.get(dni).setDni(sc.nextLine());
            System.out.println("Ingrese la edad: ");
            personas.get(dni).setEdad(sc.nextInt());
        }
    }

    public void agregarPersona(Persona p){
        if(personas.containsKey(p.getDni())){
            personas.put(p.getDni(), p);
        }else System.out.println("ERROR. La persona ya se encuentra agregada en la base. ");
    }
}
