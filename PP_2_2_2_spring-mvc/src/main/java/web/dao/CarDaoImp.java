package web.dao;

import web.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {
    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Car1", 2011, 400_000.00));
        carList.add(new Car("Car2", 2014, 550_000.00));
        carList.add(new Car("Car3", 2016, 700_000.00));
        carList.add(new Car("Car4", 2019, 950_000.00));
        carList.add(new Car("Car5", 2021, 1_100_000.0));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0 || count >= 5) {
            return carList;
        }

        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
