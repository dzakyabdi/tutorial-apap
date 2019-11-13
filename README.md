# Tutorial APAP
## Authors
* **dzaky.abdi** - *1706043462* - *C*

What I have learned today

(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh menambahkan catatan apapun dibagian ini)
Github

    Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker? Issue Tracker merupakan cara yang bagus untuk melacak tugas, peningkatan, dan bug untuk sebuah project. Pada halaman repository istimewa karena fokus kami pada kolaborasi, referensi, dan pemformatan teks yang sangat baik.
    Apa perbedaan dari git merge dan merge --squash? git merge ketika beberapa kali commit kemudian di merge menjadi satu di master merge --squash ketika beberapa kali commit maka di merge menjadi satu commit lalu masuk ke master

Spring

    Apa itu library & dependency? library merupakan kumpulan class atau method yang dijadikan satu dependency merupakan hubungan program/software yang saling bergantung sehingga jika salah satu program tidak ada maka program tersebut tidak bisa berjalan
    Apa itu Maven? Mengapa kita perlu menggunakan Maven? Maven merupakan perangkat pemahaman yang biasa digunakan untuk proyek berbasis java dan berguna untuk maintenance struktur kode
    Apa alternatif dari Maven? Jenkins, Travis CI, Ansible, Gradle, Chef, TeamCity

What I did not understand

(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-check apabila Anda sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)

    Kenapa saya harus belajar APAP?
    cermat dalam mengetik
    pemahaman mendalam untuk intelij

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam tentang penulisan README.md pada github pada link berikut)


## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh
menambahkan catatan apapun dibagian ini)

#### Github
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker merupakan cara yang bagus untuk melacak tugas, peningkatan, dan bug untuk sebuah project. Pada halaman repository istimewa karena fokus kami pada kolaborasi, referensi, dan pemformatan teks yang sangat baik. 
2. Apa perbedaan dari git merge dan merge --squash?
git merge ketika beberapa kali commit kemudian di merge menjadi satu di master
merge --squash ketika beberapa kali commit maka di merge menjadi satu commit lalu masuk ke master

#### Spring
3. Apa itu library & dependency?
library merupakan kumpulan class atau method yang dijadikan satu
dependency merupakan hubungan program/software yang saling bergantung sehingga jika salah satu program tidak ada maka program tersebut tidak bisa berjalan
4. Apa itu Maven? Mengapa kita perlu menggunakan Maven?
Maven merupakan perangkat pemahaman yang biasa digunakan untuk proyek berbasis java dan berguna untuk maintenance struktur kode
5. Apa alternatif dari Maven?
Jenkins, Travis CI, Ansible, Gradle, Chef, TeamCity

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [x] cermat dalam mengetik
- [x] pemahaman mendalam untuk intelij

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam
tentang penulisan README.md pada github pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))


Tutorial 2
Pertanyaan 1: Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
terjadi error karena merender ke sebuah template html add-restoran padahal html tersebut tidak ada

Pertanyaan 2: Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
terjadi error karena tipe variable nomortelepon yaitu integer sedangkan dilink tersebut tidak ada

Pertanyaan 3: Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?
dapat diakses dengan 2 cara yaitu request variable dengan link http://localhost:8080/restoran/view?idRestoran={id-restoran}
 atau path param dengan link localhost:8080/restoran/view/id-restoran/{id-restoran}

