package toyStore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {

    private Toy toy;
    private ToyStore toyStore;

    @Before
    public void setUp() {
        this.toy = new Toy("test_name", "test_id");
        this.toyStore = new ToyStore();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfStoreDoesNotContainThatName() throws OperationNotSupportedException {
        toyStore.addToy("not_added", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfNoSuchName() {
        toyStore.removeToy("not_added", toy);
    }


    @Test
    public void removeToyShouldReturnCorrectString() {
        String output = null;
        try {
            toyStore.removeToy("not_added", toy);
        } catch (IllegalArgumentException exception) {
            output = exception.getMessage();
        }
        assertEquals("Shelf doesn't exists!", output);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfShelfIsAlreadyTaken() throws OperationNotSupportedException {

        addMultipleToys();
        toyStore.addToy("A", toy);

    }


    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowIfToyIsAlreadyInShelf() throws OperationNotSupportedException {

        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfNoSuchToyInThatShelf() {

        toyStore.removeToy("A", toy);

    }


    @Test
    public void removeShouldReturnCorrectStringWhenRemoveToyFromShelf() throws OperationNotSupportedException {

        toyStore.addToy("A", toy);

        String outputOne = String.format("Remove toy:%s successfully!", toy.getToyId());
        String outputTwo = String.format(toyStore.removeToy("A", toy));
        assertEquals(outputOne, outputTwo);
    }



    @Test
    public void testRemoveShouldRemoveCorrectToyFromShelf() throws OperationNotSupportedException {

        toyStore.addToy("A", toy);


        assertEquals(toy, toyStore.getToyShelf().get("A"));

        toyStore.removeToy("A", toy);

        assertNull(toyStore.getToyShelf().get("A"));


    }




    public void addMultipleToys() throws OperationNotSupportedException {

        Toy toyOne = new Toy("test_name", "test_id");
        Toy toyTwo = new Toy("test_name", "test_id");
        Toy toyThree = new Toy("test_name", "test_id");
        Toy toyFour = new Toy("test_name", "test_id");
        Toy toyFive = new Toy("test_name", "test_id");


        toyStore.addToy("A", toyOne);
        toyStore.addToy("B", toyTwo);
        toyStore.addToy("C", toyThree);


    }

}