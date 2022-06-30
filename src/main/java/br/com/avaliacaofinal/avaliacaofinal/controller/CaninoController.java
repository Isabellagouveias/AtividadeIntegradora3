package br.com.avaliacaofinal.avaliacaofinal.controller;

import br.com.avaliacaofinal.avaliacaofinal.model.Canino;
import br.com.avaliacaofinal.avaliacaofinal.service.CaninosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/caninos")
public class CaninoController {

    @Autowired CaninosService caninosService;

    @PostMapping(value = "cadastrar")
    public Canino cadastrar(@RequestBody Canino canino){
        return caninosService.save(canino);
    }

    @GetMapping
    public List<Canino> listarRaca() {
        return caninosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Canino> findById(@PathVariable(value = "id") Integer caoID) {
        Canino canino = caninosService.findById(caoID)
            .orElseThrow(() -> new EntityNotFoundException("Cão não encontrado:" + caoID));
        return ResponseEntity.ok().body(canino);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRaca(@PathVariable(value = "id") Integer racaID) {
        Canino canino = caninosService.findById(racaID)
            .orElseThrow(() -> new EntityNotFoundException("Nenhuma raça encontrada para este id: " + racaID));

        caninosService.delete(racaID);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
