package br.com.avaliacaofinal.avaliacaofinal.repository.RacaRepository;

import br.com.avaliacaofinal.avaliacaofinal.model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {
}
