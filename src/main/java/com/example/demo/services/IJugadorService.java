package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Jugador;

public interface IJugadorService {
	
	public Jugador agregar(Jugador jugador);
	public void eliminar(int id);
	public Jugador modificar(Jugador jugador);
	public List<Jugador> listaJugadores();
	public Optional<Jugador> buscarId(int id);
	

}
