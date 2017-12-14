package modelo;

import java.util.List;

public class Inscripcion {
	
	private int nFicha;
	private int valor;
	private List<Equipo> equipos;
	private List<Jugador> jugadores;

	public Inscripcion() {

	}

	public int getnFicha() {
		return nFicha;
	}

	public void setnFicha(int nFicha) {
		this.nFicha = nFicha;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	
}
