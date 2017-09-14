package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpApp {

	@Autowired
	MyRepo repo;

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String getMessage() {
		return "Hi from Spring REST";
	}

	@RequestMapping(path = "/find", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity findEmp(@RequestParam("id") int id) {
		Emp e = repo.findOne(id);
		return ResponseEntity.ok(e);
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST, produces = { MediaType.TEXT_PLAIN_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity saveEmp(@RequestBody Emp emp) {

		Emp e = repo.save(emp);
		return ResponseEntity.ok("Emp Saved");
	}

}
