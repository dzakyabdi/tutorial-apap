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
    RestoranService restoranService = new RestoranServiceImpl();

    @Mock
    MenuDb menuDb;
    RestoranDb restoranDb;

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
        List<MenuModel> newListMenuDatabase = new ArrayList<>();
        int harga = 5000;
        for (int loopTimes = 4; loopTimes > 0; loopTimes--) {
            MenuModel newMenu = new MenuModel();
            newMenu.setHarga(BigInteger.valueOf(harga++));
            newListMenuDatabase.add(newMenu);
        }

        when(menuService.getListMenuOrderByHargaAsc(newRestoran.getIdRestoran())).thenReturn(newListMenuDatabase);
        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(newRestoran.getIdRestoran());
        int tesharga = 5000;
        for(int i = 0; i < 4; i++) {
            assertEquals(BigInteger.valueOf(tesharga++), dataFromServiceCall.get(i).getHarga());
        }
    }

    @Test
    public void whenFindAllMenuByIdRestoranCalledItShouldReturnAllMenu() {
        RestoranModel restoran = new RestoranModel();
        List<MenuModel> allMenuFromOneRestoranInDataBase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuFromOneRestoranInDataBase.add(new MenuModel());
        }
        when(menuService.findAllMenuByIdRestoran(restoran.getIdRestoran())).thenReturn(allMenuFromOneRestoranInDataBase);
        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        assertEquals(3, dataFromServiceCall.size());
//        verify(menuDb, times(1)).findAll();
    }
}
