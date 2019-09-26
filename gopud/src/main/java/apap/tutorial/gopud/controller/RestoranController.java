package apap.tutorial.gopud.controller;

import java.util.List;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String home() { return "home" };

    //URL mapping yang digunakan untuk mengakses halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        return "form-add-restoran";
    }

    //URL Mapping yang digunakan untuk submit form yang telah anda masukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST);
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
            //Request Parameter untuk dipass
            @RequestParam(value = "idRestoran") Long idRestoran, Model model
            ){

        //Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

        //Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        model.addAttribute("menuList", menuList);

        //Return view template
        return "view-restoran";
    }

    //API yang digunakan untuk menuju halaman form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        //Memanggil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        return "form-change-restoran";
    }

    //API yang digunakan untuk submit form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);

        return "change-restoran";
    }

    //URL mapping add
    @RequestMapping("/restoran/add")
    public String add(
            //Request Parameter untuk dipass
            @RequestParam(value = "idRestoran", required = true) String idRestoran,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
            Model model
            ) {

        //Membuat objek RestoranModel
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        //Memanggil service addRestoran
        restoranService.addRestoran(restoran);

        //Add variabel nama restoran ke "namaResto" untuk dirender
        model.addAttribute("namaResto", nama);

        //Return view template
        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping(path = "/restoran/view")
    public String view(
            //Request Parameter untuk dipass
            @RequestParam(value = "idRestoran") String idRestoran, Model model
//            @PathVariable("id") String idLestoran
            ) {

        //Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        //Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        //Return view template
        return "view-restoran";
    }

    //URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewall(Model model) {

        //Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        //Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        //Return view template
        return "viewall-restoran";
    }

    //URL mapping delete
    @RequestMapping("/restoran/delete/id/{idRestoran}")
    public String delete(
            //Request parameter untuk dipass
            @PathVariable("idRestoran") String idRestoran, Model model
            ) {

        //Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        //Mencari restoran dengan id sesuai input
        for(int i = 0; i < listRestoran.size(); i++) {
            if(listRestoran.get(i).getIdRestoran().equals(idRestoran)) {
                listRestoran.remove(i);
            }
        }

        //Add variabel id restoran ke "idRestoran" untuk dirender
        model.addAttribute("idRestoran", idRestoran);

        //Return view template
        return "delete-restoran";
    }
}
