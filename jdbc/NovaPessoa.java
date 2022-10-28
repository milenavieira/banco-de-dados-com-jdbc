package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = entrada.next();

        Connection conexao = FabricaConexao.getConexao();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)"; //aqui não se deve passar o parametro de string concatenado para nao haver possibilidade de ataque sql injection, por isso passa a interrogação
        PreparedStatement stmt = conexao.prepareStatement(sql); //o statement é o responsavel por rodar os codigos no sql, e o preparestatement é uma forma mais segura de rodar a partir de métodos especificos para isso
        stmt.setString(1, nome);

        stmt.execute();

        System.out.println("Pessoa incluida com sucesso!");
        entrada.close();
    }
}
