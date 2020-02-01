package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void otaLiikaa() {
        varasto.lisaaVarastoon(5);

        double maara = varasto.otaVarastosta(7);
        assertEquals(5, maara, vertailuTarkkuus);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void otaNolla() {
        varasto.lisaaVarastoon(5);
        double maara = varasto.otaVarastosta(-2);

        assertEquals(0, maara, vertailuTarkkuus);
    }

    @Test
    public void lisaaLiikaa() {
        varasto.lisaaVarastoon(15);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaaNolla() {
        varasto.lisaaVarastoon(-3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void testaaKonstruktoreja() {
        Varasto toinenVarasto = new Varasto(0, -2);
        assertEquals(0, toinenVarasto.getSaldo(), vertailuTarkkuus);
        assertEquals(0, toinenVarasto.getTilavuus(), vertailuTarkkuus);

        Varasto kolmasVarasto = new Varasto(10, 5);
        assertEquals(5, kolmasVarasto.getSaldo(), vertailuTarkkuus);
        assertEquals(10, kolmasVarasto.getTilavuus(), vertailuTarkkuus);

        Varasto neljasVarasto = new Varasto(10, 15);
        assertEquals(10, neljasVarasto.getSaldo(), vertailuTarkkuus);

        Varasto viidesVarasto = new Varasto(0);
        assertEquals(0, viidesVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void testaaString() {
        varasto.lisaaVarastoon(4);
        assertEquals(("saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu()),
                varasto.toString());
    }

}