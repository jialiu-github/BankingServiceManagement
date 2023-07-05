package cc.unitmesh.untitled.demo.mapper;

import cc.unitmesh.untitled.demo.dto.CreateBlogDto;
import cc.unitmesh.untitled.demo.entity.BlogPost;

public class BlogMapper {

    public BlogPost toEntity(CreateBlogDto blogDto) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(blogDto.getTitle());
        blogPost.setContent(blogDto.getContent());
        blogPost.setAuthor(blogDto.getAuthor());
        return blogPost;
    }
}
