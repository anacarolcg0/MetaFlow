package br.com.fiap.metaflow.controller;

import br.com.fiap.metaflow.entity.Meta;
import br.com.fiap.metaflow.entity.Usuario;
import br.com.fiap.metaflow.service.MetaService;
import br.com.fiap.metaflow.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public String listarMetas(Model model) {
        List<Meta> metas = metaService.readMetas();
        model.addAttribute("listaMetas", metas);
        return "metaLista";
    }

    @GetMapping("/cadastro")
    public String cadastroMeta(Model model) {
        model.addAttribute("meta", new Meta());
        model.addAttribute("usuarioLista", usuarioService.readUsuarios());
        return "metaCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarMeta(
            @Valid @ModelAttribute("meta") Meta meta,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            model.addAttribute("usuarioLista", usuarioService.readUsuarios());
            return "metaCadastro";
        }

        if (meta.getUsuario() != null && meta.getUsuario().getId() != null) {
            Usuario u = usuarioService.readUsuario(meta.getUsuario().getId());
            meta.setUsuario(u);
        }

        if (meta.getIdMeta() == null) {
            metaService.createMeta(meta);
        } else {
            metaService.updateMeta(meta);
        }

        return "redirect:/metas/lista";
    }

    @GetMapping("/cadastro/{id}")
    public String cadastroMeta(@PathVariable Long id, Model model) {
        Meta meta = metaService.readMeta(id);
        if (meta == null) {
            return "redirect:/metas/lista";
        }
        model.addAttribute("meta", meta);
        model.addAttribute("usuarioLista", usuarioService.readUsuarios());
        return "metaCadastro";
    }

    @PostMapping("/deletar/{id}")
    public String deletarMeta(@PathVariable Long id) {
        metaService.deleteMeta(id);
        return "redirect:/metas/lista";
    }
}