import java.util.Random;
import java.util.Scanner;

public class juego {
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    int numero = 0;
    int option = 0;

    public juego(){
        System.out.println("\tJuego de adivinar número");
        System.out.println("Ingrese dificultad deseada\n[1] Fácil\n[2] Dificil");
        option = sc.nextInt();

        if (option == 1){
            generador(1);
        }else if (option == 2){
            generador(2);
        }else{
            System.out.println("Opcion no valida");
        }
    }

    public int generador (int dificultad){
        
        switch(dificultad){
            case 1:
                numero = (rd.nextInt(10));
                break;
            case 2:
                numero = (rd.nextInt(100));
                break;
        }
        return numero;
    }

    public void pista(int dif, int num){

        if (dif == 1){        
            System.out.println("El numero está entre: "+(num-3)+" y "+(num+3));
        }else if (dif == 2){
            System.out.println("El numero está entre: "+(num-10)+" y "+(num+10));
        }
    }
    
    public String intentos(){
        int entrada = 0;
        int i = 0;
        String texto = "";

        for (i = 0; i < 3 && entrada != numero; i++){
            System.out.println("Ingrese un numero: ");
            entrada = sc.nextInt();
            if (entrada == numero) {
                System.out.print("\033[H\033[2J");
                texto = "¡Has adivinado el número!";
                break;
            } else if (i < 2){
                System.out.print("\033[H\033[2J");
                System.out.println("Intento fallido, intenta de nuevo.");
                System.out.println("¿Quieres una pista?\nSí/No");
                String opcion = sc.next();
                switch (opcion.toUpperCase()) {
                    case "SI":
                    case "SÍ":
                    case "S":
                        pista(option, numero); // Cambiado aquí
                        break;
                }
            } else {
                System.out.println("El numero era: "+numero);
                return (texto);
            }
        }
        
        System.out.println("El numero era: "+numero);
        return (texto);
    }

}