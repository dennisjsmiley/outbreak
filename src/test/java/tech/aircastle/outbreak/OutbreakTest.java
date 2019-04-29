package tech.aircastle.outbreak;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OutbreakTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Room[][] verticalTrue = new Room[][] {
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(true), new
                    Room(true), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) }
    };

    private final Room[][] horizontalTrue = new Room[][] {
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(true), new Room(true), new
                    Room(true), new Room(true), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false),
                    new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false),
                    new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false),
                    new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false),
                    new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) }
    };

    private final Room[][] noInfection = new Room[][] {
            {new Room(true), new Room(false), new Room(true), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(true), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(true), new Room(false), new Room(true), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(true), new
                    Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(true), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(true), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(true), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) },
            {new Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false), new Room(false), new Room(false), new Room(false), new
                    Room(false) }
    };

    private final Room[][] twoRows = new Room[][] {
            new Room[] {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), },
            new Room[] {new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), },
            new Room[] {new Room(false), new Room(false), new Room(true), new Room(true), new Room(true), },
    };

    @Test
    public void testVerticalTrue() {
        assertTrue(Outbreak.isOutbreak(verticalTrue));
    }

    @Test
    public void testHorizontalTrue() {
        assertTrue(Outbreak.isOutbreak(horizontalTrue));
    }

    @Test
    public void testNoInfection() {
        assertFalse(Outbreak.isOutbreak(noInfection));
    }

    @Test
    public void testEmptyFloor() {
        assertFalse(Outbreak.isOutbreak(new Room[][] {}));
        assertFalse(Outbreak.isOutbreak(new Room[][] {{}}));
    }

    @Test
    public void testTwoRows() {
        assertTrue(Outbreak.isOutbreak(twoRows));
    }

    @Test
    public void testGetInfectionSize() {
        logger.info("---- start testGetInfectionSize ----");

        Room[][] floor = new Room[][] {
                new Room[] {new Room(true), new Room(true), new Room(true), new Room(true)},
                new Room[] {new Room(false), new Room(true), new Room(false), new Room(true)},
                new Room[] {new Room(true), new Room(false), new Room(false), new Room(true)},
        };

        int y = 0;
        int x = 0;
        int infectionSize = Outbreak.getInfectionSize(x, y, floor);

        logger.info("x: {}, y: {}", x, y);
        logger.info("infectionSize: {}", infectionSize);

        assertEquals(7, infectionSize);

        logger.info("---- end testGetInfectionSize ----");
    }
}
