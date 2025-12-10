package com.example.Wood.services.impls;

import com.example.Wood.dtos.PostDto;
import com.example.Wood.dtos.ProductDto;
import com.example.Wood.repositories.PostRepository;
import com.example.Wood.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDto> getALlBlogs() {
        List<PostDto> postDtos = postRepository.findAll().stream().limit(9).
                map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
}
