package com.appranix.demo.locations.repositories;

import com.appranix.demo.locations.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsStateRepository extends JpaRepository<State, String> {
}
