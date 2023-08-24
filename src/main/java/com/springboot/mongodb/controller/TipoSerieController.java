package com.springboot.mongodb.controller;


import com.springboot.mongodb.dto.TipoSerieDTO;
import com.springboot.mongodb.service.TipoSerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tiposSerie")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TipoSerieController {

    private final TipoSerieService tipoSerieService;

    @GetMapping
    public ResponseEntity<List<TipoSerieDTO>> findAll() {
        return ResponseEntity.ok().body(tipoSerieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoSerieDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(tipoSerieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoSerieDTO> save(@RequestBody @Valid TipoSerieDTO tipoSerieDTO) {
        return ResponseEntity.ok().body(tipoSerieService.insert(tipoSerieDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoSerieDTO> update(@PathVariable UUID id, @RequestBody @Valid TipoSerieDTO tipoSerieDTO) {
        return ResponseEntity.ok().body(tipoSerieService.update(id, tipoSerieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tipoSerieService.delete(id);
        return ResponseEntity.ok().build();
    }

}


