package org.convidad.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.convidad.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
@WebMvcTest(BankController.class)
public class BankControllerUnitTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/index.html")).andExpect(status().is(200)).andReturn();
    }


}
