/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bosque
 */
public class MError {
    
    private static String mensaje;
    
    public static String getMensaje(int cod) {
        mensaje = "Error "+ cod + ": ";
        switch(cod) {
            case 101:
                mensaje = mensaje + "al cargar los drivers de la base de datos";
                break;
            case 102:
                mensaje = mensaje + "al abrir la base de datos";
                break;
            //Tomas: más casos
            case 103:
                mensaje = mensaje + "al cerrar la base de datos";
                break;
            //Tomas: más casos
            default:
                mensaje = mensaje + "DESCONOCIDO";
        }
        return mensaje;
    }
    
}
