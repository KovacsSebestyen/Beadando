package hu.sebestyen.foxandhounds;

import hu.sebestyen.foxandhounds.model.MapVO;
import hu.sebestyen.foxandhounds.service.exeption.MapParsingExeption;
import hu.sebestyen.foxandhounds.service.map.MapParser;

public class Main {
    public static void main(String[] args) throws MapParsingExeption {

        int szam=6;
        MapVO palya = new MapParser(szam).parse();
        System.out.println(palya.toString());
        System.out.println("End");
    }
}