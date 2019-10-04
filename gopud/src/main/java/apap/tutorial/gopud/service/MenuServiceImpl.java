package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu) {
        menuDb.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public void deleteMenu(MenuModel menu) {
        menuDb.delete(menu);
    }

    @Override
    public Optional<MenuModel> getMenuById(Long id) {
        return menuDb.findById(id);
    }

    @Override
    public MenuModel changeMenu(MenuModel menuModel) {
        // mengambil object restoran yang ingin diubah
        MenuModel targetMenu = menuDb.findById(menuModel.getId()).get();

        try{
            targetMenu.setNama(targetMenu.getNama());
            targetMenu.setHarga(targetMenu.getHarga());
            targetMenu.setDurasiMasak(targetMenu.getDurasiMasak());
            targetMenu.setDeskripsi(targetMenu.getDeskripsi());
            menuDb.save(targetMenu);
            return targetMenu;
        } catch (NullPointerException nullException){
            return null;
        }
    }
}