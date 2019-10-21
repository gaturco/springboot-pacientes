package com.gaturco.pacientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaturco.pacientes.domain.Paciente;
import com.gaturco.pacientes.repository.PacienteRepository;
import com.gaturco.pacientes.services.exception.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;

	public List<Paciente> findAll() {
		return repo.findAll();
	}
	
	public Paciente findById(String id) {
		Optional<Paciente> paciente = repo.findById(id);
		return paciente.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado"));
	}
}
