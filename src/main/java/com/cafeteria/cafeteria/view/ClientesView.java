package com.cafeteria.cafeteria.view;

import com.cafeteria.cafeteria.model.Clientes;
import com.cafeteria.cafeteria.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientesView
{
    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("/view/clientes")
    public String lista(Model model)
    {
        model.addAttribute("clientes", clientesRepository.findAll());
        return "clientes";
    }

    @GetMapping("/view/clientes/form")
    public String form(Model model)
    {
        model.addAttribute("clientes", new Clientes());
        return "clientesForm";
    }

    @PostMapping("/view/clientes/save")
    public String save(@ModelAttribute Clientes clientes, RedirectAttributes ra)
    {
        clientesRepository.save(clientes);
        ra.addFlashAttribute("mensaje", "Cliente guardado correctamente");
        return "redirect:/view/clientes";
    }

    @GetMapping("/view/clientes/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        Clientes clientes = clientesRepository.findById(id).orElse(null);
        model.addAttribute("clientes", clientes);
        return "clientesForm";
    }

    @PostMapping("/view/clientes/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        clientesRepository.deleteById(id);
        ra.addFlashAttribute("mensaje", "Cliente eliminado correctamente");
        return "redirect:/view/clientes";
    }




}
