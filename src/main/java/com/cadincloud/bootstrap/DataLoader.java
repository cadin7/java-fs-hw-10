package com.cadincloud.bootstrap;

import com.cadincloud.model.entity.LocationEntity;
import com.cadincloud.model.entity.RouteEntity;
import com.cadincloud.model.entity.TrainEntity;
import com.cadincloud.repository.LocationRepository;
import com.cadincloud.repository.RouteRepository;
import com.cadincloud.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final TrainRepository trainRepository;
    private final RouteRepository routeRepository;
    private final LocationRepository locationRepository;

    @Override
    public void run(String... args) throws Exception {
//        final var locationEntities = saveLocations();
//        final var trainEntities = saveTrains(locationEntities);
//        saveRoutes(locationEntities, trainEntities);
    }

    private List<TrainEntity> saveTrains(List<LocationEntity> locationEntities) {
        final var trainsToSave = List.of(
                TrainEntity.builder()
                        .model("TGV")
                        .carts(10)
                        .locationId(locationEntities.get(4).getId())
                        .build(),
                TrainEntity.builder()
                        .model("TGV")
                        .carts(5)
                        .locationId(locationEntities.get(5).getId())
                        .build(),
                TrainEntity.builder()
                        .model("Zefiro Express")
                        .carts(15)
                        .locationId(locationEntities.get(1).getId())
                        .build(),
                TrainEntity.builder()
                        .model("Zefiro Express")
                        .carts(8)
                        .locationId(locationEntities.get(0).getId())
                        .build(),
                TrainEntity.builder()
                        .model("Baden IV h express")
                        .carts(13)
                        .locationId(locationEntities.get(3).getId())
                        .build()
        );
        return trainRepository.saveAll(trainsToSave);
    }

    private void saveRoutes(List<LocationEntity> locationEntities,
                            List<TrainEntity> trainEntities) {
        final var routesToSave = List.of(
                RouteEntity.builder()
                        .startLocationId(trainEntities.get(1).getLocationId())
                        .destinationLocationId(locationEntities.get(4).getId())
                        .length("X km")
                        .trainId(trainEntities.get(1).getId())
                        .build(),
                RouteEntity.builder()
                        .startLocationId(trainEntities.get(3).getLocationId())
                        .destinationLocationId(locationEntities.get(2).getId())
                        .length("Y km")
                        .trainId(trainEntities.get(3).getId())
                        .build(),
                RouteEntity.builder()
                        .startLocationId(trainEntities.get(0).getLocationId())
                        .destinationLocationId(locationEntities.get(0).getId())
                        .length("Z km")
                        .trainId(trainEntities.get(0).getId())
                        .build());
        routeRepository.saveAll(routesToSave);
    }

    private List<LocationEntity> saveLocations() {
        final var locationsToSave = List.of(
                LocationEntity.builder()
                        .city("Budapest")
                        .build(),
                LocationEntity.builder()
                        .city("Berlin")
                        .build(),
                LocationEntity.builder()
                        .city("Oradea")
                        .build(),
                LocationEntity.builder()
                        .city("Prague")
                        .build(),
                LocationEntity.builder()
                        .city("Paris")
                        .build(),
                LocationEntity.builder()
                        .city("Amsterdam")
                        .build());
        return locationRepository.saveAll(locationsToSave);
    }
}
