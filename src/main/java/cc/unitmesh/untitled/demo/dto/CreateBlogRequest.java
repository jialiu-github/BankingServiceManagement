package cc.unitmesh.untitled.demo.dto;

import lombok.Data;

@Data
public class CreateBlogRequest {
    private String title;
    private String content;
}