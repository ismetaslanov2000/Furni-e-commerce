package com.example.Wood.services.impls;

import com.example.Wood.dtos.TestimonialDto;
import com.example.Wood.repositories.TestimonialRepository;
import com.example.Wood.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private  final ModelMapper modelMapper;


    @Override
    public List<TestimonialDto> getAllTestimonials() {
        List<TestimonialDto>testimonialDtoList=testimonialRepository.findAll().stream()
                .map(testimonial -> modelMapper
                        .map(testimonial,TestimonialDto.class)).collect(Collectors.toList());
        return testimonialDtoList;
    }
}
