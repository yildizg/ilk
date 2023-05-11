package Sabun;

public class Musteri implements DataBase, Musteri_Islemleri {

    public void musteri(){
        System.out.println();
        System.out.println( "************ MÜSTERI ISLEMLERI ************\n\n" +
                            "1- Ürün Listeleme\n"+
                            "2- Ürün Satin Alma\n"+
                            "3- Ürun Arama\n"+
                            "4- Sepet Görüntüleme\n"+
                            "5- Ana Menu\n");

        System.out.print("Seciminiz : ");



        int secim=input.nextInt();
        switch (secim){
            case 1:
                urunListele();
                musteri();
                break;
            case 2:
                urunSatinAlma();
                musteri();
                break;
            case 3:
                urunArama();// sadece id ler listesi olmuyor
                musteri();
                break;
            case 4:
                sepetGoruntuleme();
                musteri();
                break;
            case 5:
                giris();
                break;
            default:
                System.out.println("hatali tuslama yaptin tekrar dene");
                musteri();
                break;
        }

    }
    @Override
    public void urunListele() {

//        PojoClass obj = new PojoClass();
//        obj.printListe();
       Calisan calisan = new Calisan();
       calisan.urunListeleme();

    }

    @Override
    public void urunSatinAlma() {
        urunListele();
        System.out.println("hangi urunu almak istiyorsun id sini gir ");
        int secilenUrun= input.nextInt();
        boolean flag=true;
        for (PojoClass b:urun) {
            if (b.getId()==secilenUrun){
                System.out.println(b.getId()+" "+b.getUrunIsmi());
                DataBase.sepet.add(b);
                flag=false;
                break;
            }
        }
        if (flag) System.out.println("istenen urun bulunamadi");

    }

    @Override
    public void urunArama() {
        urunListele();
        System.out.println("aradigin urunun id sini listeden sec");
        int secim= input.nextInt();
        for (PojoClass e:urun) {
            if (e.getId()==secim){
                System.out.println("aranan urun listede mevcut"+" "+e.getUrunIsmi()+" "+e.getRaf()+" numarali rafta");
                break;
            }else System.out.println("aranan urun listede bulunamadi");
            break;
        }
    }

    @Override
    public void sepetGoruntuleme() {
        System.out.println(DataBase.sepet);
    }

    @Override
    public void giris() {
       Giris_Menusu giris = new Giris_Menusu();
        giris.giris();

    }

}