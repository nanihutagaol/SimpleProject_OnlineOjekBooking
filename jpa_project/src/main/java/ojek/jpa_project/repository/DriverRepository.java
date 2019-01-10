package ojek.jpa_project.repository;

import ojek.jpa_project.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, String> {
    Driver findByName(String name);

    void deleteById(String id);
}
