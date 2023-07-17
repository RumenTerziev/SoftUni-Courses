package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.constants.DayOfWeek;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findFirstByCityAndDayOfWeek(City city, DayOfWeek dayOfWeek);

    List<Forecast> findAllByDayOfWeekLikeAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek dayOfWeek, Integer city_population);
}
