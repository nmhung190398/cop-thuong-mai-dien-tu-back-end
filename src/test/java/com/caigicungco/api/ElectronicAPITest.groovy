package com.caigicungco.api

import com.caigicungco.DTO.ElectronicDTO
import com.caigicungco.service.ElectronicService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import java.util.stream.Collectors
import java.util.stream.IntStream


@RunWith(SpringRunner.class)
@WebMvcTest(ElectronicAPI.class)
class ElectronicAPITest {

    @Autowired
    public MockMvc mockMvc;


    @MockBean
    ElectronicService electronicService;

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindTest() {
//        List<ElectronicDTO> list = IntStream.range(0, 10).mapToObj(
//        new ElectronicDTO()
//        ).collect(Collectors.toList());

        List<ElectronicDTO> list = new ArrayList<>();
        for(int i = 0; i < 10;++i){
            ElectronicDTO dto = new ArrayList<>();
            dto.setId((long)i);
            list.add(dto);
        }
        given( electronicService.findAll()).willReturn(list);
        //Mockito.when(electronicService.findAll()).thenReturn(list);


        mockMvc.perform(get("/api/test")).andExpect(status().isOk());

        }


    void testFindByUri() {
    }
}
