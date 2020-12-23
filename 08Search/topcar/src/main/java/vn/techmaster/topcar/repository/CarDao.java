package vn.techmaster.topcar.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.util.ResourceUtils;

import vn.techmaster.topcar.model.Car;

public class CarDao extends Dao<Car> {
    

    public CarDao(String csvFile) {
        this.readCSV(csvFile);
    }

    @Override
    public List<Car> getALL() {
        return collections;
    }

    @Override
    public Optional<Car> get(int id) {
        return collections.stream().filter(car -> car.getId() == id).findFirst();
    }

    @Override
    public void add(Car car) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Car lastCar = collections.get(collections.size() - 1);
            id = lastCar.getId() + 1;
        }
        car.setId(id);
        collections.add(car);
    }

    @Override
    public void update(Car car) {
        get(car.getId()).ifPresent(existCar -> {
            existCar.setModel(car.getModel());
            existCar.setManufacturer(car.getManufacturer());
            existCar.setPrice(car.getPrice());
            existCar.setSales(car.getSales());
            existCar.setPhoto(car.getPhoto());
        });

    }

    @Override
    public void deleteByID(int id) {
        get(id).ifPresent(existCar -> collections.remove(existCar));
    }

    @Override
    public void delete(Car car) {
        deleteByID(car.getId());
    }

    @Override
    public void readCSV(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper(); // Dùng để ánh xạ cột trong CSV với từng trường trong POJO
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(','); // Dòng đầu tiên sử dụng làm Header
            ObjectReader oReader = mapper.readerFor(Car.class).with(schema); // Cấu hình bộ đọc CSV phù hợp với kiểu
            Reader reader = new FileReader(file);
            MappingIterator<Car> mi = oReader.readValues(reader); // Iterator đọc từng dòng trong file
            while (mi.hasNext()) {
              Car car = mi.next();
              this.add(car);
            }
          } catch (IOException e) {
            System.out.println(e);   
          }
    }

    @Override
    public List<Car> searchByKeyword(String keyword) {
        return collections.stream().filter(car -> car.matchWithKeyword(keyword)).collect(Collectors.toList());
    }

}
