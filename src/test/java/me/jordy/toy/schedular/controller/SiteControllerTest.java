package me.jordy.toy.schedular.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.jordy.toy.schedular.vo.entity.Site;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SiteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createBlog() throws Exception {
        Site site = Site.builder()
                .name("김동욱 블로그")
                .url("https://eastglow.github.io/")
                .elements("post-date")
                .build()
                ;
        mockMvc.perform(post("/api/site")
                .contentType(MediaTypes.HAL_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(site)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("seq").exists())
        ;
    }

    @Test
    public void createBlogValidationCheck() throws Exception {
        Site site = Site.builder()
                .elements("post-date")
                .build()
                ;
        mockMvc.perform(post("/api/site")
                .contentType(MediaTypes.HAL_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(site)))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }
}
