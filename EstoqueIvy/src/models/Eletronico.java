package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Eletronico extends Produto {

	public String marca;
	public String modelo;

	public Eletronico(int codigo, String nome, String descricao, int quant, double preco, String marca, String modelo) {
		super(codigo, nome, descricao, quant, preco);
		this.marca = marca;
		this.modelo = modelo;
	}

	public Eletronico() {
		// TODO Auto-generated constructor stub
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String exibirInfo() {
		return super.exibirInfo() + ", Marca: " + marca + ", Modelo: " + modelo;
	}

	public void gravaEstoque() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt", true))) {
			writer.write(exibirInfo());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exibirEstoque() {
		try (BufferedReader reader = new BufferedReader(new FileReader("estoque.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void EletronicoAdd() {
		do {
			System.out.println("Digite um codigo: ");
			try {
				setCodigo(sc.nextInt());
			} catch (Exception e) {
				System.err.println("O código deve ser positivo");
				sc.nextLine();
			}
		} while (getCodigo() < 1);
		setCodigo(sc.nextInt());
		System.out.println("Digite um nome: ");
		setNome(sc.next());
		System.out.println("Digite uma descrição: ");
		setDescricao(sc.next());
		do {
			System.out.print("Digite a quantidade de produtos: ");
			try {
				setQuantidade(sc.nextInt());
			} catch (Exception e) {
				System.err.println("Apenas números inteiros...");
				sc.nextLine();
			}
		} while (getQuantidade() < 1);

		do {
			System.out.print("Digite um preço dos produto: ");
			try {
				setPreco(sc.nextInt());
			} catch (Exception e) {
				System.err.println("O preço deve ser positivo");
				sc.nextLine();
			}
		} while (getPreco() < 1);
		System.out.print("Modelo do eletronico: ");
		setModelo(sc.next());
		System.out.print("Marca do eletronico: ");
		setMarca(sc.next());

		gravaEstoque();
	}

}