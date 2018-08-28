package com.org.navz.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.navz.entity.MainResponseTable;

@Repository
@Qualifier(value = "mainResponseTableRepository")
public interface MainResponseTableRepository extends JpaRepository<MainResponseTable, Long>{

}