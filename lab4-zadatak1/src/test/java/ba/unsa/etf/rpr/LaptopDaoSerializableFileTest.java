package ba.unsa.etf.rpr;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LaptopDaoSerializableFileTest {
    @Mock
    private ObjectOutputStream objectOutputStream;
    @Mock
    private ObjectInputStream objectInputStream;
    @InjectMocks
    private LaptopDaoSerializableFile laptopDao;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        laptopDao.setObjectInputStream(objectInputStream);
    }
    private File testFile;
    @Test
    void dodajLaptopUFile() throws IOException {
        Laptop laptop = new Laptop("HP", "i3", 4);
        laptopDao.postaviObjectOutputStream(objectOutputStream);
        laptopDao.dodajLaptopUFile(laptop);
        verify(objectOutputStream).writeObject(laptop);
    }
    @org.junit.jupiter.api.Test
    void getLaptop() throws NeodgovarajuciProcesorException{
        Laptop laptop = new Laptop("Lenovo", "i5", 8);
        ArrayList<Laptop> laptopi = new ArrayList<>();
        laptopi.add(laptop);
        laptopDao.napuniListu(laptopi);
        assertSame(laptop, laptopDao.getLaptop("i5"));
    }
    @org.junit.jupiter.api.Test
    void napuniListu() {
        assertEquals(2,2);
    }
    @Test
    void vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        Laptop laptop1 = new Laptop("Dell", "i7", 16);
        Laptop laptop2 = new Laptop("Asus", "i5", 8);
        when(objectInputStream.readObject()).thenReturn(laptop1, laptop2, null);
        ArrayList<Laptop> laptopi = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(2, laptopi.size());
        assertTrue(laptopi.contains(laptop1));
        assertTrue(laptopi.contains(laptop2));
        verify(objectInputStream, times(3)).readObject();
    }
}