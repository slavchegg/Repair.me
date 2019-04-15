package com.coursework.repair.serviceImpl;

import com.coursework.repair.entity.*;
import com.coursework.repair.repository.*;
import com.coursework.repair.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PhotoRepository photoRepository;
    private final ManRepository manRepository;
    private final MechanicRepository mechanicRepository;
    private final ServiceRepository serviceRepository;
    private final CarRepository carRepository;
    private final MechanicModificationRepository mechanicModificationRepository;
    private final CarModificationRepository carModificationRepository;
    private final AuthImpl auth;
    private final BCryptPasswordEncoder passwordEncoder;
    private final CarMakeRepository carMakeRepository;
    private final CarModelRepository carModelRepository;

    @Autowired
    public RegistrationServiceImpl(PhotoRepository photoRepository, ManRepository manRepository, MechanicRepository mechanicRepository, ServiceRepository serviceRepository, CarRepository carRepository, MechanicModificationRepository mechanicModificationRepository, CarModificationRepository carModificationRepository, AuthImpl auth, BCryptPasswordEncoder passwordEncoder, CarMakeRepository carMakeRepository, CarModelRepository carModelRepository) {
        this.photoRepository = photoRepository;
        this.manRepository = manRepository;
        this.mechanicRepository = mechanicRepository;
        this.serviceRepository = serviceRepository;
        this.carRepository = carRepository;
        this.mechanicModificationRepository = mechanicModificationRepository;
        this.carModificationRepository = carModificationRepository;
        this.auth = auth;
        this.passwordEncoder = passwordEncoder;
        this.carMakeRepository = carMakeRepository;
        this.carModelRepository = carModelRepository;
    }

    @Transactional
    @Override
    public String regDriver(ManEntity man, String photoHref) {
        // сохранение фотографии
        PhotoEntity photo = new PhotoEntity();
        photo.setPhotoHref(photoHref);
        photo = photoRepository.save(photo);

        // сохранение записи нового пользователя
        man.setPhotoId(photo.getId());
        man.setIsMechanic(false);
        manRepository.save(man);

        return "Successful registered";
    }

    @Transactional
    @Override
    public String regMechanic(ManEntity man, String photoHref, MechanicEntity mechanic) {

        PhotoEntity photo = new PhotoEntity();
        photo.setPhotoHref(photoHref);
        photo = photoRepository.save(photo);

        man.setPhotoId(photo.getId());
        man.setIsMechanic(true);
        man = manRepository.save(man);

        mechanic.setManId(man.getId());
        mechanicRepository.save(mechanic);

        return "Successful registered";
    }

//     you can use with method if you want to change current list of modifications. But you need rewrite current and add new modifications
//     there isn't a method, which return list of current mechanic's modifications ;
    @Transactional
    @Override
    public String regMechanicModification(long mechanicId, String[] makes /*modifications*/) {

        // code below we can use, when mechanic choose modifications
//        MechanicModificationEntity mm = new MechanicModificationEntity();
//        for (String modification : modifications) {
//            mm.setMechanicId(mechanicId);
//            mm.setModificationId(carModificationRepository.findByName(modification).getId());
//            mechanicModificationRepository.save( mm );
//        }
//        return "Successful";
        // finish of code with modifications

        List<String> modification =  new ArrayList<>();
        for(String make : makes){
            carMakeRepository.findByName(make).getCarModelsById().forEach(model->{
                model.getCarModificationsById().forEach(modif -> {
                    MechanicModificationEntity mm = new MechanicModificationEntity();
                    mm.setModificationId(modif.getId());
                    mm.setMechanicId(mechanicId);

                    mechanicModificationRepository.save(mm);
                });
            });
        }
        return "Successful" ;

    }

    @Transactional
    @Override
    public String regService(MechanicEntity mechanic, String photoHref, ServiceEntity service) {
        PhotoEntity photo = new PhotoEntity();
        photo.setPhotoHref(photoHref);
        photo = photoRepository.save(photo);

        service.setPhotoId(photo.getId());
        service.setRating((int)( Math.random()+1)*10 );
        service = serviceRepository.save(service);

        mechanic.setAdmin(true);
        mechanic.setServiceId(service.getId());

        mechanicRepository.save(mechanic);

        return "Successful";
    }

    @Override
    public String regNewCar(long vin, long manId, long modificationId){
        if (carRepository.findByVin(vin) != null) return "Данный VIN номер уже зарегистрирован. Пожалуйста, проверьте его еще раз. ";
        else {
            CarEntity car = new CarEntity();

            car.setVin(vin);
            car.setDriverId(manId);
            car.setModificationId(modificationId);
            carRepository.save(car);

            return "Successful";
        }

    }

    // changing all filed except mail or password
    @Transactional
    @Override
    public String changeUserData(ManEntity man) {
        manRepository.save(man);  // update data
        return "Successful";
    }

    // todo: change mail and password !  - 2 methods below
    @Override
    public String changeMail(String mail) {
        return null;
    }
    @Override
    public String changePassword(String password) {
        return null;
    }


}