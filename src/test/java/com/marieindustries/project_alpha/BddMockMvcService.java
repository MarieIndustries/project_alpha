package com.marieindustries.project_alpha;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Service
public class BddMockMvcService {
    private final MockMvc mockMvc;

    public BddMockMvcService(final WebApplicationContext webApplicationContext){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public MvcResult post(final String uri, final Object data) {
        try {
            return mockMvc.perform(MockMvcRequestBuilders
                    .post(uri)
                    .content(asJsonString(data))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String asJsonString(final Object data) {
        try {
            return new ObjectMapper().writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MvcResult get(final String url){
        try {
            return mockMvc.perform(MockMvcRequestBuilders
                        .get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
