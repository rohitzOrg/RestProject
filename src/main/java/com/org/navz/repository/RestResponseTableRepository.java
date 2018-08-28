package com.org.navz.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.navz.entity.RestResponseTable;

@Repository
@Qualifier(value = "restResponseTableRepository")
public interface RestResponseTableRepository extends JpaRepository<RestResponseTable, Long>{
// for RestResponseTable
}