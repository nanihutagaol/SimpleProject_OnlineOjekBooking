package ojek.jpa_project.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    private String id;

    @Column
    private String bookDate;

    @Column
    private String historyDate;

    @Column
    private int distance;

    @Column
    private double cost;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "book_driver_fkey"), name = "driverID", referencedColumnName = "id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "book_member_fkey"), name = "memberID", referencedColumnName = "id")
    private Member member;
}
