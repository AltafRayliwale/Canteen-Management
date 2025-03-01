package com.example.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen.model.user;

@Repository
public interface user_repository extends JpaRepository<user, Long> {

}
