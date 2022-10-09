import hu.sebestyen.foxandhounds.service.exeption.MapParsingExeption;
import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.map.MapParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapParserTest {
    private MapParser underTest;

    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };

    private static MapVO exeptedMapOV = new MapVO(4,map);

    @Test
    public void testParseShouldReturnNewParse() throws MapParsingExeption {
        //given
        underTest = new MapParser(4);

        //then
        MapVO result= underTest.parse();

        //when
        assertEquals(exeptedMapOV, result);
    }

    @Test
    public void testParseShouldThrowMapParsingExeptionWhenGivenNumberLessThen4() throws MapParsingExeption {
        //given
        underTest =new MapParser(2);

        //when-then
        assertThrows(MapParsingExeption.class, ()->{
            underTest.parse();
        });
    }

    @Test
    public void testParseShouldThrowMapParsingExeptionWhenGivenNumberMoreThen12() throws MapParsingExeption {
        //given
        underTest =new MapParser(14);

        //when-then
        assertThrows(MapParsingExeption.class, ()->{
            underTest.parse();
        });
    }

    @Test
    public void testParseShouldThrowMapParsingExeptionWhenGivenNumberDoesntEvenNumber() throws MapParsingExeption {
        //given
        underTest =new MapParser(7);

        //when-then
        assertThrows(MapParsingExeption.class, ()->{
            underTest.parse();
        });
    }
}
