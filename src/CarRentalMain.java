import java.util.Arrays;
import java.util.Scanner;

public class CarRentalMain {
    static Scanner scan = new Scanner(System.in);
    static int dummyCount=0;// dummy olayini engellemek icin sayacim

    
    public static void main(String[] args) {


        System.out.println("En guzel gunlerinizde Java arac kiralama yaninizda!");
        System.out.println("        _______\r\n"
                + "       //  ||\\ \\\r\n"
                + " _____//___||_\\ \\___\r\n"
                + " )  _          _    \\\r\n"
                + " |_/ \\________/ \\___|\r\n"
                + "___\\_/________\\_/______");
        System.out.println("---------------------------------------------------------------------------------------------------------\n\n");
        
        /*
        Stogumuza arac ekleyecegim adminimiz arac eklemez ise arac listemiz bos kalmasin :)
         */
        CarRental.aracMarka.addAll(Arrays.asList("Ford", "Honda", "Tesla"));// AHAN DA TRICK Arrays.asList ile uzun uzun yazmayi engelledik
        CarRental.aracModel.addAll(Arrays.asList("Ranger", "Civic", "ModelS"));
        CarRental.aracYil.addAll(Arrays.asList(2021, 2015, 2021));
        CarRental.aracKm.addAll(Arrays.asList(5000, 65000, 1239));
        CarRental.aracFiyatlari.addAll(Arrays.asList(110.0, 50.0, 250.0));



        System.out.println("Java arac kiralama'ya hos geldiniz, lutfen size uyan secenegi giriniz...\n1-Admin girisi\n2-Musteri\n3-Cikis\n");
        int secim = scan.nextInt();
        scan.nextLine();




            while (secim != 1 && secim != 2 && secim!=3) {
                System.out.println("-------------------------------------------");

                System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

                System.out.println("-------------------------------------------\n\n");
                System.out.println("Lutfen hangi kategorideyseniz isaretleyiniz..\n1-Admin girisi\n2-Musteri girisi\n3-Cikis");
                secim = scan.nextInt();
            }
            if (secim == 1) {
                adminGiris();
            } else if (secim == 2) {
                musteriGiris();

            }else if(secim == 3){
                cikis();
            }











    }

    private static void cikis() {
        System.out.println("-------------------------------------------");

        System.out.println("Cikis yapiliyor...\nBizi tercih ettiginiz icin tesekkur ederiz");

        System.out.println("-------------------------------------------\n\n");

    }

    private static void musteriGiris() {
        dummyCount++;

        CarRental arac = new CarRental();
        System.out.println("\nArac kiralama icin dogru adrestesiniz :)\n");
        System.out.println("Lutfen yapmak istediginiz islemi seciniz...\n1-Araclara goz at\n2-Admin girisi\n3-Cikis");
        int secim3 = scan.nextInt();
        while (secim3 != 1 && secim3 != 2 && secim3!=3) {
            System.out.println("-------------------------------------------");

            System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

            System.out.println("-------------------------------------------\n\n");
            System.out.println("Lutfen hangi islemi yapmak istiyorsani onu isaretleyiniz...\n1-Araclara goz at\n2-Admin girisi\n3-Cikis");
            secim3 = scan.nextInt();
            scan.nextLine();
        }
        if (secim3 == 1) {
            String devam;
            double toplam;
            do {
                arac.araclariListele();
                System.out.println("Lutfen kiralamak istediginiz aracin numarasini giriniz...");
                int aracNo = scan.nextInt();
                System.out.println("Guzel secim, kac gun kiralamak istersiniz");
                int gunSayisi = scan.nextInt();
                arac.sepeteAracEkle(aracNo,gunSayisi);
                toplam=arac.secilenAraclar();
                System.out.println();
                System.out.println("devam etmek istiyor musunuz(E/H)");
                devam=scan.next();
            }while (devam.equalsIgnoreCase("E"));
            
            odeme(toplam);



        } else if (secim3 == 2) {
            adminGiris();

        }else if(secim3 == 3){
            cikis();
        }


    }

    private static void odeme(double toplam) {
        System.out.println("--------------------------------------------");
        System.out.println("Odemeniz gereken Tutar= $"+toplam);
        System.out.println("------------------------------------------");
        System.out.println("Odeme yapmak icin herhangi bir tusa basiniz...");
        String secim4 = scan.next();

            System.out.println("Odemeniz gayet basarili yine bekleriz :)\n\n");
            cikis();

    }

