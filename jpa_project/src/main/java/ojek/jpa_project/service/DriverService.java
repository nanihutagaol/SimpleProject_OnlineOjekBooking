package ojek.jpa_project.service;

import ojek.jpa_project.model.Booking;
import ojek.jpa_project.model.Driver;

import java.util.List;

public interface DriverService {

    List<Driver> getAll();

    Driver getById(String id);

    Driver create(Driver driver);

    Driver update(String id, Driver driver);

    boolean delete(String id);
}
