package br.com.avaliacaofinal.avaliacaofinal.repository;

import br.com.avaliacaofinal.avaliacaofinal.model.Canino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaninosRepository extends JpaRepository<Canino, Integer> {
}
