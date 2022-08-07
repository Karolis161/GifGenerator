package com.ibm.gifgenerator.repository;

import com.ibm.gifgenerator.dto.Gif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GifGeneratorRepository extends JpaRepository<Gif, Integer> {

}
