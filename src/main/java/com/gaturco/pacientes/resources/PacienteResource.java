package com.gaturco.pacientes.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaturco.pacientes.domain.Paciente;
import com.gaturco.pacientes.dto.PacienteDTO;
import com.gaturco.pacientes.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDTO = list.stream().map(paciente -> new PacienteDTO(paciente)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PacienteDTO> findById(@PathVariable String id) {
		Paciente paciente = service.findById(id);
		return ResponseEntity.ok().body(new PacienteDTO(paciente));
	}
}
