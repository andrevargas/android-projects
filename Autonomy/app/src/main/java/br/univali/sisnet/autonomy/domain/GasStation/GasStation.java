package br.univali.sisnet.autonomy.domain.GasStation;


import java.io.Serializable;

public class GasStation implements Serializable {

    private static final long serialVersionUID = 5164328947766190832L;

    private final long id;
    private final String name;
    private final String logoSrc;

    public GasStation(long id, String name, String logoSrc) {
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

    public String getLogoSrc() {
        return logoSrc;
    }

}
