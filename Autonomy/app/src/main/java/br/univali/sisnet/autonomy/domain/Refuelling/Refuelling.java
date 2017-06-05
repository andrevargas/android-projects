package br.univali.sisnet.autonomy.domain.Refuelling;


import java.io.Serializable;
import java.util.Calendar;

import br.univali.sisnet.autonomy.domain.GasStation.GasStation;

public class Refuelling implements Serializable {

    private static final long serialVersionUID = 2582233106362806851L;

    private long id;
    private double currentMileage;
    private double litersRefuelled;
    private Calendar refuellingDate;
    private GasStation gasStation;

    public double getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(double currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getLitersRefuelled() {
        return litersRefuelled;
    }

    public void setLitersRefuelled(double litersRefuelled) {
        this.litersRefuelled = litersRefuelled;
    }

    public Calendar getRefuellingDate() {
        return refuellingDate;
    }

    public void setRefuellingDate(Calendar refuellingDate) {
        this.refuellingDate = refuellingDate;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
