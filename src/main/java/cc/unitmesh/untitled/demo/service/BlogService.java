package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.dto.CreateBlogDto;
import cc.unitmesh.untitled.demo.mapper.BlogMapper;
import cc.unitmesh.untitled.demo.model.BlogPost;
import cc.unitmesh.untitled.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    BlogMapper blogMapper;

    public BlogPost createBlog(CreateBlogDto blogDto) {
        return blogRepository.save(blogMapper.toEntity(blogDto));
    }
}
