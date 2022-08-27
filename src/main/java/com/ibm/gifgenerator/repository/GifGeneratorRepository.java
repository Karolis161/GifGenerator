package com.ibm.gifgenerator.repository;

import com.ibm.gifgenerator.entities.Gif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GifGeneratorRepository extends JpaRepository<Gif, Integer> {

}
