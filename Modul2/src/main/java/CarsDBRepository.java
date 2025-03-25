import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository{

    private JdbcUtils dbUtils;

    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        logger.traceEntry();
        Connection con=dbUtils.getConnection();
        List<Car> cars=new ArrayList<>();
        try(PreparedStatement preSmt=con.prepareStatement("select * from cars where manufacturer like ?")){
            preSmt.setString(1,"%"+manufacturerN+"%");
            try(ResultSet result=preSmt.executeQuery()){
                int id = result.getInt("id");
                String manufacturer = result.getString("manufacturer");
                String model = result.getString("model");
                int year = result.getInt("year");
                Car car = new Car(manufacturer, model, year);
                car.setId(id);
                cars.add(car);
            }
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error getting tasks "+e);
        }
        logger.traceExit(cars);
        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
        logger.traceEntry();
        Connection con=dbUtils.getConnection();
        List<Car> cars=new ArrayList<>();
        try(PreparedStatement preSmt=con.prepareStatement("select * from cars where year between ? and ?")){
            preSmt.setInt(1, min);
            preSmt.setInt(1, max);
            try(ResultSet result=preSmt.executeQuery()){
                int id = result.getInt("id");
                String manufacturer = result.getString("manufacturer");
                String model = result.getString("model");
                int year = result.getInt("year");
                Car car = new Car(manufacturer, model, year);
                car.setId(id);
                cars.add(car);
            }
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error getting tasks "+e);
        }
        logger.traceExit(cars);
        return cars;
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {}",elem);
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preSmt=con.prepareStatement("insert into cars (manufacturer, model, year) values (?,?,?)")){

            preSmt.setString(1,elem.getManufacturer());
            preSmt.setString(2,elem.getModel());
            preSmt.setInt(3,elem.getYear());
            int result = preSmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error saving task "+e);
        }
    }

    @Override
    public void update(Integer integer, Car elem) {
        logger.traceEntry("updating task {} with id {}",elem,integer);
        Connection con=dbUtils.getConnection();
        try(PreparedStatement preSmt=con.prepareStatement("update cars set manufacturer=?, model=?, year=? where id=?")){
            preSmt.setString(1,elem.getManufacturer());
            preSmt.setString(2,elem.getModel());
            preSmt.setInt(3,elem.getYear());
            preSmt.setInt(4,integer);
            int result = preSmt.executeUpdate();
            logger.trace("Updated {} instances", result);
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error updating task "+e);
        }
    }

    @Override
    public Iterable<Car> findAll() {
        logger.traceEntry();
        Connection con=dbUtils.getConnection();
        List<Car> cars=new ArrayList<>();
        try(PreparedStatement preSmt=con.prepareStatement("select * from cars")){
            try(ResultSet result=preSmt.executeQuery()){
                int id = result.getInt("id");
                String manufacturer = result.getString("manufacturer");
                String model = result.getString("model");
                int year = result.getInt("year");
                Car car = new Car(manufacturer, model, year);
                car.setId(id);
                cars.add(car);
            }
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error getting tasks "+e);
        }
        logger.traceExit(cars);
        return cars;
    }
}
