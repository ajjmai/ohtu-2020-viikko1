package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);

        mehua.lisaaVarastoon(50.7);
        mehua.otaVarastosta(3.14);

        System.out.println("Virhetilanteita:");
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);

        huono = new Varasto(100.0, -50.7);
        System.out.println(huono);

        olutta.lisaaVarastoon(1000.0);

        mehua.lisaaVarastoon(-666.0);

        olutta.otaVarastosta(1000.0);

        mehua.otaVarastosta(-32.9);
    }
}
