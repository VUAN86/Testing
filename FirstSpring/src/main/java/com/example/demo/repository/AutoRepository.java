package com.example.demo.repository;

import com.example.demo.obj.Auto;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author VUAN
 */
public interface AutoRepository extends CrudRepository<Auto, Long> {
    Auto findByYearintAndModel(int yearint, String model);
}
