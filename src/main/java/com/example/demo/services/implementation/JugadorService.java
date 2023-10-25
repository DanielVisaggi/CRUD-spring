package com.example.demo.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Jugador;
import com.example.demo.repositories.IJugadorRepository;
import com.example.demo.services.IJugadorService;

@Service
public class JugadorService implements IJugadorService {
	
	@Autowired
	private IJugadorRepository JugadorRepository;

	@Override
	public Jugador agregar(Jugador jugador) {
		return JugadorRepository.save(jugador);
	}

	@Override
	public void eliminar(int id) {
		Optional<Jugador> jugador= JugadorRepository.findById(id);
		if(jugador.isEmpty()==false) JugadorRepository.delete(jugador.get());
	}

	@Override
	public Jugador modificar(Jugador jugador) {
		return JugadorRepository.save(jugador);
	}

	@Override
	public List<Jugador> listaJugadores() {
		return JugadorRepository.findAll();
	}

	@Override
	public Optional<Jugador> buscarId(int id) {
		return JugadorRepository.findById(id);
	}

}
