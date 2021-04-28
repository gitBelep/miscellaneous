package gyak;

public enum Napok {

    HETF("eso",1), KEDD("napos",2), SZOMB("*", 6), VAS("templomi",7);

    private String idojaras;
    private final int sorszam;

    Napok(String idojaras, int sorszam){
        this.idojaras = idojaras;
        this.sorszam = sorszam;
    }

    public String getIdojaras() {
        return idojaras;
    }

    public int getSorszam() {
        return sorszam;
    }
}
