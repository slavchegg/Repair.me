package com.coursework.repair.serviceImpl;

import com.coursework.repair.entity.AdvertiseEntity;
import com.coursework.repair.entity.CarModificationEntity;
import com.coursework.repair.entity.DetailEntity;
import com.coursework.repair.entity.DetailModificationEntity;
import com.coursework.repair.replies.AdvertiseReply;
import com.coursework.repair.repository.AdvertiseRepository;
import com.coursework.repair.repository.DetailModificationRepository;
import com.coursework.repair.repository.DetailRepository;
import com.coursework.repair.service.AdvertiseService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertiseImpl implements AdvertiseService {

    private final AdvertiseRepository advertiseRepository;
    private final DetailModificationRepository detailModificationRepository;
    private final DetailRepository detailRepository;

    @Autowired
    public AdvertiseImpl(AdvertiseRepository advertiseRepository, DetailModificationRepository detailModificationRepository, DetailRepository detailRepository) {
        this.advertiseRepository = advertiseRepository;
        this.detailModificationRepository = detailModificationRepository;
        this.detailRepository = detailRepository;
    }

    @Override
    public List<AdvertiseReply> getAll() {
        List<AdvertiseReply> reply = new ArrayList<AdvertiseReply>();
        AdvertiseReply advert  = new AdvertiseReply();
        advertiseRepository.findAll().forEach(e->{
            advert.setAdvertise(e);
            advert.setDetailName(e.getDetailByDetailId().getName());
            advert.setDetailNode(e.getDetailByDetailId().getNode());
            reply.add(advert);
        });
        return  reply;
    }

    @Transactional
    @Override
    public String addNew(AdvertiseEntity advertise, DetailEntity detail, CarModificationEntity modification) {
        // запись модификации статична, она уже есть в базе
        // записи детали каждый раз добавляются новые
        detail = detailRepository.save(detail);

        DetailModificationEntity detModif = new DetailModificationEntity();
        detModif.setModificationId(modification.getId());
        detModif.setDetailId(detail.getId());
        detModif = detailModificationRepository.save(detModif);

        advertise.setDetailId(detail.getId());
        advertiseRepository.save(advertise);

        return "Successful";
    }
}
