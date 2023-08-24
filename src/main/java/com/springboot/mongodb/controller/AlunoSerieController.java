package com.springboot.mongodb.controller;

import com.springboot.mongodb.dto.AlunoSerieDTO;
import com.springboot.mongodb.service.AlunoSerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/alunosSerie")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoSerieController {

    private final AlunoSerieService alunoSerieService;

    @GetMapping
    public ResponseEntity<List<AlunoSerieDTO>> findAll() {
        return ResponseEntity.ok().body(alunoSerieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoSerieDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(alunoSerieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlunoSerieDTO> insert(@RequestBody @Valid AlunoSerieDTO alunoSerieDTO) {
        return ResponseEntity.ok().body(alunoSerieService.insert(alunoSerieDTO));
    }

}

