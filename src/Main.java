import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual a quantidade de atletas?");
		int n = sc.nextInt();
		
		double totalPeso = 0.0;
		double totalAltM = 0.0;
		int totalMulheres = 0;
		int totalHomens = 0;
		double maior = 0.0;
		String nomeDoMaior ="nome";
		
		for(int i = 0; i < n; i++) {
			
			System.out.println("Digite os dados do atleta número " + (i+1) + ": ");
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Sexo: ");
			char gen = sc.next().charAt(0);
			while(gen != 'F' && gen != 'M') {
				System.out.print("Valor inválido!Favor digitar F ou M: ");
				gen = sc.next().charAt(0);
			} 
			
			System.out.print("Altura: ");
			double alt = sc.nextDouble();
			while(alt <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				alt = sc.nextDouble();
			}
			
			if(alt > maior) {
				maior = alt;
				nomeDoMaior = nome;
			}
			
			System.out.print("Peso: ");
			double peso = sc.nextDouble();
			while(peso <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			
			totalPeso += peso;
			
			
			if(gen == 'M') {
				
				totalHomens += 1;
				
			}else if(gen == 'F') {
				
				totalMulheres += 1;
				totalAltM += alt;
			}
			
			
		}
		
		double pesoMedioAtl = totalPeso/n;
		double PercentualH = (double)100 * totalHomens/n;
		double altMediaM = totalAltM / totalMulheres;
		
		System.out.println();
		System.out.println("RELATÓRIO: ");
		System.out.printf("Peso médio dos atletas %.2f%n", pesoMedioAtl);
		System.out.println("Atleta mais alto: " + nomeDoMaior);
		System.out.printf("Porcentagem de homens: %.1f %% %n", PercentualH);
		
		if(totalMulheres < 1) {
			System.out.println("Não há mulheres cadastradas.");
		} else {
			System.out.printf("Altura média das mulheres: %.2f%n", altMediaM);
		}
		
		
		sc.close();

	}

}
