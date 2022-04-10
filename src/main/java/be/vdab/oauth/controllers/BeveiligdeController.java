package be.vdab.oauth.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/beveiligd")
public class BeveiligdeController {
    @GetMapping
    //@AuthenticationPrincipal zorgt ervoor dat Spring de parameter vult met eigenschappen over de ingelogde gebruiker
    public ModelAndView securedPage(@AuthenticationPrincipal OAuth2User user) {
        //De gebruiker moet eerst inloggen op de website (hier GitHub), als dat lukt kom de request in deze method
        //We vragen de eigenschap "login": de gebruikersnaam op GitHub en geven die door aan de Thymeleaf pagina
        return new ModelAndView("beveiligd", "gebruikersNaam", user.getAttribute("login"));
    }
}
