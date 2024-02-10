package com.lppduy.vehicle.api.search.service.impl;

import com.lppduy.vehicle.api.search.dao.ManufacturerDAO;
import com.lppduy.vehicle.api.search.entity.Manufacturer;
import com.lppduy.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
