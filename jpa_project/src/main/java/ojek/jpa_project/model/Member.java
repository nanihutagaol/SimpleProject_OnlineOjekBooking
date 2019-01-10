package ojek.jpa_project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private double balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Booking> bookingsList;
}
