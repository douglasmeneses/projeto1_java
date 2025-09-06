package org.example.projeto1.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projeto1.models.dto.UsuarioDTO;
import org.example.projeto1.models.dto.UsuarioPublicoDTO;
import org.example.projeto1.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.createUsuario(usuarioDTO);
        return ResponseEntity.status(201).build(); //201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {
        return usuarioService.retornaUsuario(id);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioPublicoDTO>> getUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deletaUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> attUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.atualizaUsuario(id, usuarioDTO);

    }

}
