package hu.haltech.harmadikBeadando.dao;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Slf4j
public class HarmadikBeadanoDaoImpl implements HarmadikBeadandoDao {

    private final List<HarmadikBeadando> harmadikBeadandoList = new ArrayList<>();

@PostConstruct
    void init() {
        log.info("init");
        harmadikBeadandoList.add(HarmadikBeadando.builder()
                .content("Alma a fa alatt")
                .build());
    }

    @Override
    public Collection<HarmadikBeadando> readAll() {
        return harmadikBeadandoList;
    }

    @Override
    public void forditott(HarmadikBeadando harmadikBeadando) {}

}
