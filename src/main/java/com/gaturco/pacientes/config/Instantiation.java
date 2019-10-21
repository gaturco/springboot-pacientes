package com.gaturco.pacientes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gaturco.pacientes.domain.Paciente;
import com.gaturco.pacientes.repository.PacienteRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public void run(String... args) throws Exception {

		pacienteRepository.deleteAll();
		
		Paciente maria = new Paciente(null, "Maria Bronwn", "maria@gmail.com");
		Paciente alex = new Paciente(null, "Alex Green", "Alex@gmail.com");
		Paciente bob = new Paciente(null, "Bob Grey", "bob@gmail.com");
		
		pacienteRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
