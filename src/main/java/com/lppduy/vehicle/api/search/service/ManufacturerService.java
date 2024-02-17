package com.lppduy.vehicle.api.search.service;

import com.lppduy.vehicle.api.search.entity.Manufacturer;
import com.lppduy.vehicle.api.search.exception.ManufacturerNotFoundException;

import java.util.List;

public interface ManufacturerService {

    Manufacturer saveManufacturer(Manufacturer manufacturer);
    List<Manufacturer> fetchAllManufacturers();
    Manufacturer getManufacturerForId(int id);
    Manufacturer updateManufacturer(int id, Manufacturer updatedManufacturer);
    void deleteManufacturerById(int id) throws ManufacturerNotFoundException;
}
