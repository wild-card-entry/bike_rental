package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Integer> {
Location findLocationByAddress(String name);
}
