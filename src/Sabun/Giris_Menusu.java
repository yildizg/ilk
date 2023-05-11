package Sabun;

import java.util.Random;
import java.util.Scanner;

    public class Giris_Menusu {


        public void giris(){
            Scanner scanner = new Scanner(System.in);
            System.out.println();

            System.out.println("--- ZW Management Sistemine Hoşgeldiniz! ---\n");
            System.out.println("Lütfen aşağıdaki seçeneklerden birini seçin:\n");
            System.out.println("1. Müşteri Girişi");
            System.out.println("2. Çalışan Girişi");
            System.out.println("3. Günün Fırsatı");
            System.out.println("4. Cikis\n");

            System.out.print("Seçiminiz : ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    Musteri musteri = new Musteri();
                    musteri.musteri();
                    break;
                case 2:
                    Calisan calisan = new Calisan();
                    calisan.calisanlar();
                    break;
                case 3:
                    gununFirsati();
                    break;
                case 4:
                    cikis();
                    break;
                default:
                    System.out.println("Hatalı seçim yaptınız!");
                    break;
            }
        }


        public void gununFirsati() {
            String [] firsatlar= {"Bugünün fırsatı: %50 indirimli kokulu sabun","2 al 1 öde secenegi","50 Euroluk alisverisde kargo bugune özel ücretsiz"};

            Random rand = new Random();
            int randIndex = rand.nextInt(firsatlar.length);
            System.out.println("Bugünün fırsatı: " + firsatlar[randIndex]);
            giris();

        }
        public void cikis() {
            System.out.println("Cikis Yapiliyor");
            System.exit(0);
        }

}
