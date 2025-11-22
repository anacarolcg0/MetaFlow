package br.com.fiap.metaflow.controller;

import br.com.fiap.metaflow.entity.CheckInDiario;
import br.com.fiap.metaflow.entity.Usuario;
import br.com.fiap.metaflow.service.CheckInDiarioService;
import br.com.fiap.metaflow.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/checkInDiarios")
public class CheckInDiarioController {

    @Autowired
    private CheckInDiarioService checkInDiarioService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public String listarCheckInDiarios(Model model) {
        List<CheckInDiario> checkInDiarios = checkInDiarioService.readCheckInDiarios();
        model.addAttribute("listaCheckInDiarios", checkInDiarios);
        return "checkInDiarioLista";
    }

    @GetMapping("/cadastro")
    public String cadastroCheckInDiario(Model model) {
        model.addAttribute("checkInDiario", new CheckInDiario());
        model.addAttribute("usuarioLista", usuarioService.readUsuarios());
        return "checkInDiarioCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarCheckInDiario(
            @Valid @ModelAttribute("checkInDiario") CheckInDiario checkInDiario,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            model.addAttribute("usuarioLista", usuarioService.readUsuarios());
            return "checkInDiarioCadastro";
        }

        if (checkInDiario.getUsuario() != null && checkInDiario.getUsuario().getId() != null) {
            Usuario u = usuarioService.readUsuario(checkInDiario.getUsuario().getId());
            checkInDiario.setUsuario(u);
        }

        if (checkInDiario.getIdCheckInDiario() == null) {
            checkInDiarioService.createCheckInDiario(checkInDiario);
        } else {
            checkInDiarioService.updateCheckInDiario(checkInDiario);
        }

        return "redirect:/checkInDiarios/lista";
    }

    @GetMapping("/cadastro/{id}")
    public String cadastroCheckInDiario(@PathVariable Long id, Model model) {
        CheckInDiario checkInDiario = checkInDiarioService.readCheckInDiario(id);
        if (checkInDiario == null) {
            return "redirect:/checkInDiarios/lista";
        }
        model.addAttribute("checkInDiario", checkInDiario);
        model.addAttribute("usuarioLista", usuarioService.readUsuarios());
        return "checkInDiarioCadastro";
    }

    @PostMapping("/deletar/{id}")
    public String deletarCheckInDiario(@PathVariable Long id) {
        checkInDiarioService.deleteCheckInDiario(id);
        return "redirect:/checkInDiarios/lista";
    }
}