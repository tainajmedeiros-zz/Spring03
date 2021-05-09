package com.aula.aulaSpring.controller;

import com.aula.aulaSpring.entity.Cliente;
import com.aula.aulaSpring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping( "api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public Cliente addCliente(@RequestBody Cliente pessoa){
        return clienteService.add(pessoa);
    }

    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable(value = "id") long id){
        return clienteService.get(id);
    }

    @PutMapping("/cliente/{id}")
    public Cliente updateCliente(@RequestBody Cliente pessoa, @PathVariable(value = "id") long id){
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.isPresent()) {
            pessoa.setID(cliente.get().getID());
            return clienteService.update(pessoa);
        }
        return null;
    }

    @GetMapping("/quantidadeClientes")
    public long qtdeCliente(){
        return clienteService.quantidaClientes();
    }
}
