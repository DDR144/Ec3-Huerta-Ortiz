package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.BonificacionModel;

@Controller
public class BonificacionController {

    @GetMapping("/bonificacion")
    public String formularioBonificacion(Model model){
        model.addAttribute("bonificacionmodel", new BonificacionModel());
        model.addAttribute("visualizaralerta", false);
        return "bonificacion";
    }

    @PostMapping("/calcularbonificacion")
    public String calcularBonificacion(@ModelAttribute("bonificacionmodel") BonificacionModel bonificacion, Model model) {
        double monto = bonificacion.getMonto();
        int dias = bonificacion.getDias();
        double descuento = bonificacion.getDescuento();

        if (dias < 7) {
            descuento = 0.10;
        } else if (dias <= 15) {
            descuento = 0.05;
        } else {
            descuento = 0;
        }
        monto -=( monto * descuento);


        //!--model.addAttribute("montooriginal", bonificacion.getMonto());
        model.addAttribute("total", monto);
        model.addAttribute("resultado", "El Total a Pagar con Bonificación es: S/. " + String.format("%.2f", monto));
        model.addAttribute("visualizaralerta", true);
        return "bonificacion";
    }
}
