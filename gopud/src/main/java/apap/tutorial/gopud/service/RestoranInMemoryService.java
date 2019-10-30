package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    //Constructor
    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public  void addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
    }

    @Override
    public void deleteRestoran(Long idRestoran) {}

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        RestoranModel output = null;
        for(RestoranModel r : listRestoran) {
            if (r.getIdRestoran().equals(idRestoran)) {
                output = r;
            }
        }
        return null;
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        return null;
    }
}
