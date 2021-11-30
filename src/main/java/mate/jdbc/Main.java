package mate.jdbc;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.models.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        Manufacturer firstCar = new Manufacturer("Hyundai Elantra", "South Korea");
        Manufacturer secondCar = firstCar;
        manufacturerDao.create(secondCar);
        manufacturerDao.create(firstCar);
        System.out.println(manufacturerDao.get(firstCar.getId()));
        System.out.println(manufacturerDao.getAll());
        firstCar.setName("Hyundai Tucson");
        manufacturerDao.update(firstCar);
        manufacturerDao.delete(firstCar.getId());
    }
}
