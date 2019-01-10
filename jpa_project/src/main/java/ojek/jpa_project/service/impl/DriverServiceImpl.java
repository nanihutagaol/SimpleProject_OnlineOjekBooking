package ojek.jpa_project.service.impl;

import ojek.jpa_project.exception.ResourceNotFoundException;
import ojek.jpa_project.model.Driver;
import ojek.jpa_project.repository.DriverRepository;
import ojek.jpa_project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;


    public List<Driver> getAll(){
        List<Driver> drivers = driverRepository.findAll();

        if (drivers.isEmpty()){
            throw new ResourceNotFoundException("Data is empty");
        }

        return drivers;
    }

    public Driver getById(String id){
        Driver driver = driverRepository.findOne(id);

        if (driver == null){
            throw new ResourceNotFoundException("Data not found");
        }

        return driver;
    }

    public Driver create(Driver newDriver){
        Driver driver = driverRepository.findByName(newDriver.getName());

        if(driver != null){
            throw new ResourceNotFoundException("Data exist");
        }

        return driverRepository.save(driver);
    }

    public Driver update(String id, Driver updDriver){
        Driver driver = driverRepository.findOne(id);

        if (driver == null){
            throw new ResourceNotFoundException("Data not found");
        }

        driver.setName(updDriver.getName());
        driver.setBalance(updDriver.getBalance());

        return driverRepository.save(driver);
    }

    public boolean delete(String id){
        Driver driver = driverRepository.findOne(id);

        if (driver == null){
            throw new ResourceNotFoundException("Data not found");
        }

        driverRepository.deleteById(id);
        return true;
    }
}
