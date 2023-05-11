package Sabun;

public enum Kategori {
    VUCUT(1),
    EL(2),
    YUZ(3),
    CAMASIR(4);

    private int raf;

    Kategori(int rafNo){
        this.raf = rafNo;
    }

    public int getRaf() {
        return raf;
    }

}
