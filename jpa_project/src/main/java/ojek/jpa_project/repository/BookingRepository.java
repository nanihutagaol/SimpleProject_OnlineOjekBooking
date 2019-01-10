package ojek.jpa_project.repository;

import ojek.jpa_project.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findAllByMember_Id(String memberID);

    List<Booking> findAllByDriver_Id(String driverID);

    List<Booking> findAllByStatus(String status);

    void deleteById(String id);
}
