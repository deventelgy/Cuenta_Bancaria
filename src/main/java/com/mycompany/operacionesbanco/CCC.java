package com.mycompany.operacionesbanco;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CCC {
    //Propiedades de la clase CCC
    private double saldoDeCuenta;
    private String nombreDelTitular;
    private long numeroDeCuenta;
 
    //Constructor de la clase CCC
    public CCC (String nombreDelTitular, double saldoDeCuenta)
    {
        this.saldoDeCuenta = saldoDeCuenta;
        this.nombreDelTitular = nombreDelTitular;
        Random numAleatorioCuenta = new Random();
        this.numeroDeCuenta = Math.abs(numAleatorioCuenta.nextLong());
    }
 
    //Setters
 
    //Setter para aumentar el saldo de la cuenta bancaria (hacer un ingreso)
    public void setIngreso (double ingreso)
    {
        if (ingreso <= 0)
            System.out.println("El ingreso debe ser superior a cero euros");
        else
            saldoDeCuenta = saldoDeCuenta + ingreso;
    }
 
    //Setter para disminuir  el saldo de la cuenta bancaria (sacar dinero)
    public void setReintegro (double reintegro)
    {
        if (reintegro <= 0)
            System.out.println("El reintegro debe ser superior a cero euros");
        else
            saldoDeCuenta = saldoDeCuenta - reintegro;
    }
 
    //Getters
    
    //Getter que devuelve el saldo actual de la cuenta bancaria
    public Double getSaldoCuenta ()
    {
        return saldoDeCuenta;
    }
 
    //Getter que obtiene todos los datos de la cuenta bancaria en un List
    //Se puede usar cualquier otra opción para devolver los datos
    public List<String> getDatosCuenta ()
    {
        List<String> datosCuenta = new ArrayList<>();
        datosCuenta.add(nombreDelTitular);
        datosCuenta.add(Long.toString(numeroDeCuenta));
        //Redondeamos a dos decimales el saldo
        DecimalFormat saldoRedondeado = new DecimalFormat("###.##");
        datosCuenta.add(saldoRedondeado.format(saldoDeCuenta));
 
        return datosCuenta;
    }
 
    //Métodos
 
    //Método que incrementa el saldo de una CCC de destino y lo decrementa en la CCC origen
    //Para realizar una transferencia de una CCC a otra
    public static void RealizarTransferenciaEntreCuentas (CCC ccc1, CCC ccc2, double importeTransferencia)
    {
        ccc1.saldoDeCuenta = ccc1.saldoDeCuenta - importeTransferencia;
        ccc2.saldoDeCuenta = ccc2.saldoDeCuenta + importeTransferencia;
    }
}
