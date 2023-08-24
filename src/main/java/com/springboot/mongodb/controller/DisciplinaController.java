package com.springboot.mongodb.controller;

import com.springboot.mongodb.dto.DisciplinaDTO;
import com.springboot.mongodb.service.DisciplinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> findAll() {
        return ResponseEntity.ok().body(disciplinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(disciplinaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> insert(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.ok().body(disciplinaService.insert(disciplinaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> update(@PathVariable UUID id, @RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.ok().body(disciplinaService.update(id, disciplinaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        disciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
