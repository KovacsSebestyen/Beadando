import hu.sebestyen.foxandhounds.service.exeption.MapParsingExeption;
import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.map.MapBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapBuilderTest {
    private MapBuilder underTest;

    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };

    private static MapVO exeptedMapOV = new MapVO(4,map);

    @Test
    public void testBuildShouldReturnNewParse() throws MapParsingExeption {
        //given
        underTest = new MapBuilder(4);

        //then
        MapVO result= underTest.build();

        //when
        assertEquals(exeptedMapOV, result);
    }

    @Test
    public void testBuildShouldThrowMapParsingExeptionWhenGivenNumberLessThen4() throws MapParsingExeption {
        //given
        underTest =new MapBuilder(2);

        //when-then
        assertThrows(MapParsingExeption.class, ()->{
            underTest.build();
        });
    }

    @Test
    public void testBuildShouldThrowMapParsingExeptionWhenGivenNumberMoreThen12() throws MapParsingExeption {
        //given
        underTest =new MapBuilder(14);

        //when-then
        assertThrows(MapParsingExeption.class, ()->{
            underTest.build();
        });
    }

    @Test
    public void testBuildShouldThrowMapParsingExeptionWhenGivenNumberDoesntEvenNumber() throws MapParsingExeption {
        //given
        underTest =new MapBuilder(7);

        //when-then
        assertThrows(MapParsingExeption.class, ()->{
            underTest.build();
        });
    }
}
