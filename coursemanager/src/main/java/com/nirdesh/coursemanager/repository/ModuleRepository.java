package com.nirdesh.coursemanager.repository;

import com.nirdesh.coursemanager.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModuleRepository extends JpaRepository<Module,Long> {

    boolean existsByModuleCode(String moduleCode);

    Optional<Module> findByModuleCode(String moduleCode);
}
