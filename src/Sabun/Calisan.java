package Sabun;

import java.util.Map;

public class Calisan implements DataBase, Calisan_Islemleri {

    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";


    static int id = 0;


    static {
        id++;
        PojoClass urun1 = new PojoClass(id, "SebaMed", "Seba", 150, Kategori.YUZ, Kategori.YUZ,12);
        urun.add(urun1);
        urunIdMap.put(Kategori.YUZ,urun1);

        id++;
        PojoClass urun2 = new PojoClass(id, "HaciSakir", "Haci", 100, Kategori.VUCUT, Kategori.VUCUT,25);
        urun.add(urun2);
        urunIdMap.put(Kategori.VUCUT,urun2);
    }

    //******************************************************************************************************************

    @Override
    public void calisanlar() {
        System.out.println();
        System.out.println("************ CALISAN ISLEMLERI ************\n\n" +
                "           1-Ürün Tanimlama\n" +
                "           2-Miktar güncelleme\n" +
                "           3-Raf Güncelleme\n" +
                "           4-Ürün Silme\n" +
                "           5-Ürün Listeleme\n" +
                "           6-Ürün Arama\n" +
                "           7-Ürün Indirimi Yapma\n" +
                "           8-Ana Menu\n");

        System.out.print("Seciminiz : ");


        int secim = 0;
        try {
            secim = input.nextInt();
        } catch (Exception e) {
            System.out.println("Yanlis tuslama yaptiniz");
            calisanlar();
        }

        switch (secim) {

            case 1:
                urunTanimlama();
                calisanlar();
                break;

            case 2:
                miktarGuncelleme();
                calisanlar();
                break;

            case 3:
                rafGuncelleme();
                calisanlar();
                break;

            case 4:
                urunSilme();
                calisanlar();
                break;

            case 5:
                urunListeleme();
                calisanlar();
                break;

            case 6:
                urunArama();
                calisanlar();
                break;

            case 7:
                indirimYapma();
                calisanlar();
                break;

            case 8:
                giris();
                break;

            default:
                System.out.println("Hatali Giris");
                calisanlar();
                break;
        }
    }

    //******************************************************************************************************************

    @Override
    public void urunTanimlama() {
        input.nextLine();
        id++;
        PojoClass urunEkle = new PojoClass(id);

        System.out.print("Ürün adini giriniz         : ");
        String urunAdi = input.nextLine();
        urunEkle.setUrunIsmi(urunAdi);

        System.out.print("Üretici Firmayi giriniz    : ");
        String ureticiName = input.nextLine();
        urunEkle.setUreticiName(ureticiName);

        System.out.print("Ürün miktarini giriniz     : ");
        int miktar = input.nextInt();
        urunEkle.setMiktar(miktar);

        System.out.print("Ürün kategorisini giriniz  : ");
        System.out.println();
        Kategori[] kategori = Kategori.values();
        for (int i = 0; i < kategori.length; i++) {
            System.out.printf("%d. %s\n", i + 1, kategori[i]);
        }
        int secim = input.nextInt();
        Kategori secilenKategori = kategori[secim - 1];
        urunEkle.setBirim(secilenKategori);

        System.out.print("Ürün rafini giriniz        : ");
        System.out.println();
        Kategori[] kategori2 = Kategori.values();
        for (int i = 0; i < kategori2.length; i++) {
            System.out.printf("%d. %s\n", i + 1, kategori2[i]);

        }

        int secim2 = input.nextInt();
        int raf = kategori2[secim2 - 1].getRaf();
        urunEkle.setRaf(raf);

        System.out.print("Ürün fiyatini giriniz : ");
        double fiyat = input.nextDouble();
        urunEkle.setFiyat(fiyat);

//        PojoClass urun3 = new PojoClass(id, urunAdi, ureticiName, miktar, secilenKategori, raf,fiyat);
//        urun.add(urun3);
        //id++;
        urun.add(urunEkle);
        urunIdMap.put(secilenKategori,urunEkle);
        System.out.println("Ürün basari ile eklendi..");
        System.out.print("Eklenen ürün = "+urunEkle);
        System.out.println();
    }


    //******************************************************************************************************************

    @Override
    public void miktarGuncelleme() {


        System.out.print("Ürün ID gir : ");
        int urunId = input.nextInt();

        for (PojoClass w : urun) {
            if (urunId == (w.getId())) {
                System.out.println("Ürün " + w.getUrunIsmi() + " 'dir");

                System.out.print("Miktari gir : ");
                int miktar = input.nextInt();

                if (miktar == w.getMiktar()) {
                    w.setMiktar(w.getMiktar());  // kullanici ayni miktari girerse ayni miktari set ettik yani degisen bir miktar olmadi
                } else w.setMiktar(miktar);       // kullanici farkli miktar girdiyse yeni miktar set edildi

                System.out.println("Miktar güncellemesi basari ile yapildi...\n" + w);

            }

        }

    }


    //******************************************************************************************************************

