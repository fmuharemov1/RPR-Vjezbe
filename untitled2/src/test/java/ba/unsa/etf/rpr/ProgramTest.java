package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    public void testProvjeriIspravnostBrojaIspravanBroj() {
        String ispravanBroj = "123-456";
        boolean rezultat = Program.provjeriIspravnostBroja(ispravanBroj);
        assertTrue(rezultat);
    }

    @Test
    public void testProvjeriIspravnostBrojaNeispravanBroj() {
        String neispravanBroj = "12A-456";
        boolean rezultat = Program.provjeriIspravnostBroja(neispravanBroj);
        assertFalse(rezultat);
    }

    @Test
    public void testKreirajFiksniBrojIspravno() throws brojNePostojiIzuzetak {
        String gradStr = "SARAJEVO";
        FiksniBroj.Grad grad = FiksniBroj.Grad.valueOf(gradStr);
        String ispravanBroj = "123-456";
        FiksniBroj fiksniBroj = new FiksniBroj(grad, ispravanBroj);
        assertNotNull(fiksniBroj);
    }
}