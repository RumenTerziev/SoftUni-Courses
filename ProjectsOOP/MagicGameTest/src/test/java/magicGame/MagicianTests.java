package magicGame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MagicianTests {
    private static final int TEST_DAMAGE = 5;

    private Magic magic;
    private Magician magician;


    @Before
    public void setUp() {
        this.magic = new Magic("test_name", 5);
        this.magician = new Magician("magician_name", 20);
    }


    @Test
    public void testCtorShouldMakeNewInstance() {
        Magician magician1 = new Magician("test_name", 25);
        assertEquals("test_name", magician1.getUsername());
        assertEquals(25, magician1.getHealth());
        List<Magic> expectedList = new ArrayList<>();
        assertEquals(expectedList, magician1.getMagics());
    }



    @Test(expected = NullPointerException.class)
    public void testCtorShouldThrowIfUsernameIsNull() {
        Magician magicianTest = new Magician(null, 10);
    }


    @Test(expected = NullPointerException.class)
    public void testCtorShouldThrowIfUsernameLengthIsLessThanOne() {
        Magician magicianTest = new Magician("", 10);
    }


    @Test(expected = NullPointerException.class)
    public void testCtorShouldThrowIfUsernameIsWhiteSpace() {
        Magician magicianTest = new Magician("   ", 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCtorShouldThrowIfHealthIsBelowZero() {
        Magician magicianTest = new Magician("test_name", -1);
    }


    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowIfHealthIsZero() {
        Magician testMagician = new Magician("black_magician", 0);
        testMagician.takeDamage(TEST_DAMAGE);
    }


    @Test
    public void testTakeDamageShouldReturnZeroIfMagicianHasZeroHealth() {
        Magician magicianTest = new Magician("magician_test", 5);
        magicianTest.takeDamage(magic.getBullets());
        assertEquals(0, magicianTest.getHealth());
    }


    @Test
    public void testTakeDamageShouldReturnZeroIfMagicianHasNegativeHealth() {
        Magician magicianTest = new Magician("magician_test", 4);
        magicianTest.takeDamage(magic.getBullets());
        assertEquals(0, magicianTest.getHealth());
    }


    @Test
    public void testTakeDamageShouldReturnCorrectHealthAfterMagicianTakesDamage() {
        magician.takeDamage(magic.getBullets());
        assertEquals(15, magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowIfMagicIsNull() {
        magician.addMagic(null);
    }

    @Test
    public void testAddMagicShouldAddMagicToMagician() {
        assertEquals(0, magician.getMagics().size());
        magician.addMagic(magic);
        assertEquals(1, magician.getMagics().size());
    }


    @Test
    public void testRemoveMagicShouldRemoveMagicFromMagicianMagics() {
        magician.addMagic(magic);
        assertEquals(1, magician.getMagics().size());
        magician.removeMagic(magic);
        assertEquals(0, magician.getMagics().size());
    }

    @Test
    public void testGetMagicShouldReturnMagicWithSearchedName() {

        Magic magicOne = new Magic("magicOne", 5);
        Magic magicTwo = new Magic("magicTwo", 10);
        Magic magicThree = new Magic("magicThree", 15);
        Magic magicFour = new Magic("magicFour", 20);

        magician.addMagic(magicOne);
        magician.addMagic(magicTwo);
        magician.addMagic(magicThree);
        magician.addMagic(magicFour);


        Magic searchedMagic = magician.getMagics()
                .stream().filter(g -> g.getName().
                        equals("magicTwo")).findFirst().orElse(null);



        assertEquals(searchedMagic, magician.getMagic("magicTwo"));

    }

    @Test
    public void testGetMagicShouldReturnNullIfNoSuchMagic() {

        Magic magic1 = magician.getMagic("not_added");
        assertNull(magic1);
    }

    @Test
    public void testRemoveMagicShouldReturnFalseIfMagicNotFound() {
        Magic notAdded = new Magic("not_added_magic", 25);
        assertFalse(magician.removeMagic(notAdded));
    }

    @Test
    public void testRemoveMagicShouldReturnTrueIfMagicIsRemoved() {
        Magic added = new Magic("added_magic", 35);
        magician.addMagic(added);
        assertTrue(magician.removeMagic(added));
    }

}
