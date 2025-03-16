package pe.edu.idat.Ec3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.Ec3.model.ClienteModel;

@Controller
public class DescuentoController {
    @GetMapping("/descuento")
    public String formularioDescuento(Model model){
        model.addAttribute("cliente", new ClienteModel());
        return "descuento";
    }
    @PostMapping("/calcularDescuento")
    public String calcularDescuento(@ModelAttribute("cliente") ClienteModel cliente, Model model){
        double anios = cliente.getAniosCliente();
        double totalParcial = cliente.getTotalParcial();
        double descuento = 0;

        if (anios < 1) {
            descuento = 0.02;
        } else if (anios <= 3) {
            descuento = 0.05;
        } else if (anios <= 5) {
            descuento = 0.08;
        } else {
            descuento = 0.12;
        }
        double total = totalParcial - (totalParcial*descuento);
        model.addAttribute("resultado", "Usted obtiene un descuento de: "+ descuento + ", su total a pagar es: "+ String.format("%.2f", total));
        return "descuento";
    }
}
