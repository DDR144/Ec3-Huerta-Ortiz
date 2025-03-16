package pe.edu.idat.Ec3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.Ec3.model.VendedorModel;

@Controller
public class ComisionController {
    @GetMapping("/comision")
    public String formularioComision(Model model){
        model.addAttribute("vendedor", new VendedorModel());
        return "comision";
    }
    @PostMapping("/calcularComision")
    public String calcularComision(@ModelAttribute("vendedor") VendedorModel vendedor, Model model){
        double ventas = vendedor.getVentasMensuales();
        double comision = 0;

        if (ventas < 1000){
            comision = ventas * 0.03;
        } else if (ventas <= 5000) {
            comision = ventas * 0.05;
        } else if (ventas <= 10000) {
            comision = ventas * 0.07;
        } else {
            comision = ventas * 0.10;
        }
        model.addAttribute("resultado", "Su ganancia en comisiones es: "+ String.format("%.2f", comision));
        return "comision";
    }
}
