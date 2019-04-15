package com.coursework.repair.controller;

import com.coursework.repair.entity.ServiceEntity;
import com.coursework.repair.replies.AllServiceReply;
import com.coursework.repair.replies.ServiceReply;
import com.coursework.repair.repository.PhotoRepository;
import com.coursework.repair.repository.ServiceRepository;
import com.coursework.repair.serviceImpl.ServiceInfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceRepository serviceRepository;
    private final PhotoRepository photoRepository;
    private final ServiceInfoImpl serviceMakes;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository, PhotoRepository photoRepository, ServiceInfoImpl serviceMakes) {
        this.serviceRepository = serviceRepository;
        this.photoRepository = photoRepository;
        this.serviceMakes =  serviceMakes;
    }

    @GetMapping("/getAll")
    public List<AllServiceReply> getAllServices(){
        List<AllServiceReply> catalog = new ArrayList<>();

        serviceRepository.findAll().forEach(e->{
            AllServiceReply serviceCatalog = new AllServiceReply();
            serviceCatalog.setName(e.getName());
            serviceCatalog.setRating(e.getRating());
            serviceCatalog.setPhotoHref(photoRepository.findById(e.getPhotoId()).getPhotoHref());
            serviceCatalog.setAddress(formAddress(e));
            serviceCatalog.setState(countState(e));
            serviceCatalog.setMakes(serviceMakes.getMakes(e));

            catalog.add(serviceCatalog);
                });
        return catalog;

    }

    @GetMapping("/getOne")
    public ServiceReply getServiceByName(@Param("name")String name){
        ServiceReply serviceReply = new ServiceReply();
        ServiceEntity serviceEntity = serviceRepository.findByName(name);

        ServiceReply.Service serviceInfo = new ServiceReply.Service();

        serviceInfo.setName(serviceEntity.getName());
        serviceInfo.setAddress(
                serviceEntity.getAdressCity() + ", "
                        + serviceEntity.getAdressRegion() + ", "
                        + serviceEntity.getAdressStreet() + ", "
                        + serviceEntity.getAdressHouse()
        );
        serviceInfo.setHours(serviceEntity.getHours());
        serviceInfo.setHref(serviceEntity.getHref());
        serviceInfo.setContent(serviceEntity.getContent());
        serviceInfo.setPhotoHref(serviceEntity.getPhotoByPhotoId().getPhotoHref());
        serviceInfo.setPhone(serviceEntity.getPhone());
        serviceInfo.setRating(serviceEntity.getRating());

        serviceReply.setService(serviceInfo);

        List<ServiceReply.Mans> mans = new ArrayList<>();

        serviceEntity.getMechanicsById().forEach(mechanic->{

            // we add only approved mechanics
            if (mechanic.getApprove()){
                ServiceReply.Mans man = new ServiceReply.Mans();

                man.setId(mechanic.getId());
                man.setName(mechanic.getManByManId().getName());
                man.setSurname(mechanic.getManByManId().getSurname());
                man.setPhotoHref(mechanic.getManByManId().getPhotoByPhotoId().getPhotoHref());
                man.setPost(mechanic.getPost());
                mans.add(man);

            }

        });
        serviceReply.setMechanics(mans);

        return serviceReply;
    }

    @GetMapping("/filter")
    public List<AllServiceReply> getSomeServices(@RequestParam(value = "make", required = false, defaultValue = "default")String make,
                                                 @RequestParam(value = "model", required = false, defaultValue = "default")String model,
                                                 @Param("rating")int rating,// default or start value = 0
                                                 @Param("state") int state){ // default or start value = 0
        List<AllServiceReply> services = getAllServices();

        services = services.stream().filter(e->e.getRating() >= rating && e.getState() >= state).collect(Collectors.toList());

        if (!make.equals("default")) {
            if (!model.equals("default")) {
                services = services.stream()
                        .filter(e->e.getMakes().contains(make) &&
                                serviceMakes.getModels(serviceRepository.findByName(e.getName())).contains(model))
                        .collect(Collectors.toList());
            }else services = services.stream().filter(e->e.getMakes().contains(make)).collect(Collectors.toList());
        }
        return services;
    }


// формирование строки адреса: регион город улица дом
    private static String formAddress(ServiceEntity serviceEntity){
        String s = ", ";
        return serviceEntity.getAdressRegion() + s +
                serviceEntity.getAdressCity() + s +
                serviceEntity.getAdressStreet() + s +
                serviceEntity.getAdressHouse();
    }
// подсчет штата сервиса
    private static long countState(ServiceEntity serviceEntity){
        return serviceEntity.getMechanicsById().size();
    }

}