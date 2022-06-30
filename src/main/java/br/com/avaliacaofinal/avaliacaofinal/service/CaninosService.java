package br.com.avaliacaofinal.avaliacaofinal.service;

import br.com.avaliacaofinal.avaliacaofinal.model.Canino;
import br.com.avaliacaofinal.avaliacaofinal.repository.CaninosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaninosService {
    @Autowired private CaninosRepository caninosRepository;

    public Optional<Canino> findById (Integer racaID) {
        return caninosRepository.findById(racaID);
    }

    public List<Canino> findAll () {
        return caninosRepository.findAll();
    }

    public void delete (Integer racaID) {
        caninosRepository.deleteById(racaID);
    }

    public Canino save (Canino canino) {
        return caninosRepository.save(canino);
    }
}
