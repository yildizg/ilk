package Sabun;

public class PojoClass implements DataBase {


    private int id;
    private String urunIsmi;
    private String ureticiName;
    private int miktar;
    private Kategori birim;
    private int raf;
    private double fiyat;

    public PojoClass(int id, String urunIsmi, String ureticiName, int miktar, Kategori birim, Kategori raf, double fiyat) {

        this.id=id;
        this.urunIsmi = urunIsmi;
        this.ureticiName = ureticiName;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf.getRaf();
        this.fiyat=fiyat;


    }
    public PojoClass() {

    }

    public PojoClass(int id) {
        this.id = id;
    }

    public void printListe() {
        for (PojoClass e : urun) {
            System.out.println(e);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUreticiName() {
        return ureticiName;
    }

    public void setUreticiName(String ureticiName) {
        this.ureticiName = ureticiName;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public Kategori getBirim() {
        return birim;
    }

    public void setBirim(Kategori birim) {
        this.birim = birim;
    }

    public int getRaf() {
        return raf;
    }

    public void setRaf(int raf) {
        this.raf = raf;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Ürün Id = "+ id + ", Ürün Adi = " + urunIsmi +", Üretici Firma = " + ureticiName + ", Miktar = " + miktar +
                ", Kategori = " + birim + ", Raf = " + raf + ", Fiyat = " + fiyat +"\n";
    }
}