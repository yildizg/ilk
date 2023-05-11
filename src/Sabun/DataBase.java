package Sabun;

import java.util.*;

public interface DataBase {

    List<PojoClass> urun=new ArrayList<PojoClass>();
    List<Calisan>calisan=new ArrayList<>();
    List<PojoClass> sepet= new ArrayList<>();
    Map<Kategori,PojoClass> urunIdMap = new HashMap<>();
    Scanner input = new Scanner(System.in);
}