package com.appranix.demo.locations.repositories;

import com.appranix.demo.locations.domain.BuildInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildInfoJpaRepository extends JpaRepository<BuildInfo, String> {
}
