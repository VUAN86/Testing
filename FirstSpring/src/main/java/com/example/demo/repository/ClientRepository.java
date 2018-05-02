package com.example.demo.repository;

import com.example.demo.obj.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author VUAN
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByYearintAndName(int yearint, String name);    
    Client findByAuto_id(Long auto_id); 
    List<Client> findByName(String name);
}
