package br.com.fiap.metaflow.controller;

import br.com.fiap.metaflow.entity.Usuario;
import br.com.fiap.metaflow.entity.UsuarioRole;
import br.com.fiap.metaflow.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private void adicionarRolesAoModel(Model model) {
        model.addAttribute("roles", UsuarioRole.values());
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.readUsuarios();
        model.addAttribute("listaUsuarios", usuarios);
        return "usuarioLista";
    }

    @GetMapping("/cadastro")
    public String cadastroUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        adicionarRolesAoModel(model);
        return "usuarioCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@Valid Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            adicionarRolesAoModel(model); // ADICIONAR AS ROLES EM CASO DE ERRO!
            return "usuarioCadastro";
        }

        if (usuario.getId() == null) {
            usuarioService.createUsuario(usuario);
        } else {
            usuarioService.updateUsuario(usuario);
        }

        return "redirect:/usuarios/lista";
    }

    @GetMapping("/cadastro/{id}")
    public String cadastroUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.readUsuario(id);
        if (usuario == null) {
            return "redirect:/usuarios/lista";
        }
        model.addAttribute("usuario", usuario);
        adicionarRolesAoModel(model);
        return "usuarioCadastro";
    }

    @PostMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/lista";
    }
}