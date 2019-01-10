package ojek.jpa_project.service.impl;

import ojek.jpa_project.exception.ResourceNotFoundException;
import ojek.jpa_project.model.Booking;
import ojek.jpa_project.model.Driver;
import ojek.jpa_project.model.Member;
import ojek.jpa_project.model.Status;
import ojek.jpa_project.repository.BookingRepository;
import ojek.jpa_project.repository.DriverRepository;
import ojek.jpa_project.repository.MemberRepository;
import ojek.jpa_project.service.BookingService;
import ojek.jpa_project.service.DriverService;
import ojek.jpa_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DriverRepository driverRepository;

    public List<Booking> getAllBooking(){
        List<Booking> bookings = bookingRepository.findAll();

        if (bookings.isEmpty()){
            throw new ResourceNotFoundException("Data is empty");
        }

        return bookings;
    }

    public List<Booking> getAllBooking_byMember(String memberID){
        List<Booking> bookings = bookingRepository.findAllByMember_Id(memberID);

        if (bookings.isEmpty()){
            throw new ResourceNotFoundException("Data is empty");
        }

        return bookings;
    }

    public List<Booking> getAllBooking_byDriver(String driverID){
        List<Booking> bookings = bookingRepository.findAllByDriver_Id(driverID);

        if (bookings.isEmpty()){
            throw new ResourceNotFoundException("Data is empty");
        }

        return bookings;
    }

    public List<Booking> getAllBooking_hasPaid(){
        List<Booking> bookings = bookingRepository.findAllByStatus(Status.Finished.toString());

        if (bookings.isEmpty()){
            throw new ResourceNotFoundException("Data is empty");
        }

        return bookings;
    }

    public Booking getById(String id){
        Booking booking = bookingRepository.findOne(id);

        if (booking == null){
            throw new ResourceNotFoundException("Data not found");
        }

        return booking;
    }

    @Transactional
    public Booking create(String memberID, Booking booking){
        Member member = memberRepository.findOne(memberID);
        Driver driver = driverRepository.findOne(booking.getDriver().getId());

        booking.setMember(member);
        booking.setDriver(driver);
        booking.setBookDate(getDate());
        booking.setHistoryDate(getDate());
        booking.setCost(booking.getDistance()*2000);
        booking.setStatus(Status.Requested.toString());

        member.setBalance(member.getBalance() - booking.getDistance()*2000);
        memberRepository.save(member);

        return bookingRepository.save(booking);
    }

    public Booking cancel(String id){
        Booking booking = bookingRepository.findOne(id);
        Member member = memberRepository.findOne(booking.getMember().getId());

        if (booking == null){
            throw new ResourceNotFoundException("Data not found");
        }

        booking.setHistoryDate(getDate());
        booking.setStatus(Status.Canceled.toString());

        member.setBalance(member.getBalance() + booking.getCost());
        memberRepository.save(member);

        return bookingRepository.save(booking);
    }

    public Booking finish(String id){
        Booking booking = bookingRepository.findOne(id);

        if (booking == null){
            throw new ResourceNotFoundException("Data not found");
        }

        booking.setHistoryDate(getDate());
        booking.setStatus(Status.Finished.toString());

        return bookingRepository.save(booking);
    }

    static String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String dateTimeNow = dtf.format(now);

        return dateTimeNow;
    }

}
