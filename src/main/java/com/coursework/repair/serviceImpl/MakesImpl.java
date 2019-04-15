package com.coursework.repair.serviceImpl;

import com.coursework.repair.entity.CarMakeEntity;
import com.coursework.repair.entity.CarModelEntity;
import com.coursework.repair.entity.CarModificationEntity;
import com.coursework.repair.entity.ManEntity;
import com.coursework.repair.replies.CarReply;
import com.coursework.repair.repository.CarMakeRepository;
import com.coursework.repair.repository.CarModelRepository;
import com.coursework.repair.repository.CarModificationRepository;
import com.coursework.repair.repository.ManRepository;
import com.coursework.repair.service.MakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakesImpl implements MakesService {

    private final CarMakeRepository carMakeRepository;
    private final CarModelRepository carModelRepository;
    private final CarModificationRepository carModificationRepository;

    @Autowired
    public MakesImpl(CarMakeRepository carMakeRepository, CarModelRepository carModelRepository, CarModificationRepository carModificationRepository) {
        this.carMakeRepository = carMakeRepository;
        this.carModelRepository = carModelRepository;
        this.carModificationRepository = carModificationRepository;
    }

    @Override
    public ArrayList<String> getAllMakes() {
        ArrayList<String> makeNames = new ArrayList<>();
        List<CarMakeEntity> makes = carMakeRepository.findAll();
        makes.forEach(e->makeNames.add(e.getName()));
        return makeNames;
    }

    // IMPORTANT: make's name is unique ( else we have db error and incorrect  respond )
    @Override
    public ArrayList<String> getAllModelsByMakes(String makeName) {
        ArrayList<String> modelNames = new ArrayList<>();
//        try{
            List<CarModelEntity> models = carModelRepository.findAllByCarMakeByMakeId(
                    carMakeRepository.findByName(makeName)
            );
            models.forEach(model ->
                    modelNames.add(model.getName() + " "+ model.getGeneration())
            );

//        }catch (NullPointerException e){
//            modelNames.add("no models");
//
//        }
        return modelNames;
    }

    @Override
    public ArrayList<String> getAllModificationByModel(String modelName) {
        String[] s = modelName.split(" ");
        System.out.println("*** User choose model name - "+ s[0] + "; generation "+s[1]);
        List<CarModificationEntity> modifications = carModificationRepository.findAllByCarModelByModel(
//                carModelRepository.findByName(modelName)
                carModelRepository.findByNameAndGeneration(s[0], s[1])
        );

        ArrayList<String> modificationNames = new ArrayList<>();
        modifications.forEach(e->modificationNames.add(e.getName()));
        return modificationNames;
    }

    @Override
    public List<CarReply> getAllUserCars(ManEntity man) {
        List<CarReply> reply = new ArrayList<>();

        man.getCarsById().forEach(car->{
            CarReply nextCar = new CarReply();
            nextCar.setVin(car.getVin());
            nextCar.setModification(
                    car.getCarModificationByModificationId().getCarModelByModel().getCarMakeByMakeId().getName() + " " +
                    car.getCarModificationByModificationId().getCarModelByModel().getName() + " " +
                    car.getCarModificationByModificationId().getName()
            );
            reply.add(nextCar);
        });
        return reply;
    }
}