4: Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall , apa yang akan ditampilkan? Sertakan
juga bukti screenshot mu.
list restoran-restoran yang telah ditambahkan
![](https://files.catbox.moe/ut6tqw.PNG)




Tutorial 3
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran , apakah kegunaan dari
method tersebut?
method findByRestoranIdRestoran akan melakukan pencarian mune yang terdapat pada objek RestoranModel.
Method ini akan mereturn list yang berisi menu-menu yang tersedia.
2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?
method addRestoranFormPage menggunakan method GET yang berarti pada method addRestoranFormPage akan mengambil form yang telah ada untuk menambahkan sebuah restoran.
Sedangkan untuk method addRestoranSubmit, method yang dilakukan ialah POST yang berarti pada method ini ketika dijalankan akan memposting data yang sudah diisi pada form ke database untuk disimpan
3. Jelaskan apa kegunaan dari JPA Repository?
JPA Repository memudahkan untuk melakukan CRUD (CREATE, READ, UPDATE, serta DELETE) pada database.
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?
Restoran Model
![Image description](https://ibb.co/85S278S)
Menu Model
![Image description](https://ibb.co/sgsTBVy)
terhubungnya relasi tersebut disebabkan pada MenuModel memiliki atribut dengan tipe relasi ManyToOne kepada RestoranModel.
Dan RestoranModel memliki atribut dengan tipe relasai OneToMany dan dipetakkan ke MenuModel.
5. Jelaskan kegunaan FetchType.LAZY , CascadeType.ALL , dan FetchType.EAGER
FetchType.LAZY berfungsi ketika kita mengeload suatu table dari database, database hanya akan mengeload hanya sesuatu yang kita butuhkan (misal .getNama()).
CascadeType.ALL ketika terjadi sesuatu pada suatu entitas, maka entitas yang terferensi oleh entitas tersebut akan ikut mengalami kejadian yang sama (misal X di delete, maka entitas lain yang tereferensi oleh X juga ikut di delete).
FetchType.EAGER berfungsi ketika kita mengeload suatu table dari database, database akan mengeload secara EAGER semua yang ada pada tabel tersebut.




## Tutorial 4
1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
anda menyelesaikan latihan nomor 2.
membuat navbar menjadi dimanis sesuai dengan navbar title HTML. pertama saya membuat variable baru sebagai penanda title di fragment,
di fragment diberikan default "navbar" jika tidak ada title dan jika ada navbar title penamaan sesuai dengan nama title.
nama title tersebut di control setiap method, dengan menambahkan attribut untuk navbar title yang akan dirender ke HTML
2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 3
pertama saya harus menyesuaikan template form-add-menu.html sesuai kebutuhan dan di dalam form-add-menu.html juga saya melooping inputan.
Kemudian membuat button delete dan addRow yang akan mengeksekusi sesuai method di menuController.
di menu controller, saya mengubah addProductFormPage agar bisa ditambahkan banyak maka saya buat list menu sebagai penampung menu yang akan disubmit.
di controller juga membuat addRow dan deleteRow serta addSubmitMenu untuk mengirimkan semua listMenu ke HTML addMenu.  
3. Jelaskan perbedaan th:include dan th:replace
th: replace - Menggantikan host tag dengan fragmen. Sehingga, akan menghapus host tag dan sebagai penggantinya akan menambahkan fragmen yang ditentukan termasuk attibut yang muncul di HTML.
th: include - Memasukkan fragmen yang ditentukan sebagai body dari tag hostnya tetapi tidak termasuk attribut yang muncul di HTML.
4. Jelaskan bagaimana penggunaan th:object beserta tujuannya
thymeleaf memberikan fungsi-fungsi khusus yang hanya dengan menggunakan attribut dalam HTML yang nantinya setelah di jalankan di server datanya akan diolah dan ditampilkan sesuai dengan real datanya.
th:object memiliki banyak fungsi, pemilihan "object" bergantung dengan keperluan dan tujuannya.
antara lain :text untuk menampilkan text, include replace dan insert untuk mengoperasikan fragmen, action untuk memindah/menghubungkan ke HTML lainnya, style untuk mengubah gaya, value dan lainnya.



## Tutorial 5
1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and then.
Bagian given berupa inisiasi dummyRestoran, men-set attribut-attribut dari dummy tersebut dan mengatur kembalian database ketika menggunakan service.
Bagian when berupa pemanggilan mockMvc.perform(get("/restoran/view?idRestorn=1")) yang akan berinteraksi dengan controller langsung dan mengembalikan halaman berdasarkan controller.
Bagian and then berupa pemanggilan method .andExpect(...) yang berfungsi untuk melakukan pengecekan interaksi yang diharapkan.
2. Jelaskan perbedaan line coverage dan logic coverage.
line coverage hanya meng-cover kode dengan menghitung jumlah line saja berdasarkan kode yang yang diuji saat testing.
logic coverage meng-handle logic code yang berupa branching (seperti if else), sehingga nantinya logic coverage dapat membantu penambahan line coverage secara keseluruhan.
3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa
seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin terjadi?
unit test terlebih dahulu baru melakukan implementasi code dari apa yang sudah di test.
Hal tersebut dilakukan agar meminimalisir error, serta berfungsi untuk membuat gambaran dan batasan code yang akan diimplementasikan.
Jika urutannya dibalik, maka resiko untuk terjadi error meningkat, dan (mungkin) baru diketahui pada saat fase testing, dimana hal tersebut sangat tidak efisien dan memakan waktu.
4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam
perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari
perhitungan code coverage
Karena main class method merupakan class yang tidak dihitung coverage nya, sehingga akan mengganggu skor akhir dari penghitungan coverage.
Hal-hal yang dapat menyebabkan di exlude antara lain file built-in , file yang mempunyai code coverage rendah dan akan menimbukan kerusakan coverage secara keseluruhan dan serta file configurasi yang tidak terdapat bisnis proses didalamnya.


Coverage di Menu Service
<a href="https://ibb.co/Kh4pqg9"><img src="https://i.ibb.co/Kh4pqg9/saa.png" alt="saa" border="0"></a>

Coverage sebelum latihan 2 dikerjakan dan setelah dikerjakan
<a href="https://ibb.co/8DJ8yrj"><img src="https://i.ibb.co/8DJ8yrj/controller.png" alt="controller" border="0"></a>
<a href="https://ibb.co/Czt52B8"><img src="https://i.ibb.co/Czt52B8/controller-setelah.png" alt="controller-setelah" border="0"></a>






## Tutorial 6
1. Apa itu postman? Apa kegunaan dari postman?
sebuah aplikasi (berupa plugin) untuk browser chrome, 
fungsinya adalah sebagai REST Client atau aplikasi yang digunakan untuk melakukan uji coba REST API yang telah kita buat.
agar bisa mengakses tanpa membuat terlebih dahulu sistem yang menerima API dari kita.
2. Apa kegunaan dari annotation @JsonIgnoreProperties?
untuk menentukan properties yang akan diabaikan ketika dibaca oleh JSON
3. Apa itu ResponseEntity dan apa kegunaannya?
ResponseEntity dapat mewakili HTTP response yang termasuk header, body, dan status. Sehingga dapat digunakan untuk mengkonfigurasi response HTTP sepenuhnya.






## Tutorial 7
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi ! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?
otentikasi adalah proses memeriksa detail pengguna untuk mengidentifikasinya dan memberikan akses ke sistem.
otorisasi adalah proses memeriksa hak akses user yang diotentikasi untuk mengakses resource suatu sistem.
Otentikasi dan otorisasi adalah dua mekanisme yang digunakan dalam sistem ini untuk mengamankan informasi.
Otentikasi digunakan untuk mengidentifikasi user tertentu agar dapat mengakses sistem. Setelah mengautentikasi user ke sistem, otorisasi memberikan batasan yang diperlukan dan mengakses yang dimiliki user.

2. Apa itu BCryptPasswordEncoder ? Jelaskan secara singkat cara kerjanya!
BCryptPasswordEncoder adalah salah satu tool yang digunakan untuk melakukan encode terhadap password yang ada di Spring. Jadi untuk kepentingan Security,
suatu password tidak boleh disimpan dalam bentuk plain. Sehingga perlu di encode dengan memanfaatkan hashing. 
Cara penggunaannya adalah dengan membuat objek BCryptPasswordEncoder, lalu objek tersebut dipanggil 
dan menggunakan method encode untuk melakukan encode terhadap password tersebut

3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java ?
universally unique identifier (UUID) adalah kumpulan 32 karakter (String) yang dibuat secara acak (random) dengan teknik khusus yang dijamin unik untuk setiap data.
Dalam waktu 1 detik pun, jika di-generate 1000 UUID, kecil kemungkinan ada UUID yang sama.
Sehingga lebih cocok untuk digunakan sebagai Primary Key. Sehingga pada UserModel.java memakai UUID untuk keunikan antar user dan juga keamanan.
UUID tersebut tentu saja sulit ditebak oleh pengguna karena tidak mempunyai pola khusus.
Jika ada hacker yang ingin menggunakan program looping untuk mendapatkan seluruh data User, maka dia perlu membuat banyak kombinasi 32 karakter tersebut, tentu tidak mudah dan membutuhkan waktu lama.

4. Apa kegunaan class UserDetailsServiceImpl.java ? Mengapa harus ada class tersebut
padahal kita sudah memiliki class UserRoleServiceImpl.java?
untuk membatasi atau memberikan hak akses suatu role terharap resource/layanan di dalam sistem.
UserDetailsServiceImpl.java berguna untuk membangun autentikasi user. didalam class ini dilakukan extends terhadap UserServiceDetail dari spring security.
Class ini akan menghasilkan UserDetail object yang akan memberikan informasi terkait user yang terdapat dari db
dan juga memberikan otorisasi yang dimiliki user sesuai dengan role yang dimiliki. Sedangkan UserServiceImpl digunakan untuk mengatur mapping yang dilakukan user

