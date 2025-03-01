package com.example.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen.model.admin;


@Repository
public interface admin_repository extends JpaRepository<admin, Long>{

}
