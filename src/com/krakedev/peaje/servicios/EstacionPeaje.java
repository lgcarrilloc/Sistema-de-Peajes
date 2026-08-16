package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ValidadorUtil;

public class EstacionPeaje {

    private int codigoEstacion;
    private double tarifaLiviano;
    private double tarifaPesado;

    public EstacionPeaje() {
        this.codigoEstacion = 500;
        this.tarifaLiviano = 1.00;
        this.tarifaPesado = 2.50;
    }

    public int getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(int codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public double getTarifaLiviano() {
        return tarifaLiviano;
    }

    public void setTarifaLiviano(double tarifaLiviano) {
        this.tarifaLiviano = tarifaLiviano;
    }

    public double getTarifaPesado() {
        return tarifaPesado;
    }

    public void setTarifaPesado(double tarifaPesado) {
        this.tarifaPesado = tarifaPesado;
    }
    
    public Vehiculo registrarVehiculo(String placa, String tipo,
            Conductor conductor, String idTag) {
        if (!ValidadorUtil.esTipoValido(tipo)) {
            System.out.println("Tipo de vehiculo invalido. Debe ser L o P.");
            return null;
        }

        Vehiculo vehiculo = new Vehiculo(placa);
        vehiculo.setTipo(tipo);
        vehiculo.setPropietario(conductor);

        TagElectronico tag = new TagElectronico(idTag);
        vehiculo.setTag(tag);

        System.out.println("Vehiculo registrado correctamente.");

        return vehiculo;
    }
    
    public void recargarTag(Vehiculo vehiculo, double monto) {
    	
    	if (!ValidadorUtil.esMontoValido(monto)) {
    	System.out.println("Monto invalido. Debe ser mayor a cero.");
    	return;
    	}
    	
    	double nuevoSaldo = vehiculo.getTag().getSaldo() + monto;
    	vehiculo.getTag().setSaldo(nuevoSaldo);
    	System.out.println("Recarga realizada. Nuevo saldo: " + nuevoSaldo);
    }
    
    public void cobrarPeaje(Vehiculo vehiculo) {
    	double tarifa;
    	
    	if (vehiculo.getTipo().equals("L")) {
    	tarifa = tarifaLiviano;
    	} else {
    	tarifa = tarifaPesado;
    	}
    	
    	double saldoActual = vehiculo.getTag().getSaldo();
    	
    	if (saldoActual < tarifa) {
    	System.out.println("Saldo insuficiente para cobrar el peaje.");
    	return;
    	}
    	double nuevoSaldo = saldoActual - tarifa;
    	vehiculo.getTag().setSaldo(nuevoSaldo);
    	System.out.println("Peaje cobrado: " + tarifa + ". Saldo restante: " + nuevoSaldo);
   }
    
    public void transferirSaldoTag(Vehiculo origen, Vehiculo destino,
    		double monto) {
    		if (!ValidadorUtil.esMontoValido(monto)) {
    		System.out.println("Monto invalido. Debe ser mayor a cero.");
    		return;
    		}
    		
    		double saldoOrigen = origen.getTag().getSaldo();
    		if (saldoOrigen < monto) {
    		System.out.println("Saldo insuficiente en el vehiculo de origen.");
    		return;
    		}
    		
    		origen.getTag().setSaldo(saldoOrigen - monto);
    		destino.getTag().setSaldo(destino.getTag().getSaldo() + monto);
    		System.out.println("Transferencia realizada correctamente.");
    }
    
}