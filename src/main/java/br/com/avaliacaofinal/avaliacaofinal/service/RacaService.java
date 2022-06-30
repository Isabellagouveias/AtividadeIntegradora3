package br.com.avaliacaofinal.avaliacaofinal.service;

import br.com.avaliacaofinal.avaliacaofinal.model.Raca;
import br.com.avaliacaofinal.avaliacaofinal.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacaService {

    @Autowired private RacaRepository racaRepository;

    public Optional<Raca> findById (Integer racaID) {
        return racaRepository.findById(racaID);
    }

    public List<Raca> findAll () {
        return racaRepository.findAll();
    }

    public void delete (Integer racaID) {
        racaRepository.deleteById(racaID);
    }

    public Raca save (Raca raca) {
        return racaRepository.save(raca);
    }


}
