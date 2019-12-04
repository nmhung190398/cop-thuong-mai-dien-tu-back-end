import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.conver.ElectronicConver;
import com.caigicungco.entity.ElectronicEntity;
import com.caigicungco.repository.ElectronicRepository;
import com.caigicungco.service.ElectronicService;
import org.junit.*;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ElectronicTest {


    @Mock //dao
    private ElectronicRepository electronicRepository;

    @Mock// entity -> model
    private ElectronicConver electronicConver;

    @InjectMocks
    private ElectronicService electronicService;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void testSpy(){
        List<String> list = Mockito.spy(new ArrayList<>());
        list.add("a");
        Assert.assertEquals(list.size(),1);


        Mockito.doReturn(100).when(list).size();
        Assert.assertEquals(list.size(),100);

    }

    @Test
public void testFindAll() {
        List<ElectronicEntity> list = IntStream.range(0, 10).mapToObj(i -> {
                    ElectronicEntity entity = new ElectronicEntity();
                    entity.setId((long) i);
                    return entity;
                }
        ).collect(Collectors.toList());
    Mockito.when(electronicRepository.findAll()).thenReturn(list);


    Assert.assertEquals(electronicService.findAll().size(),10);

}
}
