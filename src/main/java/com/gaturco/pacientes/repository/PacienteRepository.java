package com.gaturco.pacientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gaturco.pacientes.domain.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {
	
}
