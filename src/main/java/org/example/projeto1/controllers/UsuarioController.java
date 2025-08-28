package org.example.projeto1.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projeto1.models.dto.UsuarioDTO;
import org.example.projeto1.models.entities.Usuario;
import org.example.projeto1.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.createUsuario(usuarioDTO);
        return ResponseEntity.status(201).build(); //201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuario(@PathVariable Long id) {
        Usuario usuarioEncontrado = usuarioService.getUsuario(id);
        return ResponseEntity.ok(usuarioEncontrado); //200 OK
    }

}
