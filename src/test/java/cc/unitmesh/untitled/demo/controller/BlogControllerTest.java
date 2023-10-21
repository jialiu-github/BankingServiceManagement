package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.entity.BlogPost;
import cc.unitmesh.untitled.demo.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogRepository blogRepository;

    @Test
    public void should_return_correct_blog_information_when_post_item() throws Exception {
        BlogPost mockBlog = new BlogPost("Test Title", "Test Content", "Test Author");
        mockBlog.setId(1L);

        Mockito.when(blogRepository.findById(1L)).thenReturn(Optional.of(mockBlog));

        mockMvc.perform(get("/blog/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Title")))
                .andExpect(content().string(containsString("Test Content")));
    }

    // Given 我是一个员工，已经登录到 OKR 系统中，When 我选择更新我的 OKR 进展情况，Then 我可以看到一个可以填写进展情况的表单。
}

