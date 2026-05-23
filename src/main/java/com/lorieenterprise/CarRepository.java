/*
This interface is called CarRepository

This interface contains:
- JPA repository
- Database methods for CarEntity
 */

package com.lorieenterprise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}