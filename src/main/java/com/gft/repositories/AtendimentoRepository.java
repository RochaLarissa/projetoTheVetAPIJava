package com.gft.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gft.entities.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
