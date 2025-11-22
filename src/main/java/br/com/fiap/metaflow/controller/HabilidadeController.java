package br.com.fiap.metaflow.controller;

import br.com.fiap.metaflow.entity.Habilidade;
import br.com.fiap.metaflow.entity.Usuario;
import br.com.fiap.metaflow.service.HabilidadeService;
import br.com.fiap.metaflow.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public String listarHabilidades(Model model) {
        List<Habilidade> habilidades = habilidadeService.readHabilidades();
        model.addAttribute("listaHabilidades", habilidades);
        return "habilidadeLista";
    }

    @GetMapping("/cadastro")
    public String cadastroHabilidade(Model model) {
        model.addAttribute("habilidade", new Habilidade());
        model.addAttribute("usuarioLista", usuarioService.readUsuarios());
        return "habilidadeCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarHabilidade(
            @Valid @ModelAttribute("habilidade") Habilidade habilidade,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            model.addAttribute("usuarioLista", usuarioService.readUsuarios());
            return "habilidadeCadastro";
        }

        if (habilidade.getUsuario() != null && habilidade.getUsuario().getId() != null) {
            Usuario u = usuarioService.readUsuario(habilidade.getUsuario().getId());
            habilidade.setUsuario(u);
        }

        if (habilidade.getIdHabilidade() == null) {
            habilidadeService.createHabilidade(habilidade);
        } else {
            habilidadeService.updateHabilidade(habilidade);
        }

        return "redirect:/habilidades/lista";
    }

    @GetMapping("/cadastro/{id}")
    public String cadastroHabilidade(@PathVariable Long id, Model model) {
        Habilidade habilidade = habilidadeService.readHabilidade(id);
        if (habilidade == null) {
            return "redirect:/habilidades/lista";
        }
        model.addAttribute("habilidade", habilidade);
        model.addAttribute("usuarioLista", usuarioService.readUsuarios());
        return "habilidadeCadastro";
    }

    @PostMapping("/deletar/{id}")
    public String deletarHabilidade(@PathVariable Long id) {
        habilidadeService.deleteHabilidade(id);
        return "redirect:/habilidades/lista";
    }
}