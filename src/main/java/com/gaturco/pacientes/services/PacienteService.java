package com.gaturco.pacientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaturco.pacientes.domain.Paciente;
import com.gaturco.pacientes.dto.PacienteDTO;
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
	
	public Paciente insert(Paciente paciente) {
		return repo.insert(paciente);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Paciente update(Paciente paciente) {
		Paciente newPaciente = findById(paciente.getId());
		updateData(newPaciente, paciente);
		return repo.save(newPaciente);
	}
	
	private void updateData(Paciente newPaciente, Paciente paciente) {
		newPaciente.setName(paciente.getName());
		newPaciente.setEmail(paciente.getEmail());
	}

	public Paciente fromDTO(PacienteDTO pacienteDTO) {
		return new Paciente(
			pacienteDTO.getId(),
			pacienteDTO.getName(),
			pacienteDTO.getEmail()
		);
	}
}
