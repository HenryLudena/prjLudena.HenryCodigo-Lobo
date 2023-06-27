package Utility;
import java.security.KeyStore.LoadStoreParameter;

import java.util.Scanner;
public class Datos {
    private static final int delay = 500;
    static  Scanner sc = new Scanner(System.in);
    /**
     * Método para escoger un personaje
     * @param mensaje
     */
    public int ingresoPersonajes (String mensaje, int lado, String[] primerLadoRío, String[] SegundoLadoRío){
        int personaje = 0, h = 0;
        boolean banderaP = true;
        do {
            try {
        System.out.print("Personajes Disponibles en este lado del río: ");
        if (lado%2==0) {
            ImpresiónPersonajesNoBote(primerLadoRío);
        } else {
            ImpresiónPersonajesNoBote(SegundoLadoRío);
        }
        System.out.println("\n"+ mensaje+"\n 0) Solo \n 1) Caperuza \n 2) Lobo \n 3) Uvas");
        personaje = Integer.parseInt(sc.nextLine());
        if ((personaje>=0)&&(personaje<=3)) 
            banderaP = false;
        else
        h = Integer.parseInt("hola");
        if (lado%2==0) {
            if (primerLadoRío[personaje].equals(" ")&&personaje!=0) {
                System.out.println("El personaje ingresado no se encuentra en este lado del río");
                banderaP=true;
            }
        } else {
            if (SegundoLadoRío[personaje].equals(" ")&&personaje!=0) {
                System.out.println("El personaje ingresado no se encuentra en este lado del río");
                banderaP=true;
            }
        }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor válido");
            }
        } while (banderaP==true);
        return personaje;
    }
    /**
     * Limpieza de la terminal
     */
    public static final void ClearTerminal(){
        try {
            String operatingSystem = System.getProperty("os.name");     
            if(operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * Método que realiza animación de bote moviéndose de ida y vuelta
     * @param personaje 
     * @param lado
     * @throws InterruptedException
     */
    public void AnimacionBote (int personaje, int lado, String[] primerLadoRío, String[] segundoLadoRío) throws InterruptedException{
        String[] personajeEscogido = {" ", "Caperuza", "Lobo", "Uvas"};
        int x = 0,z=5;
        for (int i = 0; i <= 5; i++) {
            ImpresiónPersonajesNoBote(primerLadoRío);
            if(lado%2==0){
            for(int j = 0; j<=x;j++){
                System.out.print("__");
            }
            System.out.print("\\_Observador_+_"+personajeEscogido[personaje]+"_/");
            x++;
            }else{
                for (int j = 0; j <=z; j++) {
                    System.out.print("__");
                }
                System.out.print("\\_Observador_+_"+personajeEscogido[personaje]+"_/");
            z--;
            }
            System.out.print("     ");
            ImpresiónPersonajesNoBote(segundoLadoRío);
            Thread.sleep(delay);
            ClearTerminal();
        }
    }
    public String LadoRío (int personaje, String primerLadoRío, String segundoLadoRío){
        if (segundoLadoRío.charAt(0)==' ') {
        segundoLadoRío=primerLadoRío;
        } else {
        segundoLadoRío=" ";
        }
        return segundoLadoRío;
    }
    public void ImpresiónPersonajesNoBote (String[] LadoRío){
        for (int i = 0; i < LadoRío.length; i++) 
            System.out.print(LadoRío[i]+" ");
    }
    public boolean verificacionNoComido(boolean bandera, String[] primerLadoRío, String Dato1, String Dato2, String mensaje, int posicion){
        for (int i = 0; i < primerLadoRío.length-1; i++) {
            if(primerLadoRío[i].equals(Dato1)&&primerLadoRío[posicion].equals(Dato2)&&primerLadoRío[0]==" "){
            System.out.println(mensaje);
            bandera = false;
            }
        }
        return bandera;
    }
    public boolean verifiacionJuegoGanado(boolean bandera, String[] segundoLadoRío, String[] Datos){
        int x=0,i=0;
        boolean banderaLocal = true;
        do {
            if (segundoLadoRío[i].equals(Datos[i])) {
                x = 0;
            } else {
                x = 1;
            }
            i++;
            if((x==1)||(i==4))
            banderaLocal=false;
        } while (banderaLocal==true);
        if(x==0){
        System.out.println("Felicidades Juego Ganado");
        bandera=false;
        }
        return bandera;
    }
    public String cambioPosiciónObservador(String LadoRío){
        if (LadoRío.charAt(0)==' ') {
            LadoRío="Observador";
        } else 
            LadoRío=" ";
        return LadoRío;
    }
}