package com.example.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen.model.Ord;
@Repository
public interface order_repository extends JpaRepository<Ord, Long>{

}
