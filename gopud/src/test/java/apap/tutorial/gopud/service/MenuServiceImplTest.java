package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.repository.RestoranDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDb menuDb;

    @Test
    public void whenAddValidMenuItShouldCallRestoranRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("mekdi");
        newMenu.setHarga(BigInteger.valueOf(10000));
        newMenu.setDurasiMasak(60);
        newMenu.setDeskripsi("enak banget");
        menuService.addMenu(newMenu);
        verify(menuDb, times(1)).save(newMenu);
    }

    @Test
    public void whenDeleteValidMenuItShouldCallRestoranRepositoryDelete() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("mekdi");
        newMenu.setHarga(BigInteger.valueOf(10000));
        newMenu.setDurasiMasak(60);
        newMenu.setDeskripsi("enak banget");
        menuService.addMenu(newMenu);
        menuService.deleteMenu(newMenu);
        verify(menuDb, times(1)).delete(newMenu);
    }

    @Test
    public void whenGetListMenuOrderByHargaAscCalledItShouldReturnAllMenu() {
        RestoranModel newRestoran = new RestoranModel();
        RestoranService restoranService = new RestoranServiceImpl();

        newRestoran.setNama("mekdi");
        newRestoran.setAlamat("pacil");
        newRestoran.setNomorTelepon(14045);
        newRestoran.setIdRestoran(71L);
//        newRestoran.setListMenu(new ArrayList<>());
        restoranService.addRestoran(newRestoran);
        for (int loopTimes = 4; loopTimes > 0; loopTimes--) {
//            restoranService.getRestoranList().add(new MenuModel());
//            newRestoran.getListMenu().add(new MenuModel());
            menuService.addMenu(new MenuModel());
        }


        List<MenuModel> listMenuFromServiceCall = menuDb.findByRestoranIdRestoranOrderByHarga(71L);
        assertEquals(0, listMenuFromServiceCall.size());
        verify(menuDb, times(1)).findAll();
    }

}
