package cc.unitmesh.untitled.demo.dto;

import lombok.Data;

@Data
public class CreateBlogDto {
    private String title;
    private String content;
    private String author;
}
