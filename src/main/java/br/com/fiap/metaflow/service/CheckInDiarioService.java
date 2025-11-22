package br.com.fiap.metaflow.service;

import br.com.fiap.metaflow.entity.CheckInDiario;
import br.com.fiap.metaflow.repository.CheckInDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInDiarioService {
    private final CheckInDiarioRepository checkInDiarioRepository;

    @Autowired
    public CheckInDiarioService(CheckInDiarioRepository checkInDiarioRepository) {
        this.checkInDiarioRepository = checkInDiarioRepository;
    }

    // CRUD
    public CheckInDiario createCheckInDiario(CheckInDiario checkInDiario) {
        return checkInDiarioRepository.save(checkInDiario);
    }

    public CheckInDiario readCheckInDiario(Long id) {
        return checkInDiarioRepository.findById(id).orElse(null);
    }

    public List<CheckInDiario> readCheckInDiarios() {
        return checkInDiarioRepository.findAll();
    }

    public CheckInDiario updateCheckInDiario(CheckInDiario checkInDiario) {
        return checkInDiarioRepository.save(checkInDiario);
    }

    public void deleteCheckInDiario(Long id) {
        checkInDiarioRepository.deleteById(id);
    }
}