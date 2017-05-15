package br.univali.sisnet.autonomy.domain.GasStation;


public class GasStation {

    private long id;
    private String name;
    private String logo;

    public GasStation(String name) {
        this.name = name;
    }

    public GasStation(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
