package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.CreateBlogDto;
import cc.unitmesh.untitled.demo.entity.BlogPost;
import cc.unitmesh.untitled.demo.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BlogController {
    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public Long createBlog(CreateBlogDto blogDto) {
        return blogService.createBlog(blogDto).getId();
    }

    @GetMapping("/blog")
    public List<BlogPost> getBlog() {
        return blogService.getAllBlogPosts();
    }
}
