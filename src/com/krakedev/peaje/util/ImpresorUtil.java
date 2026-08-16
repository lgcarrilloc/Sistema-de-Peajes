package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {
	
	public static void imprimirVehiculo(Vehiculo vehiculo) {
		System.out.println("====== INFORMACION DEL VEHICULO ======");
		System.out.println("Placa: " + vehiculo.getPlaca());
		System.out.println("Tipo" + vehiculo.getTipo());
		
		System.out.println("--- Datos del Tag ---");
		vehiculo.getTag().imprimir();
		
		System.out.println("Saldo disponible: "+ vehiculo.getTag().getSaldo());
	}

}
