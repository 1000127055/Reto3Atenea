package Reto3Atenea.USA.com.Repository;

import Reto3Atenea.USA.com.Model.Client;
import Reto3Atenea.USA.com.Model.DTOs.TotalAndClient;
import Reto3Atenea.USA.com.Model.Reservation;
import Reto3Atenea.USA.com.Repository.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List <Reservation> findAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation (int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save (Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete (Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Object[]> getTotalReservationsByClient(){
        return reservationCrudRepository.getTotalReservationsByClient();
    }

}
