/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.operacionesbanco;
import javafx.util.Pair;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author PIERO
 */
public class OperacionesBanco {

    public static void main(String[] args) {
        //Para la primera cuenta bancaria
        System.out.println("Cuenta bancaria 1");
        //Pedimos el Titular y el Saldo de la primera cuenta bancaria
        //Lo almacenamos en un Pair (titular, saldo)
        Pair<String, Double> datos = pedirDatosUsuario();
        //Instanciar la clase CCC y crear la clase CCC_1
        CCC CCC_1 = new CCC (datos.getKey(), datos.getValue());
 
        //Repetimos el mismo proceso para crear la CCC_2
        //Para la segunda cuenta bancaria
        System.out.println("Cuenta bancaria 2");
        datos = pedirDatosUsuario();
        CCC CCC_2 = new CCC (datos.getKey(), datos.getValue());
 
        //Hacemos una transferencia desde la CCC_1 a la CCC_2
        Double importe = pedirImporteUsuario();
        CCC.RealizarTransferenciaEntreCuentas(CCC_1, CCC_2, importe);
 
        //Mostramos los datos de las cuentas bancarias por consola
        System.out.println("Datos de la CCC 1");
        List<String> datosCuenta;
        datosCuenta = CCC_1.getDatosCuenta();
        System.out.println("   ->      Titular: " + datosCuenta.get(0));
        System.out.println("   -> Nº de cuenta: " + datosCuenta.get(1));
        System.out.println("   ->        Saldo: " + datosCuenta.get(2));
 
        System.out.println("\nDatos de la CCC 2");
        datosCuenta = CCC_2.getDatosCuenta();
        System.out.println("   ->      Titular: " + datosCuenta.get(0));
        System.out.println("   -> Nº de cuenta: " + datosCuenta.get(1));
        System.out.println("   ->        Saldo: " + datosCuenta.get(2));
    }
 
    //Solicita el titular de la cuenta y el saldo por consola al usuario
    //Almacena los datos en un Pair, donde la Key será el Titular y el Value el saldo
    public static Pair<String, Double> pedirDatosUsuario()
    {
        //Pedimos los datos al usuario por consola para la primera cuenta corriente
        System.out.print ("Introduzca el nombre del titular: ");
        Scanner entradaEscaner = new Scanner (System.in); //Creamos de un objeto Scanner
        String titular = entradaEscaner.nextLine (); //Invocamos un método sobre el objeto Scanner
        Double saldo = 0.0;
        System.out.print ("Introduzca el saldo inicial: ");
        //Comprueba que sólo se introduzcan números válidos (Double)
        while(!entradaEscaner.hasNextDouble())
        {
            System.out.print("No ha introducido un saldo correcto.\n" +
                    "Vuelva a intentarlo (sólo números y decimales): ");
            entradaEscaner.nextLine();
        }
        saldo = entradaEscaner.nextDouble();
        return new Pair<>(titular, saldo);
    }
 
    //Solicita el importe a transferir entre cuentas al usuario
    public static Double pedirImporteUsuario()
    {
        //Pedimos el importe al usuario por consola
        Scanner entradaEscaner = new Scanner (System.in); //Creamos de un objeto Scanner
        Double importe = 0.0;
        System.out.print ("\nIntroduzca el importe a transferir entre cuentas: ");
        //Comprueba que sólo se introduzcan números válidos (Double)
        while(!entradaEscaner.hasNextDouble())
        {
            System.out.print("No ha introducido un importe correcto.\n" +
                    "Vuelva a intentarlo (sólo números y decimales): ");
            entradaEscaner.nextLine();
        }
        importe = entradaEscaner.nextDouble();
        entradaEscaner.close();
        return importe;
    }
}

