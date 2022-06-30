package br.com.avaliacaofinal.avaliacaofinal.controller;

import br.com.avaliacaofinal.avaliacaofinal.model.Raca;
import br.com.avaliacaofinal.avaliacaofinal.service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/racas")
public class RacaController {

    @Autowired
    RacaService racaService;

    @PostMapping(value = "cadastrar")
    public Raca cadastrar(@RequestBody Raca raca){
        return racaService.save(raca);
    }

    @GetMapping
    public List<Raca> listarRaca() {
        return racaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Raca> findById(@PathVariable(value = "id") Integer racaID) {
        Raca raca = racaService.findById(racaID)
            .orElseThrow(() -> new EntityNotFoundException("Raça não encontrada:" + racaID));
        return ResponseEntity.ok().body(raca);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRaca(@PathVariable(value = "id") Integer racaID) {
        Raca raca = racaService.findById(racaID)
            .orElseThrow(() -> new EntityNotFoundException("Nenhuma raça encontrada para este id: " + racaID));

        racaService.delete(racaID);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }


}
