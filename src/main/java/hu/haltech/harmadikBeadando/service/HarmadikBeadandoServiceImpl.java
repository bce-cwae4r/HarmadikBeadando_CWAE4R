package hu.haltech.harmadikBeadando.service;

import hu.haltech.harmadikBeadando.HarmadikBeadandoAlreadyExistsException;
import hu.haltech.harmadikBeadando.dao.HarmadikBeadandoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HarmadikBeadandoServiceImpl implements HarmadikBeadandoService {

    private final HarmadikBeadandoDao harmadikBeadandoDao;

    @Override
    public void forditott(HarmadikBeadando harmadikBeadando) throws HarmadikBeadandoAlreadyExistsException {

        Collection<HarmadikBeadando> all = getAll();

        StringBuilder content = new StringBuilder((CharSequence) harmadikBeadando).reverse();

        harmadikBeadandoDao.forditott(
                hu.haltech.harmadikBeadando.dao.HarmadikBeadando.builder()
                        .content(harmadikBeadando.getContent())
                        .build()
        );
    }

    public Collection<HarmadikBeadando>getAll() {
        return harmadikBeadandoDao.readAll().stream().map(
                daoHarmadikBeadando -> HarmadikBeadando.builder()
                .content(daoHarmadikBeadando.getContent())
                .build()
        ).collect(Collectors.toList());
    }
}
