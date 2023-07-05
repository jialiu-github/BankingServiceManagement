package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.CreateBlogDto;
import cc.unitmesh.untitled.demo.entity.BlogPost;
import cc.unitmesh.untitled.demo.service.BlogService;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {
    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    public Long createBlog(CreateBlogDto blogDto) {
        BlogPost blog = blogService.createBlog(blogDto);
        return blog.getId();
    }
}
