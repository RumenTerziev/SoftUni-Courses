package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private int countSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {


        Discoverer discoverer;

        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }


        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);

    }

    @Override
    public String addSpot(String spotName, String... exhibitsToAdd) {


        Spot spot = new SpotImpl(spotName);
        for (String exhibitToAdd : exhibitsToAdd) {
            spot.getExhibits().add(exhibitToAdd);
        }

        spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {


        Discoverer discoverer = discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        discovererRepository.remove(discoverer);
        return String.format(DISCOVERER_EXCLUDE, discovererName);

    }

    @Override
    public String inspectSpot(String spotName) {


        List<Discoverer> suitableDiscoverers = discovererRepository.getCollection().
                stream().
                filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (suitableDiscoverers.size() == 0) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }


        Spot spot = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, suitableDiscoverers);

        long countExhaustedDiscoverers = suitableDiscoverers.stream().
                filter(discoverer -> discoverer.getEnergy() == 0).count();


        countSpots++;
        return String.format(INSPECT_SPOT, spotName, countExhaustedDiscoverers);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_SPOT_INSPECT, countSpots)).append(System.lineSeparator()).
                append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());

        Collection<Discoverer> discoverers = discovererRepository.getCollection();

        for (Discoverer discoverer : discoverers) {
            sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator()).
                    append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());


            Collection<String> exhibitsOutput = discoverer.getMuseum().getExhibits();

            if (exhibitsOutput.isEmpty()) {
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                String outputStrings = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, exhibitsOutput);
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, outputStrings)).append(System.lineSeparator());
            }

        }

        return sb.toString();
    }
}
