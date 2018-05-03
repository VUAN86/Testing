package com.example.demo;

import com.example.demo.obj.Answer;
import com.example.demo.obj.Auto;
import com.example.demo.obj.Client;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author VUAN
 */
@RestController
@RequestMapping("/autoshop")
@Api(value = "autoshop", description = "Requests to work with autoshop")
public class RESTcontroller {

    @Autowired
    AutoRepository autorepository;

    @Autowired
    ClientRepository clientrepository;

    @ApiOperation(value = "Getting car list", response = Auto.class)
    @RequestMapping(value = "/getCars", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getCars() {
        List cars = new LinkedList();
        for (Auto car : autorepository.findAll()) {
            cars.add(car);
        }
        return new ResponseEntity(cars, HttpStatus.OK);
    }

    @ApiOperation(value = "Getting client list", response = Client.class)
    @RequestMapping(value = "/getClients", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getClients() {
        List clients = new LinkedList();
        for (Client client : clientrepository.findAll()) {
            clients.add(client);
        }
        return new ResponseEntity(clients, HttpStatus.OK);
    }

    @ApiOperation(value = "Adding client", response = String.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity AddClient(@RequestParam(value = "clientname") String clientname, @RequestParam(value = "clientyear") int clientyear, @RequestParam(value = "autoname") String autoname, @RequestParam(value = "autoyear") int autoyear) {
        try {
            Auto auto = autorepository.findByYearintAndModel(autoyear, autoname);
            if (auto != null) {
                Client oldClient = clientrepository.findByAuto_id(auto.getId());
                if (oldClient == null) {
                    Client client = clientrepository.findByYearintAndName(clientyear, clientname);
                    if (client == null) {
                        clientrepository.save(new Client(clientname, clientyear, auto));
                    } else {
                        return new ResponseEntity(new Answer("Client " + clientname + " already have car " + client.getAuto().getModel() + "!"), HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity(new Answer("Car " + autoname + " is not free!"), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity(new Answer("We dont have this car " + autoname + "!"), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(new Answer("Client " + clientname + " added!"), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Remove client", response = String.class)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity DelClient(@RequestParam(value = "clientname") String clientname, @RequestParam(value = "autoname") String autoname) {
            Client corectClient = null;
            List<Client> list = clientrepository.findByName(clientname);
                for (Client client : list) {
                    if (client.getAuto().getModel().equals(autoname)) {
                        corectClient = client;
                    }
                }
            if (corectClient != null) {
                clientrepository.delete(corectClient);
            } else {
                return new ResponseEntity(new Answer("No clien " + clientname + " with that car "+autoname+"!"), HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity(new Answer("Client " + clientname + " deleted!"), HttpStatus.OK);
    }
}
