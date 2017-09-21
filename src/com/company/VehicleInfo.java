package com.company;

public class VehicleInfo {
    int _VIN;
    double odometer;
    double consumption;
    double odometerAtLastOilChange;
    double engineSizeInLiters;

    public VehicleInfo() {

    }

    public int get_VIN() {
        return _VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getOdometerAtLastOilChange() {
        return odometerAtLastOilChange;
    }

    public double getEngineSizeInLiters() {
        return engineSizeInLiters;
    }

    public void set_VIN(int _VIN) {
        this._VIN = _VIN;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setOdometerAtLastOilChange(double odometerAtLastOilChange) {
        this.odometerAtLastOilChange = odometerAtLastOilChange;
    }

    public void setEngineSizeInLiters(double engineSizeInLiters) {
        this.engineSizeInLiters = engineSizeInLiters;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "_VIN=" + _VIN +
                ", odometer=" + odometer +
                ", consumption=" + consumption +
                ", odometerAtLastOilChange=" + odometerAtLastOilChange +
                ", engineSizeInLiters=" + engineSizeInLiters +
                '}';
    }
}

