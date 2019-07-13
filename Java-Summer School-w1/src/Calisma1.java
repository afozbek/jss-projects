import com.obss.araba.Araba;
import com.obss.pojo.Pojo;

public class Calisma1 {

    public static void main(String[] args) {

        for(String argument : args ){
            System.out.println("Argument : " + argument );
        }

        if(args[0].equals("exit")){
            System.out.println("If icine girdik.");
            System.exit(0);
        }

        String firstName = "OBSS";
        String middleName = "Software";

        Pojo nesne = new Pojo();
        nesne.setId("1");
        nesne.setSayi(23);

        Araba bmw = new Araba();
        bmw.setHiz(23);
        bmw.setMarka("bmw");


        Araba araba = new Araba();

        Object x = new String("object type");
        System.out.println(x);

        final int sonDeger = 5;
    }
}
