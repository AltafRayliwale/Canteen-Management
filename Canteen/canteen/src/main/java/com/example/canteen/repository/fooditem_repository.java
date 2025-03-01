package com.example.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen.model.fooditem;

@Repository
public interface fooditem_repository extends JpaRepository<fooditem, Long>{

}
