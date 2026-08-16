package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;
import com.krakedev.peaje.util.ImpresorUtil;

public class TestVehiculo {

    public static void main(String[] args) {

        Conductor conductor1 = new Conductor("1722750195", "Luis Gustavo", "Carrillo Chavez");
        Vehiculo vehiculo1 = new Vehiculo("PBT-4586");
        TagElectronico tag1 = new TagElectronico("TAG-666");
        vehiculo1.setPropietario(conductor1);
        vehiculo1.setTag(tag1);

        System.out.println("===== IMPRIMIR VEHICULO =====");
        vehiculo1.imprimir();

        System.out.println("\n===== IMPRESOR UTIL =====");
        ImpresorUtil.imprimirVehiculo(vehiculo1);

        EstacionPeaje estacion = new EstacionPeaje();

        System.out.println("\n===== REGISTRAR VEHICULO =====");
        Vehiculo vehiculo2 = estacion.registrarVehiculo("TCB-378", "P", new Conductor("1713545232", "Bertha Rocio", "Chavez Toscano"), "TAG-459");

        System.out.println("\n===== RECARGAR TAG =====");
        estacion.recargarTag(vehiculo1, 35.0);

        System.out.println("\n===== COBRAR PEAJE =====");
        estacion.cobrarPeaje(vehiculo1);

        System.out.println("\n===== TRANSFERIR SALDO =====");
        estacion.transferirSaldoTag(
                vehiculo1,
                vehiculo2,
                12.0        );

        System.out.println("\n===== ESTADO FINAL =====");
        ImpresorUtil.imprimirVehiculo(vehiculo1);
        System.out.println();
        ImpresorUtil.imprimirVehiculo(vehiculo2);
    }
}
