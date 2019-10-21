package com.gaturco.pacientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaturco.pacientes.domain.Paciente;
import com.gaturco.pacientes.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;

	public List<Paciente> findAll() {
		return repo.findAll();
	}
}
