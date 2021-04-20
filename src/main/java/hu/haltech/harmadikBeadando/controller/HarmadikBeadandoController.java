package hu.haltech.harmadikBeadando.controller;


import hu.haltech.harmadikBeadando.HarmadikBeadandoAlreadyExistsException;
import hu.haltech.harmadikBeadando.controller.dto.HarmadikBeadandóRequestDto;
import hu.haltech.harmadikBeadando.service.HarmadikBeadando;
import hu.haltech.harmadikBeadando.service.HarmadikBeadandoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/harmadik-beadando")
@RestController
@RequiredArgsConstructor




public class HarmadikBeadandoController {
    private final HarmadikBeadandoService harmadikBeadandoService;

    @PostMapping("/forditott")
    public void forditott(@RequestBody HarmadikBeadandóRequestDto dto) {
        try {
            harmadikBeadandoService.forditott(
                    HarmadikBeadando.builder()
                            .content(dto.getContent())
                            .build());
        } catch (HarmadikBeadandoAlreadyExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path = "/")
    public String getMessage(@RequestParam String nev) {
        if (nev.equals("")) {
            return String.format("Hello Felhasználó!");
        } else {
            return String.format("Hello %s!", nev);
        }
    }
}
