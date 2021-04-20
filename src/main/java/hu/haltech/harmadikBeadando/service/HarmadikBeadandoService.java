package hu.haltech.harmadikBeadando.service;

import hu.haltech.harmadikBeadando.HarmadikBeadandoAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface HarmadikBeadandoService {
    void forditott(HarmadikBeadando harmadikBeadando) throws HarmadikBeadandoAlreadyExistsException;

    Collection<HarmadikBeadando>getAll();
}
