package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {


    private Archaeologist archaeologist;
    private Excavation excavation;


    @Before
    public void setUp() {
        archaeologist = new Archaeologist("test_name", 5);
        excavation = new Excavation("test_excavation_name", 3);
    }


    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsNull() {
        Excavation excavation1 = new Excavation(null, 5);
    }


    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsWhiteSpace() {
        Excavation excavation1 = new Excavation("    ", 5);
    }


    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowIfNameIsEmpty() {
        Excavation excavation1 = new Excavation("", 5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowIfCapacityIsNegativeNumber() {
        Excavation excavation1 = new Excavation("test_name_one", -1);
    }

    @Test
    public void testSetCapacityShouldSetCorrectCapacity() {
        assertEquals(3, excavation.getCapacity());
    }


    @Test
    public void testGetNameShouldReturnCorrectName() {
        assertEquals("test_excavation_name", excavation.getName());
    }

    @Test
    public void testGetCountShouldReturnCorrectCount() {
        assertEquals(0, excavation.getCount());

        addMultipleArcheologists();

        assertEquals(3, excavation.getCount());
    }

    @Test
    public void testAddArcheologistShouldAddInExcavation() {
        assertEquals(0, excavation.getCount());
        excavation.addArchaeologist(archaeologist);
        assertEquals(1, excavation.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfNotEnoughCapacity() {
        addMultipleArcheologists();
        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfArcheologistIsAlreadyAdded() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }


    @Test
    public void testRemoveArcheologistShouldRemoveCorrectly() {
        addMultipleArcheologists();
        assertEquals(3, excavation.getCount());
        excavation.removeArchaeologist("test_name_one");
        assertEquals(2, excavation.getCount());
    }

    @Test
    public void testRemoveShouldReturnTrueIfArcheologistIsRemoved() {
        addMultipleArcheologists();
        assertTrue(excavation.removeArchaeologist("test_name_two"));
    }


    @Test
    public void testRemoveShouldReturnFalseIfArcheologistIsMissing() {
        assertFalse(excavation.removeArchaeologist("not_added"));
    }


    private void addMultipleArcheologists() {
        Archaeologist archaeologistOne = new Archaeologist("test_name_one", 5);
        Archaeologist archaeologistTwo = new Archaeologist("test_name_two", 6);
        Archaeologist archaeologistThree = new Archaeologist("test_name_three", 7);

        excavation.addArchaeologist(archaeologistOne);
        excavation.addArchaeologist(archaeologistTwo);
        excavation.addArchaeologist(archaeologistThree);
    }

}
