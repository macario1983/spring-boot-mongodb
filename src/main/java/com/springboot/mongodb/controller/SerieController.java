package com.springboot.mongodb.controller;

import com.springboot.mongodb.dto.SerieDTO;
import com.springboot.mongodb.service.SerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/series")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SerieController {

    private final SerieService serieService;

    @GetMapping
    public ResponseEntity<List<SerieDTO>> findAll() {
        return ResponseEntity.ok().body(serieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(serieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SerieDTO> save(@RequestBody @Valid SerieDTO serieDTO) {
        return ResponseEntity.ok().body(serieService.insert(serieDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieDTO> update(@PathVariable UUID id, @RequestBody @Valid SerieDTO serieDTO) {
        return ResponseEntity.ok().body(serieService.update(id, serieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        serieService.delete(id);
        return ResponseEntity.ok().build();
    }

}
