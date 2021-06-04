package com.t1908e.assignmentspring.repository;

import com.t1908e.assignmentspring.entity.District;
import com.t1908e.assignmentspring.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {
    @Query("select s from Street s where  s.name like %:name% and s.districtId = :district")
    List<Street> filterStreet(@Param(value = "name") String name, @Param(value = "district") int district);

}
