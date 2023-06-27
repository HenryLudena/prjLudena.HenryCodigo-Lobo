import Utility.Datos;
public class App {
    public static void main(String[] args) throws Exception {
        Datos imprimir = new Datos();
        System.out.println("\t - Nombre: Henry Ludeña \n \t - Grupo: GR2" );
        boolean bandera = true;
        String Mensaje1 = "Lobo se ha comido a Caperuza", Mensaje2 = "Caperuza se ha comido las Uvas", PrimerLadoRíoCambio = " ";
        String [] Datos = {"Observador", "Caperuza", "Lobo", "Uvas"};
        String[] PrimerLadoRío = {"Observador", "Caperuza", "Lobo", "Uvas"};
        String[] SegundoLadoRío = {" ", " ", " ", " "};
        int personaje = 0, lado = 0;
        do {
            personaje = imprimir.ingresoPersonajes("Elija un personaje para viajar: ", lado, PrimerLadoRío, SegundoLadoRío);
            if(personaje!=0){
            PrimerLadoRío[0] = imprimir.cambioPosiciónObservador(PrimerLadoRío[0]);
            SegundoLadoRío[0] = imprimir.cambioPosiciónObservador(SegundoLadoRío[0]);
            }
            PrimerLadoRíoCambio = PrimerLadoRío[personaje];
                PrimerLadoRío[personaje]=imprimir.LadoRío(personaje, SegundoLadoRío[personaje], PrimerLadoRío[personaje]);
                SegundoLadoRío[personaje]=imprimir.LadoRío(personaje, PrimerLadoRíoCambio, SegundoLadoRío[personaje]);
                PrimerLadoRíoCambio = PrimerLadoRío[personaje];
                imprimir.AnimacionBote(personaje, lado, PrimerLadoRío, SegundoLadoRío);
                bandera = imprimir.verifiacionJuegoGanado(bandera, SegundoLadoRío, Datos);
                if(bandera==true){
                bandera = imprimir.verificacionNoComido(bandera, PrimerLadoRío, Datos[1], Datos[2], Mensaje1,2);
                bandera = imprimir.verificacionNoComido(bandera, SegundoLadoRío, Datos[1], Datos[2], Mensaje1,2);
                bandera = imprimir.verificacionNoComido(bandera, PrimerLadoRío, Datos[1], Datos[3], Mensaje2,3);
                bandera = imprimir.verificacionNoComido(bandera, SegundoLadoRío, Datos[1], Datos[3], Mensaje2,3);
                }   
            lado++;
        } while (bandera == true);
    }
}