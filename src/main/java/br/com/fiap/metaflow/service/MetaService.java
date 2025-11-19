package br.com.fiap.metaflow.service;

import br.com.fiap.metaflow.entity.Meta;
import br.com.fiap.metaflow.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {
    private final MetaRepository metaRepository;

    @Autowired
    public MetaService(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    // CRUD
    public Meta createMeta(Meta meta) {
        return metaRepository.save(meta);
    }

    public Meta readMeta(Long id) {
        return metaRepository.findById(id).orElse(null);
    }

    public List<Meta> readMetas() {
        return metaRepository.findAll();
    }

    public Meta updateMeta(Meta meta) {
        return metaRepository.save(meta);
    }

    public void deleteMeta(Long id) {
        metaRepository.deleteById(id);
    }
}