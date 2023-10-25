package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Jugador;
import com.example.demo.services.implementation.JugadorService;


@Controller
public class JugadorController {
	
	@Autowired
	private JugadorService jugadorService;
	
	@GetMapping("/")
	public ResponseEntity<List<Jugador>> listar(){
		return new ResponseEntity(jugadorService.listaJugadores(), HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Jugador> agregar(@RequestBody Jugador jugador){
		return new ResponseEntity<Jugador>(jugadorService.agregar(jugador), HttpStatus.CREATED );
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(name="id")int id){
		jugadorService.eliminar(id);
		return new ResponseEntity<String>("el jugador se elimino",HttpStatus.OK);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> modificar(@RequestBody Jugador jugador, @PathVariable(name="id")int id){
		
		Optional<Jugador> buscado=jugadorService.buscarId(id);
		if(buscado.isEmpty()==false) {
			jugador.setId(id);
			return new ResponseEntity<Jugador>(jugadorService.modificar(jugador),HttpStatus.OK);
		}
		else return new ResponseEntity<String>("el id no existe",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Jugador> buscarId(@PathVariable(name="id")int id){
		return new ResponseEntity<Jugador>(jugadorService.buscarId(id).get(),HttpStatus.OK);
		
	}

}
