package com.javierburillo.javierburillo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javierburillo.javierburillo.models.PalabraPorLetras;
import com.javierburillo.javierburillo.repositories.IPalabraRepo;

@Service
public class PalabrasService implements IPalabraService {

    @Autowired
    public IPalabraRepo repo;

    @Override
    public List<PalabraPorLetras> check(String PalabraPorLetras) {
        List<PalabraPorLetras> list = new ArrayList<PalabraPorLetras>();
        if (PalabraPorLetras.length() != repo.getPalabras().size() || repo.getTries() <= 0) {
            return null;
        }
        for (int i = 0; i < PalabraPorLetras.length(); i++) {
            if (PalabraPorLetras.charAt(i) == repo.getPalabras().get(i).getPalabraPorLetras()) {
                list.add(new PalabraPorLetras(true, PalabraPorLetras.charAt(i), i, i));
                continue;
            }
            boolean found = false;
            for (int j = 0; j < repo.getPalabras().size(); j++) {
                if (PalabraPorLetras.charAt(i) == repo.getPalabras().get(j).getPalabraPorLetras()) {
                    list.add(new PalabraPorLetras(true, PalabraPorLetras.charAt(i), i, j));
                    found = true;
                    break;
                } else {
                    found = false;
                }
            }
            if (!found) {
                list.add(new PalabraPorLetras(false, PalabraPorLetras.charAt(i), i));
            }
        }
        repo.getBefore().add(PalabraPorLetras);
        repo.minusOneTry();
        return list;
    }

    @Override
    public List<String> getBefore() {
        return repo.getBefore();
        // TODO Auto-generated method stub

    }

    @Override
    public String getWordByPos(int pos) {
        if (pos >= repo.getBefore().size() || pos < 0) {
            return null;
        }
        return repo.getBefore().get(pos);
    }

    @Override
    public int getAttempts() {
        // TODO Auto-generated method stub
        return repo.getTries();
    }

    public void setRepo(IPalabraRepo iPalabraRepo) {
    }

}
