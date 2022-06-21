package com.CarRental.Car;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class CarPriceEstimator {
    private Car car;

    CarPriceEstimator(Car car) {
        this.car = car;
    }

    public BigDecimal EstimateRentalPriceOneDay() {
        BigDecimal result;

        switch (car.getCarType()) {
            case KOMBI : result = new BigDecimal(10);
                break;
            case SUV:  result = new BigDecimal(20);
                break;
            case VAN:  result = new BigDecimal(30);
                break;
            default: throw new IllegalArgumentException();
        }

        switch (car.getCategoryType()) {
            case SMALL :
                break;
            case MID: result = result.multiply(BigDecimal.valueOf(1.5));
                break;
            case VIP: result = result.multiply(BigDecimal.valueOf(2.5));
                break;
            default: throw new IllegalArgumentException();
        }
        return result;
    }

    public BigDecimal EstimatePriceForRenting() {
        return EstimateRentalPriceOneDay()
                .multiply(BigDecimal.valueOf(ChronoUnit.DAYS.between(car.getDate(), LocalDate.now())));
    }
}
