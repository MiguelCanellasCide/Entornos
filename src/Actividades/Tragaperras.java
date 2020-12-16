package Actividades;

import java.util.ArrayList;
import java.util.Scanner;

public class Tragaperras {

    //Atributos

    Scanner sc = new Scanner(System.in);
    int numeroJugador;
    private int numeroAleatorio;
    private int intentos = 5;
    ArrayList <Integer> numerosIntroducidos = new ArrayList<>();
    private int saldoMaquina = 20;
    private int saldoUsuario;
    int premio = 5;

    //Constructor

    public Tragaperras() {

    }

    //Getters/Setters


    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public ArrayList<Integer> getNumerosIntroducidos() {
        return numerosIntroducidos;
    }

    public void setNumerosIntroducidos(ArrayList<Integer> numerosIntroducidos) {
        this.numerosIntroducidos = numerosIntroducidos;
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public int getSaldoMaquina() {
        return saldoMaquina;
    }

    public void setSaldoMaquina(int saldoMaquina) {
        this.saldoMaquina = saldoMaquina;
    }

    public int getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(int saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }

    // Otros métodos

    public int generarNumAleatorio() {

        numeroAleatorio = (int) ((Math.random() * 100) + 1);

        return numeroAleatorio;
    }

    public void menu() {

        Scanner sc = new Scanner(System.in);

        int opcion;

        boolean salir = false;

        System.out.println("Adivina el número entre 1 y 100. Tiene 5 intentos.\n" +
                "Para comenzar, introduzca 1€. Por cada intento extra pague 1€ más.\n" +
                "El premio por adivinar el número es de 5€.");

        while (!salir) {
            System.out.println("Escoge una opción.\n" +
                    "Opción 1: Emepzar a jugar.\n" +
                    "Opción 2: Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {

                    System.out.println("Adivina el número entre 1 y 100." + "Tienes " + intentos + " intentos");

                    try {

                        acertarNumero();

                    } catch (Exception e) {

                        System.out.println("Error. El número introducido no esta dentro del rango.\n" +
                                "Por favor, introduzca otro número");

                    }
                }

                case 2 -> {

                    System.out.println("Adios. Vuelva otro día.");

                    salir = true;

                }

            }

        }

    }

    private void acertarNumero() throws Exception {

        generarNumAleatorio();

        boolean exit = false;

        System.out.println("Por favor introduzca el dinero que tiene para gastar.");

        saldoUsuario = sc.nextInt();

        while (!exit) {

            while (!(numeroJugador == numeroAleatorio) && !(intentos == 0)) {

                System.out.println("Introduzca un número.");

                numeroJugador = sc.nextInt();

                if (numeroJugador >= 1 && numeroJugador <= 100) {

                    if (numeroJugador == numeroAleatorio) {

                        System.out.println("El número es correcto!! Enhorabuana!!!");

                    } else {

                        numerosIntroducidos.add(numeroJugador);

                        System.out.println("El número no es correcto, prueba con otro.");

                        intentos--;

                        System.out.println("Te quedan " + intentos + " intentos.");

                        if (numeroJugador < numeroAleatorio) {

                            System.out.println("El número a adivinar es mayor que " + numeroJugador + ". Prueba de nuevo.");

                        } else if (numeroJugador > numeroAleatorio) {

                            System.out.println("El número a adivinar es menor que " + numeroJugador + ". Prueba de nuevo.");

                        }

                    }

                } else {

                    throw new Exception("El número introducido no es válido. Por favor introduzca un número entre el 1 y el 100.");

                }



            }

            if (numeroJugador == numeroAleatorio) {

                System.out.println("Enhorabuana!!! Has ganado un premio de " + premio + "€.");

                saldoMaquina = saldoMaquina - premio;
                saldoUsuario = saldoUsuario + premio;
                exit = true;

            } else if (intentos == 0) {

                String reintento;

                System.out.println("Te has quedado sin intentos. Intentalo de nuevo por 1€ más.");

                System.out.print("S/N...");

                reintento = sc.next();

                if (reintento.equals("S")) {

                    saldoUsuario--;
                    saldoMaquina++;
                    intentos++;

                } else if (reintento.equals("N")) {

                    System.out.println("El número a adivinar era " + numeroAleatorio + ".");

                    System.out.println("Los números que has introducido son: ");

                    System.out.println(numerosIntroducidos + "\t");

                    exit = true;

                }

            }

        }
    }
}








