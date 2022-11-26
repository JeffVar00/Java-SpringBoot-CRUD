/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cr.ac.una.Proyecto1Paradigmas.api;

import cr.ac.una.Proyecto1Paradigmas.entity.Alquiler;
import cr.ac.una.Proyecto1Paradigmas.entity.Log;
import cr.ac.una.Proyecto1Paradigmas.repository.LogRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author M4N0
 */
@RestController
@RequestMapping(path = "/Log")
public class LogRest {
	@Autowired
	private LogRepository logRepository;

	@GetMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<Log>> findAll() {
		List<Log> list = new ArrayList<Log>();
		logRepository.findAll().forEach(e -> list.add(e));
		return ResponseEntity.ok(list);
	}
}
