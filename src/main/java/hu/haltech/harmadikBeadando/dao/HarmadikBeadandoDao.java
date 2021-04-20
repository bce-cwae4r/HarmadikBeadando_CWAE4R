package hu.haltech.harmadikBeadando.dao;

import java.util.Collection;

public interface HarmadikBeadandoDao {
    Collection<HarmadikBeadando>readAll();
    void forditott(HarmadikBeadando harmadikBeadando);
}
