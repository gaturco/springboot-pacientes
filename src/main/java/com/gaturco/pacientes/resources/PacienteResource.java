package com.gaturco.pacientes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PacienteDTO pacienteDTO) {
		Paciente paciente = service.fromDTO(pacienteDTO);
		paciente = service.insert(paciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody PacienteDTO pacienteDTO) {
		Paciente paciente = service.fromDTO(pacienteDTO);
		paciente.setId(id);
		paciente = service.update(paciente);
		return ResponseEntity.noContent().build();
	}
}	
