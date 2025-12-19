package com.example.Wood.services.impls;

import com.example.Wood.dtos.SubscribeDto;
import com.example.Wood.models.Subscribe;
import com.example.Wood.repositories.SubscribeRepository;
import com.example.Wood.services.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {
    private final SubscribeRepository subscribeRepository;

    @Override
    public void subscribe(SubscribeDto subscribeDto) {
        Subscribe subscribe=new Subscribe();
        subscribe.setName(subscribeDto.getName());
        subscribe.setEmail(subscribeDto.getEmail());
        subscribeRepository.save(subscribe);


    }
}
