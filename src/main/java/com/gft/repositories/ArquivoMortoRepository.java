package com.gft.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.ArquivoMorto;

@Repository
public interface ArquivoMortoRepository extends JpaRepository<ArquivoMorto, Long>{

}
