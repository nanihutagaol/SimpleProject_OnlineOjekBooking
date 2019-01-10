package ojek.jpa_project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private List<Booking> bookingsList;
}
