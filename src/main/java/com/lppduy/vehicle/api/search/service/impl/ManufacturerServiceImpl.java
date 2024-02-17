package com.lppduy.vehicle.api.search.service.impl;

import com.lppduy.vehicle.api.search.dao.ManufacturerDAO;
import com.lppduy.vehicle.api.search.entity.Manufacturer;
import com.lppduy.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.lppduy.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    @Override
    public List<Manufacturer> fetchAllManufacturers() {
        List<Manufacturer> dbManufacturers = manufacturerDAO.findAll();
        return dbManufacturers;
    }

    @Override
    public Manufacturer getManufacturerForId(int id) {
        Optional<Manufacturer> dbManufacturer = manufacturerDAO.findById(id);
        if (dbManufacturer.isPresent()) {
            return dbManufacturer.get();
        }
        return null;
    }

    @Override
    public Manufacturer updateManufacturer(int id, Manufacturer updatedManufacturer) {
        Manufacturer dbManufacturer = getManufacturerForId(id);
        if (dbManufacturer != null) {
            if (Objects.nonNull(updatedManufacturer.getManufacturerName())
                    && !"".equalsIgnoreCase(updatedManufacturer.getManufacturerName())) {
                dbManufacturer.setManufacturerName(updatedManufacturer.getManufacturerName());
            }
            if (Objects.nonNull(updatedManufacturer.getCountryOfOrigin())
                    && !"".equalsIgnoreCase(updatedManufacturer.getCountryOfOrigin())) {
                dbManufacturer.setCountryOfOrigin(updatedManufacturer.getCountryOfOrigin());
            }
            return manufacturerDAO.save(dbManufacturer);
        }
        return dbManufacturer;
    }

    @Override
    public void deleteManufacturerById(int id) throws ManufacturerNotFoundException {
        Manufacturer manufacturer = getManufacturerForId(id);
        if (manufacturer == null) {
            throw new ManufacturerNotFoundException("Manufacturer NOT found for ID-"+id);
        }
        manufacturerDAO.deleteById(id);
    }
}
