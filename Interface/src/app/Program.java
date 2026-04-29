package app;

import Services.ContractService;
import Services.payPalServices;
import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("ENTRE OS DADOS DO CONTRATO: ");
        System.out.println("NÚMERO: ");
        int number = sc.nextInt();
        System.out.println("DATA (dd/MM/yyyy)");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.println("VALOR DO CONTRATO: ");
        double totValue = sc.nextDouble();

        Contract objeto = new Contract(number, date, totValue);

        System.out.println("ENTRE COM O NÚMERO DE PARCELAS: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new payPalServices());

        contractService.processContract(objeto,n);
        System.out.println("PARCELAS: ");
        for(Installment installment : objeto.getInstallments()){
            System.out.println(installment);
        }
        sc.close();
    }
}
