package com.springboot.mongodb.controller;


import com.springboot.mongodb.dto.AlunoDTO;
import com.springboot.mongodb.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll() {
        return ResponseEntity.ok().body(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(alunoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@RequestBody @Valid AlunoDTO alunoDTO) {
        return ResponseEntity.ok().body(alunoService.insert(alunoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable UUID id, @RequestBody @Valid AlunoDTO alunoDTO) {
        return ResponseEntity.ok().body(alunoService.update(id, alunoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