    @Override
    public void rafGuncelleme() {

        System.out.print("Ürün ID gir : ");
        int urunId = input.nextInt();

        for (PojoClass w : urun) {
            if (urunId == (w.getId())) {
                System.out.println("Ürün " + w.getUrunIsmi() + " 'dir");

                System.out.print("Yeni Ürün rafini giriniz        : ");

                System.out.println();
                Kategori[] kategori2 = Kategori.values();
                for (int i = 0; i < kategori2.length; i++) {
                    System.out.printf("%d. %s\n", i + 1, kategori2[i]);
                }
                int secim2 = input.nextInt();
                int raf = kategori2[secim2 - 1].getRaf();
                w.setRaf(raf);

                if (raf == w.getRaf()) {
                    w.setRaf(w.getRaf());  // kullanici ayni raf degerini girerse ayni rafi set ettik yani degisen bir raf degeri olmadi
                } else w.setRaf(raf);       // kullanici farkli raf degerini girdiyse yeni raf degeri set edildi

                System.out.println("Raf güncellemesi basari ile yapildi...\n" + w);

            }

        }

    }


    //******************************************************************************************************************

    @Override
    public void urunSilme() {

        boolean flag = true;

        System.out.print("Ürün ID gir : ");
        int urunId = input.nextInt();
        for (PojoClass w : urun) {
            if (urunId == (w.getId())) {
                System.out.println("Silinen Ürün  = " + w.getUrunIsmi());
                urun.remove(w);
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("Id si " + urunId + " olan bir ürün yoktur 404");
        System.out.println(urun);

    }


    //******************************************************************************************************************

    @Override
    public void urunListeleme() {
        System.out.println();

        System.out.println("---------- ÜRÜN LISTESI -------------");

        for (PojoClass w:urun) {
            System.out.println(w);
        }

        System.out.println("--------- Kategoriye göre Liste -----");
        for (Map.Entry<Kategori,PojoClass> w: urunIdMap.entrySet()) {
            System.out.println(w);
        }


    }

    //******************************************************************************************************************

    @Override
    public void urunArama() {
        System.out.println("Ürün arama Basliklari\n");
        System.out.println( "1- ID numrasina gore \n"+
                            "2- Turune gore\n "+
                            "3- Üretici Firma adina göre\n+" +
                            "4- Calisan Menu\n ");


        int secim= input.nextInt();


        switch (secim){
            case 1:
                input.nextLine();
                System.out.println("Aramak istediginiz urunun ID sini listeden seciniz");

                for (int i = 0; i < urun.size(); i++) {

                    System.out.println(urun.get(i).getId());

                }

                System.out.println("Aramak istedigin kitap ID gir");
                Integer iD=input.nextInt();
                boolean flag=true;
                for (PojoClass each:urun) {

                    if (iD==each.getId()) {
                        System.out.println("Urun bulundu. Aradiginiz urun: "+ each);
                        flag=false;
                    }
                }
                if (flag) System.out.println("404. Aradiginiz ID ile urun mecvcut degildir.");

                calisanlar();
                break;

            case 2:
                input.nextLine();
                System.out.println("Aramak istediginiz urunun turunu giriniz");
                String urunIsim=input.nextLine();
                boolean flag1=true;

                for (PojoClass each:urun) {
                    if (each.getUrunIsmi().equalsIgnoreCase(urunIsim)){
                        System.out.println("Urun bulundu. Aradiginiz urun: "+ each);
                        flag1=false;
                    }
                }
                if (flag1) System.out.println("404. Aradiginiz ad ile urun mecvcut degildir.");

                calisanlar();
                break;

            case 3:
                input.nextLine();
                flag=true;
                System.out.println("Aramak istediginiz urunun firma adini giriniz");
                String firmaUrun=input.nextLine();

                for (PojoClass each:urun) {
                    if (firmaUrun.equalsIgnoreCase(each.getUreticiName())){
                        System.out.println("Urun bulundu. Aradiginiz urun: "+ each);
                        flag=true;
                    }

                }
                if (!flag) System.out.println("404. Aradiginiz ad ile urun mecvcut degildir.");

                calisanlar();
                break;

            case 4:
                calisanlar();
                break;
            default:
                System.out.println("yanlis tuslama yaptiniz.");



        }

    }


    //******************************************************************************************************************

    @Override
    public void indirimYapma() {
        System.out.println("Gunun indirimi. Yapacaginiz 50€ uzeri alisveriste" +
                " %20 indirim de bizden.");

        double odenecekTutar=0;

        for (int i = 0; i < sepet.size(); i++) {

            odenecekTutar+=sepet.get(i).getFiyat();

            if(odenecekTutar>=50){

                double indirimliTutar=odenecekTutar*0.8;
                System.out.println("odenecek miktar = " + indirimliTutar);

            }else System.out.println("odenecek miktar = " + odenecekTutar);

        }


    }


    //******************************************************************************************************************

    @Override
    public void giris() {
        Giris_Menusu giris = new Giris_Menusu();
        giris.giris();
    }


}
