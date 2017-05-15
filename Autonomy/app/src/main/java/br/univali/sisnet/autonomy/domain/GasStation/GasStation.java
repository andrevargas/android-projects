package br.univali.sisnet.autonomy.domain.GasStation;


public class GasStation {

    private final long id;
    private final String name;
    private final int logoSrc;

    public GasStation(long id, String name, int logoSrc) {
        this.id = id;
        this.name = name;
        this.logoSrc = logoSrc;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLogoSrc() {
        return logoSrc;
    }

}
