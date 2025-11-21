package br.com.fiap.metaflow.service;

import br.com.fiap.metaflow.entity.Habilidade;
import br.com.fiap.metaflow.repository.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadeService {
    private final HabilidadeRepository habilidadeRepository;

    @Autowired
    public HabilidadeService(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    // CRUD
    public Habilidade createHabilidade(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public Habilidade readHabilidade(Long id) {
        return habilidadeRepository.findById(id).orElse(null);
    }

    public List<Habilidade> readHabilidades() {
        return habilidadeRepository.findAll();
    }

    public Habilidade updateHabilidade(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public void deleteHabilidade(Long id) {
        habilidadeRepository.deleteById(id);
    }
}