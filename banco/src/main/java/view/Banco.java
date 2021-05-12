package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    static String nome = "Geek Banco";
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contas;

    public static void main(String[]args){
        Banco.contas = new ArrayList<Conta>();
        Banco.menu();
    }

    public static void menu(){
        int opcao = 0;
        System.out.println("===============");
        System.out.println("======   ATM    ======");
        System.out.println("====== "+Banco.nome + " ======");
        System.out.println("===============");
        System.out.println("Selecione uma opção no menu: ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Efetuar saque");
        System.out.println("3 - Efetuar depósito");
        System.out.println("4 - Efetuar transferência");
        System.out.println("5 - Listar contas");
        System.out.println("6 - Sair do sistema");

        try{
            opcao = Integer.parseInt(Banco.teclado.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Por favor, informe uma opção válida.");
            Utils.pausar(1);
            Banco.menu();
        }

        switch (opcao){
            case 1:
                Banco.criarConta();
                break;
            case 2:
                Banco.efetuarSaque();
                break;
            case 3:
                Banco.efetuarDeposito();
                break;
            case 4:
                Banco.efetuarTransferencia();
                break;
            case 5:
                Banco.listarContas();
                break;
            case 6:
                System.out.println("Até a próxima");
                Utils.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                Utils.pausar(2);
                Banco.menu();
                break;
        }

    }
    public static void criarConta(){
        System.out.println("Informe os dados do cliente: ");

        System.out.println("Nome do cliente: ");
        String nome = Banco.teclado.nextLine();

        System.out.println("E-mail do cliente: ");
        String email = Banco.teclado.nextLine();

        System.out.println("CPF do cliente: ");
        String cpf = Banco.teclado.nextLine();

        System.out.println("Datade nascimento do cliente: ");
        String data_nascimento = Banco.teclado.nextLine();

        Cliente cliente = new Cliente(nome,email,cpf,Utils.stringParaDate(data_nascimento));
        Conta conta = new Conta(cliente);
        Banco.contas.add(conta);

        System.out.println("Conta criada com sucesso!");
        System.out.println("Dados da conta criada: ");
        System.out.println(conta);
        System.out.println();

        Utils.pausar(5);
        Banco.menu();
    }
    public static void efetuarSaque(){
        System.out.println("Informe o número da conta: ");
        int numero = Banco.teclado.nextInt();

        Conta conta = Banco.buscarContaPorNumero(numero);

        if(conta != null){
            System.out.println("Informe o valor do saque: ");
            Double valor = Banco.teclado.nextDouble();

            conta.sacar(valor);
        }else{
            System.out.println("Não foi encontrada a conta número: "+ numero);
        }
        Utils.pausar(3);
        Banco.menu();
    }
    public static void efetuarDeposito(){
        System.out.println("Informe o número da conta: ");
        int numero = Banco.teclado.nextInt();

        Conta conta = Banco.buscarContaPorNumero(numero);

        if(conta != null){
            System.out.println("Informe o valor de depósito: ");
            Double valor = Banco.teclado.nextDouble();

            conta.depositar(valor);
        }else{
            System.out.println("Não foi encontrada a conta número: "+ numero);
        }
        Utils.pausar(3);
        Banco.menu();
    }
    public static void efetuarTransferencia(){
        System.out.println("Informe o número da sua conta: ");
        int numero_origem = Banco.teclado.nextInt();

        Conta conta_origem = Banco.buscarContaPorNumero(numero_origem);

        if(conta_origem != null){
            System.out.println("Informe a conta da conta destino: ");
            int numero_destino = Banco.teclado.nextInt();

            Conta conta_destino = Banco.buscarContaPorNumero(numero_destino);

            if(conta_destino != null){
                System.out.println("Informe o valor da transferência: ");
                Double valor = Banco.teclado.nextDouble();

                conta_origem.transferir(conta_destino,valor);
            }else{
                System.out.println("A conta destino número "+ numero_destino + " não foi encontrada");
            }
        }else{
            System.out.println("Não foi encontrada a conta número: "+ numero_origem);
        }
        Utils.pausar(3);
        Banco.menu();
    }
    public static void listarContas(){
        if(Banco.contas.size() > 0){
            System.out.println("Listagem de contas");
            System.out.println();

            for (Conta conta : Banco.contas){
                System.out.println(conta);
                System.out.println();
                Utils.pausar(1);
            }
            System.out.println();
            
        }else{
            System.out.println("Não existem contas cadastradas ainda");
        }
        Utils.pausar(2);
        Banco.menu();
    }

    private static Conta buscarContaPorNumero(int numero){
        Conta c = null;
        if(Banco.contas.size() > 0) {
            for (Conta conta : Banco.contas) {
                if (conta.getNumero() == numero) {
                    c = conta;
                }
            }
        }
        return c;
    }
}
