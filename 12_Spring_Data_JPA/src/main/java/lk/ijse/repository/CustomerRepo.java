package lk.ijse.repository;

import lk.ijse.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository <customer,Integer>{
   /* @Override
    List<customer> findAllById(Iterable<Integer> integers);*/
}
