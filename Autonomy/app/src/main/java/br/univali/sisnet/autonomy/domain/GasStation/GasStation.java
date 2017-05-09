package br.univali.sisnet.autonomy.domain.GasStation;


public class GasStation {

    private final String name;
    private final String logo;

    public GasStation(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

}
