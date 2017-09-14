package com.demo.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends CrudRepository<Emp, Integer> {

}
