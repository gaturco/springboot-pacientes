package com.gaturco.pacientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaturco.pacientes.domain.Paciente;
import com.gaturco.pacientes.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
