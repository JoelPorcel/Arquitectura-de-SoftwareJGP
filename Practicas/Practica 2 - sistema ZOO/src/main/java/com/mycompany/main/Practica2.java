/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author KUR0
 */
public class Practica2 {

    public static void main(String[] args) {
        Zoologico zoo = new Zoologico("Zoo Central", "Avenida Principal 123", "555-1234");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU DEL ZOOLOGICO ---");
            System.out.println("1. Aniadir mamifero (leon, oso, mono)");
            System.out.println("2. Aniadir ave (loro, aguila, condor)");
            System.out.println("3. Aniadir pez (pacu, sabalo)");
            System.out.println("4. Mostrar mamiferos");
            System.out.println("5. Mostrar aves");
            System.out.println("6. Mostrar peces");
            System.out.println("7. Mostrar informacion del zoologico");
            System.out.println("8. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer despues de nextInt() para que nextLine() funcione bien

            switch(opcion) {
                case 1:
                    System.out.print("Ingrese especie (leon, oso, mono): ");
                    String especieMamifero = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombreMamifero = scanner.nextLine();
                    
                    AnimalFactory fabricaMamiferos = new MamiferoFactory();
                    Animal nuevoMamifero = fabricaMamiferos.crearAnimal(especieMamifero, nombreMamifero);
                    
                    if (nuevoMamifero != null) {
                        Jaula jaula = new Jaula(nuevoMamifero, 3.0, 3.0, 3.0);
                        zoo.getListaJaulas().add(jaula);
                        System.out.println("Mamifero aniadido a su jaula exitosamente.");
                    } else {
                        System.out.println("Especie no valida.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese especie (loro, aguila, condor): ");
                    String especieAve = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombreAve = scanner.nextLine();
                    
                    AnimalFactory fabricaAves = new AveFactory();
                    Animal nuevaAve = fabricaAves.crearAnimal(especieAve, nombreAve);
                    
                    if (nuevaAve != null) {
                        Jaula jaula = new Jaula(nuevaAve, 2.0, 2.0, 2.0);
                        zoo.getListaJaulas().add(jaula);
                        System.out.println("Ave aniadida a su jaula exitosamente.");
                        
                        ((Ave) nuevaAve).volar(); 
                    } else {
                        System.out.println("Especie no válida.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese especie (pacu, sabalo): ");
                    String especiePez = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombrePez = scanner.nextLine();
                    
                    AnimalFactory fabricaPeces = new PezFactory();
                    Animal nuevoPez = fabricaPeces.crearAnimal(especiePez, nombrePez);
                    
                    if (nuevoPez != null) {
                        Jaula jaula = new Jaula(nuevoPez, 1.0, 4.0, 2.0);
                        zoo.getListaJaulas().add(jaula);
                        System.out.println("Pez aniadido a su pecera exitosamente.");
                        
                        ((Pez) nuevoPez).nadar();
                    } else {
                        System.out.println("Especie no valida.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Lista de Mamiferos ---");
                    for (Jaula jaula : zoo.getListaJaulas()) {
                        if (jaula.getAnimal() instanceof Mamifero) {
                            System.out.println(jaula.toString());
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- Lista de Aves ---");
                    for (Jaula jaula : zoo.getListaJaulas()) {
                        if (jaula.getAnimal() instanceof Ave) {
                            System.out.println(jaula.toString());
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n--- Lista de Peces ---");
                    for (Jaula jaula : zoo.getListaJaulas()) {
                        if (jaula.getAnimal() instanceof Pez) {
                            System.out.println(jaula.toString());
                        }
                    }
                    break;

                case 7:
                    System.out.println("\n--- Informacion General ---");
                    System.out.println(zoo.toString());
                    break;

                case 8:
                    System.out.println("Cerrando el sistema del zoologico...");
                    break;
                    
                default:
                    System.out.println("Opcion incorrecta. Intente de nuevo.");
            }
        } while (opcion != 8);

    }
}