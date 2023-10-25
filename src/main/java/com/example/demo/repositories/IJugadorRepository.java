package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import com.example.demo.entities.Jugador;

@Repository
public interface IJugadorRepository extends JpaRepository<Jugador,Serializable> {


}
