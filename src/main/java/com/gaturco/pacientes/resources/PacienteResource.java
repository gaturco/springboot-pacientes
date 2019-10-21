package com.gaturco.pacientes.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaturco.pacientes.domain.Paciente;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll() {
		Paciente maria = new Paciente("1", "Maria Brown", "maria@gmail.com");
		Paciente alex = new Paciente("2", "Alex Green", "alex@gmail.com");
		List<Paciente> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(list);
	}
}
