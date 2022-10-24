package com.gft.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gft.entities.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{	

	public Optional<Veterinario> findByCrmv(String crmv);

	public List<Veterinario> findByNomeContains(String nome);


}
