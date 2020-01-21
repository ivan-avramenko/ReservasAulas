package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Reservas {

	private List<Reserva> coleccionReservas;
	
	public Reservas() {
		coleccionReservas = new ArrayList<>();
	}
	
	public List<Reserva> get() {
		return copiaProfundaReservas();
	}
	
	private List<Reserva> copiaProfundaReservas() {
		List<Reserva> copiaReservas = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			copiaReservas.add(new Reserva(reserva));
		}
		return copiaReservas;
	}
	
	public List<Reserva> get(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: El profesor no puede ser nulo.");
		}
		List<Reserva> reservasProfesor = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			if (reserva.getProfesor().equals(profesor)) {
				reservasProfesor.add(new Reserva(reserva));
			}
		}
		return reservasProfesor;
	}
	
	public List<Reserva> get(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: El aula no puede ser nula.");
		}
		List<Reserva> reservasAula = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			if (reserva.getAula().equals(aula)) {
				reservasAula.add(new Reserva(reserva));
			}
		}
		return reservasAula;
	}
	
	public int getTamano() {
		return coleccionReservas.size();
	}
	
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
		}
		int indice = coleccionReservas.indexOf(reserva);
		if (indice == -1) {
			coleccionReservas.add(new Reserva(reserva));
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe una reserva igual.");
		}		
		
	}
	
	public Reserva buscar(Reserva reserva) {
		if (reserva == null) {
			throw new IllegalArgumentException("ERROR: No se puede buscar una reserva nula.");
		}
		int indice = coleccionReservas.indexOf(reserva);
		if (indice == -1) {
			return null;
		} else {
			return new Reserva(coleccionReservas.get(indice));
		}
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar una reserva nula.");
		}
		int indice = coleccionReservas.indexOf(reserva);
		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ninguna reserva igual.");
		} else {
			coleccionReservas.remove(indice);
		}
	}

}
