package pe.edu.idat.Ec3.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.ImpuestoModel;

@Controller
public class ImpuestoController {

    @GetMapping("/impuesto")
    public String formularioImpuesto(Model model) {
        model.addAttribute("impuestomodel", new ImpuestoModel());
        model.addAttribute("visualizaralerta", false);
        return "impuesto";
    }

    @PostMapping("/calcularimpuesto")
    public String calcularImpuesto(@ModelAttribute("impuestomodel") ImpuestoModel impuesto, Model model) {
        String categoria = impuesto.getCategoria().toUpperCase();
        Double impuestos = impuesto.getImpuesto();
        Double monto = impuesto.getMonto();

        if (categoria.equals("ELECTRONICA")){
            impuestos=0.15;

        } else if (categoria.equals("ALIMENTOS")) {
            impuestos= 0.05;
        }
            else if (categoria.equals("ROPA")) {
            impuestos= 0.08;
        } else if (categoria.equals("MUEBLES")) {
            impuestos = 0.1;
        }
            monto +=(monto * impuestos);


        model.addAttribute("impuesto", impuestos);
        model.addAttribute("resultado", "El Precio Final con Impuestos es: S/. " + String.format("%.2f", monto));
        model.addAttribute("visualizaralerta", true);

        return "impuesto";
    }
}
