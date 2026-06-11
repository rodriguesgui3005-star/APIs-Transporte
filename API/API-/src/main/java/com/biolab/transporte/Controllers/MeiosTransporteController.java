package com.biolab.transporte.Controllers;


import com.biolab.transporte.Entities.MeiosTransporte;
import com.biolab.transporte.Repositories.MeiosTransporteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeiosTransporteController {

    private final MeiosTransporteRepository meiosTransporteRepository;

    public MeiosTransporteController(MeiosTransporteRepository meiosTransporteRepository) {
        this.meiosTransporteRepository = meiosTransporteRepository;
    }


    @PostMapping(value = "/criar")
    public String criarTransporte1(@RequestBody MeiosTransporte meiosTransporte){
        MeiosTransporte m = new MeiosTransporte(meiosTransporte.getNome(), meiosTransporte.getTipo(), meiosTransporte.getCapacidade(), meiosTransporte.getValor());
        meiosTransporteRepository.save(m);
        return "Salvo com sucesso";
    }
    @GetMapping(value = "/mostrar")
    public List<MeiosTransporte> mostraTransporte (){
        List<MeiosTransporte> listameiotransport = meiosTransporteRepository.findAll();
        return listameiotransport;
    }
    //deleta
    @DeleteMapping(value = "/{id}")
    public String deletarMeiotransporte(@PathVariable long id){
        MeiosTransporte meiosTransporte = meiosTransporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Meio de transporte não encontrado"));
        meiosTransporteRepository.deleteById(meiosTransporte.getId());
        return "Meio de transporte excluido com sucesso";
    }

    @PostMapping(value = "/{id}")
    public MeiosTransporte alterarMeiotransporte(@PathVariable long id, @RequestBody MeiosTransporte tAtualizado) {
        MeiosTransporte meiosTransporte = meiosTransporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Meio de transporte não encontrado"));
        meiosTransporte.setNome(tAtualizado.getNome());
        meiosTransporte.setCapacidade(tAtualizado.getCapacidade());
        meiosTransporte.setValor(tAtualizado.getValor());
        return  meiosTransporteRepository.save(meiosTransporte);
    }
}
