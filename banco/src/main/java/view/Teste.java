package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Teste {
    public static void main(String [] args){

        Cliente jordan = new Cliente(
                "Jordan Michael",
                "Jm@gmail.com",
                "123.456.789-09",
                Utils.stringParaDate("17/05/1975")
        );

        Cliente angelina = new Cliente(
                "Angelina Jolie",
                "angel@gmail.com",
                "321.654.987-90",
                Utils.stringParaDate("25/04/1985")
        );

//        System.out.println(jordan);
//        System.out.println();
//        System.out.println(angelina);

        Conta c101 = new Conta(jordan);
        Conta c102 = new Conta(angelina);

        c101.depositar(500.0);
        c102.depositar(500.0);

        c101.sacar(100.0);
        c102.transferir(c101,150.0);



        System.out.println(c101);
        System.out.println();
        System.out.println(c102);
    }
}
