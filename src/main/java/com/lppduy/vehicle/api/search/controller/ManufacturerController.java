package com.lppduy.vehicle.api.search.controller;

import com.lppduy.vehicle.api.search.entity.Manufacturer;
import com.lppduy.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.lppduy.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<Manufacturer> craeteManufacturerInDB(@RequestBody Manufacturer manufacturer) {
        Manufacturer dbRecord = manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(dbRecord, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturers() {
        List<Manufacturer> savedManufacturers = manufacturerService.fetchAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(savedManufacturers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturerBasedOnId(@PathVariable int id) throws ManufacturerNotFoundException {
        Manufacturer dbManufacturer = manufacturerService.getManufacturerForId(id);
        if (dbManufacturer == null) {
            throw new ManufacturerNotFoundException("No manufacturer found for ID-"+id);
        }
        return ResponseEntity.ok(dbManufacturer);
    }
}
