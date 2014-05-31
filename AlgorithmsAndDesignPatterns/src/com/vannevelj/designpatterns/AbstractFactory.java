package com.vannevelj.designpatterns;

public class AbstractFactory {

}

abstract class VehicleFactory {
    protected abstract Vehicle createVehicle();
}

class PlaneFactoy extends VehicleFactory {
    @Override
    protected Vehicle createVehicle() {
        return new Plane();
    }
}

class CarFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle() {
        return new Car();
    }
}

abstract class Vehicle {
    abstract void move();
}

class Plane extends Vehicle {
    @Override
    void move() {
        System.out.println("roaaaaaar");
    }
}

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("vrooooom");
    }
}
