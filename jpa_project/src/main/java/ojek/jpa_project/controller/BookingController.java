package ojek.jpa_project.controller;

import ojek.jpa_project.model.Booking;
import ojek.jpa_project.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/booking")
    List<Booking> getAll(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/booking/member/{id}")
    List<Booking> getAll_byMember(@PathVariable String id){
        return bookingService.getAllBooking_byMember(id);
    }

    @GetMapping("/booking/driver/{id}")
    List<Booking> getAll_byDriver(@PathVariable String id){
        return bookingService.getAllBooking_byDriver(id);
    }

    @GetMapping("/booking/{id}/paid")
    List<Booking> getAll_hasPaid(){
        return bookingService.getAllBooking_hasPaid();
    }

    @GetMapping("/booking/{id}")
    Booking getById(@PathVariable String id){
        return bookingService.getById(id);
    }

    @PostMapping("/booking/{memberID}")
    Booking create(@PathVariable String memberID, @Valid @RequestBody Booking booking){
        return bookingService.create(memberID, booking);
    }

}
