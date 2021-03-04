package com.example.rest.repo;

import com.example.rest.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author
 * @create 2021 - 03 - 04 下午 01:31
 **/
@Repository
public interface ResourcesRepo extends JpaRepository<Resources, String> {

    Optional<Resources> findTopByFileName(String fileName);
}