    private static void adminGiris() {
        if (dummyCount>0){
            scan.nextLine();
        }
        CarRental arac = new CarRental();
        System.out.println("Admin paneline hos geldin !\n\n");
        String sifre ="";// while sartimda kullanmak icin initalize ediyorum bunun ne atadigimin onemi yok while sartimda atama yapiyorum zaten.
        String admin ="";
        int secim3 = 0;
        int count = 5; // Kullanicima 5 tane deneme hakki veriyorum.


        do {


            System.out.println("Lutfen giris icin kullanici adinizi giriniz...");

            admin = scan.nextLine();

            System.out.println("Lutfen sifrenizi giriniz...");
            sifre = scan.nextLine();
            if (((!sifre.equals(arac.getSifre()))  || (!admin.equals(arac.getAdmin())) )) {
                count--;
                if (count == 0){
                    System.out.println("5 Yanlis tuslama yaptiniz !\nDeneme hakkiniz kalmadi sistemden atiliyorsunuz !");
                    cikis();
                }else {
                    System.out.println("Yanlis tuslama yaptiniz lutfen tekrar deneyiniz !\nKalan deneme hakkiniz --> " + count);
                }

            }

        }while ((((!sifre.equals(arac.getSifre()))  || (!admin.equals(arac.getAdmin())) ) && count !=0));
        // kodumuz buraya gelirse kullanici adini ve sifreyi dogru girmis demektir.
        System.out.println("\n--------------------------------------------------");
        System.out.println("Sisteme girisiniz gayet basarili guzel insan :)");
        System.out.println("--------------------------------------------------\n");

        System.out.println("Lutfen yapmak istediginiz islemi seciniz...\n1-Arac ekle\n2-Onizleme(Musteri giris)\n3-Cikis");
        int secim2 = scan.nextInt();
        scan.nextLine();
        while (secim2 != 1 && secim2 != 2 && secim2!=3) {
            System.out.println("-------------------------------------------");

            System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

            System.out.println("-------------------------------------------\n\n");
            System.out.println("Lutfen hangi islemi yapmak istiyorsani onu isaretleyiniz...\n1-Arac ekle\n2-Onizleme(Musteri giris)\n3-Cikis");
            secim2 = scan.nextInt();
        }

        if (secim2 == 1) {
            String devamMi;
            do {
                System.out.println("Arac ekleme bolumdesiniz !\n");
                System.out.println("Lutfen aracin markasini giriniz...");
                CarRental.aracMarka.add(scan.nextLine());
                System.out.println("Lutfen aracin modelini giriniz...");
                CarRental.aracModel.add(scan.nextLine());
                System.out.println("Lutfen aracin yilini giriniz...");
                CarRental.aracYil.add(scan.nextInt());
                System.out.println("Lutfen aracin kilometresini giriniz...");
                CarRental.aracKm.add(scan.nextInt());
                System.out.println("Lutfen aracin gunluk fiyatini giriniz($)...");
                CarRental.aracFiyatlari.add(scan.nextDouble());
                System.out.println("\nArac ekleme tamamlandi !\nDevam etmek istiyor musunuz? Evet icin 'E' Hayir icin 'H'");
                devamMi = scan.next();
                scan.nextLine();

            }while (devamMi.equalsIgnoreCase("E"));
            System.out.println("\nArac eklemeden basariyla cikildi\n\nLutfen yapmak istediginiz islemi seciniz...\n1-Onizleme(Musteri giris)\n2-Cikis");
            secim3 = scan.nextInt();

            while (secim3 != 1 && secim3 != 2) {
                System.out.println("-------------------------------------------");

                System.out.println("Yanlis tuslama yaptiniz tekrar deneyiniz!");

                System.out.println("-------------------------------------------\n\n");
                System.out.println("Lutfen hangi islemi yapmak istiyorsani onu isaretleyiniz...\n1-Arac ekle\n2-Onizleme(Musteri giris)\n3-Cikis");
                secim3 = scan.nextInt();
            }


        } if (secim2 == 2 || secim3 == 1  ) {
            musteriGiris();

        }if(secim2 == 3 || secim3 ==2){
            cikis();
        }


    }
}
