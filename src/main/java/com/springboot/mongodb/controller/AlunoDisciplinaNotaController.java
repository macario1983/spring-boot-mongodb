package com.springboot.mongodb.controller;


import com.springboot.mongodb.dto.AlunoDisciplinaNotaDTO;
import com.springboot.mongodb.service.AlunoDisciplinaNotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/alunosDisciplinaNota")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoDisciplinaNotaController {

    private final AlunoDisciplinaNotaService alunoDisciplinaNotaService;

    @GetMapping
    public ResponseEntity<List<AlunoDisciplinaNotaDTO>> findAll() {
        return ResponseEntity.ok().body(alunoDisciplinaNotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDisciplinaNotaDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(alunoDisciplinaNotaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDisciplinaNotaDTO> insert(@RequestBody @Valid AlunoDisciplinaNotaDTO alunoDisciplinaNotaDTO) {
        return ResponseEntity.ok().body(alunoDisciplinaNotaService.insert(alunoDisciplinaNotaDTO));
    }

}
