package com.org.navz.resository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.navz.entity.RestTable;



@Repository
@Qualifier(value = "restResponseRepository")
public interface RestResponseRepository extends JpaRepository<RestTable, Long>{

}