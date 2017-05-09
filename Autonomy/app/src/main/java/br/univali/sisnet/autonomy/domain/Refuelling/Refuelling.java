package br.univali.sisnet.autonomy.domain.Refuelling;


import java.util.Calendar;

import br.univali.sisnet.autonomy.domain.GasStation.GasStation;

public class Refuelling {

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

}
