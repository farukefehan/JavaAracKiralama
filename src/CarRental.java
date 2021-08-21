import java.util.ArrayList;
import java.util.List;

public class CarRental {

    public static List<String> aracMarka =new ArrayList();
    public static List<String> aracModel =new ArrayList();
    public static List<Integer>aracYil=new ArrayList();
    public static List<Double> aracFiyatlari=new ArrayList();
    public static List<Integer>aracKm=new ArrayList();
    public static List<String> sepettekiAracMarka =new ArrayList();
    public static List<String> sepettekiAracModel =new ArrayList();
    public static List<Integer>sepettekiAracYil=new ArrayList();
    public static List<Double> sepettekiAracFiyatlari=new ArrayList();
    public static List<Integer> sepettekiAracKm=new ArrayList();
    private String admin="admin";
    private String sifre = "1453";

    CarRental(){

    }
    /* Encapsulation yaparak korudugum sifreme ve admin kullanici adima main class'ta kullanicinin admin olup
       olmadiginbi kontrol edebilmek icin getter method'u ekliyorum.
       Setter method'u eklemeyecegim cunku admin kullanici adimda ve sifremde degisiklik yapilmasini istemiyorum(immutable)
     */
    public String getAdmin() {
        return admin;
    }


    public String getSifre() {
        return sifre;
    }



    public void araclariListele(){
        System.out.println("NO\tMARKA\t\tMODEL\t\tYIL\t\tKM\t\tGUNLUK FIYAT");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

        for (int i = 0; i< aracMarka.size(); i++) {

            System.out.println(i+"\t"+ aracMarka.get(i)+"\t\t"+ aracModel.get(i)+"\t\t"+aracYil.get(i)+"\t\t"+aracKm.get(i)
                    +"\t\t"+"$"+aracFiyatlari.get(i));
        }
    }
    public double secilenAraclar(){
        double toplamTutar=0;
        System.out.println("NO\tMARKA\t\tMODEL\t\tYIL\t\t\tKM\t\tFIYAT");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        for (int i = 0; i< sepettekiAracMarka.size(); i++) {

            System.out.println(i+"\t"+ sepettekiAracMarka.get(i)+"\t\t"+ sepettekiAracModel.get(i)+"\t\t"+sepettekiAracYil.get(i)
                    +"\t\t"+sepettekiAracKm.get(i) +"\t\t"+"$"+sepettekiAracFiyatlari.get(i));
            toplamTutar+=sepettekiAracFiyatlari.get(i);
        }
        return toplamTutar;


    }
    public void sepeteAracEkle(int urunNo, int gunSayisi){
        sepettekiAracMarka.add(aracMarka.get(urunNo));
        sepettekiAracModel.add(aracModel.get(urunNo));
        sepettekiAracYil.add(aracYil.get(urunNo));
        sepettekiAracKm.add(aracKm.get(urunNo));
        sepettekiAracFiyatlari.add(aracFiyatlari.get(urunNo)*gunSayisi);




    }



}
