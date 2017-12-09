/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author estagiario
 */
public class MetodoDB {

    private Connection conn;

    public MetodoDB() {

        conn = ConnectionFactory.getConnection();

    }

    public void insert(Jogador jogador) {

        try {

            String sql = "insert into jogador (nome,palitos,aposta) values (?,?,?) ";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, jogador.getPalitos());
            stmt.setInt(3, jogador.getAposta());

            stmt.execute();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }

    public boolean todosJogaram() {

        try {

            String sql = "select count(*) from jogador where aberto = 0 ";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            int count = rs.getInt(1);

            return count >= Servidor.qtJogadores;

        } catch (SQLException ex) {

            System.out.println(ex);
        }

        return false;

    }

    public int contaPalitos() {

        try {

            String sql = "select sum(palitos) from jogador where aberto = 0 ";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            int soma = rs.getInt(1);

            return soma;

        } catch (SQLException ex) {

            System.out.println(ex);
        }

        return 0;

    }

    public Jogador retornaGanhador(int soma) {

        try {

            String sql = "select id,nome from jogador where aberto = 0 and aposta = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, soma);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Jogador jogador = new Jogador();

                jogador.setId(rs.getInt(1));
                jogador.setNome(rs.getString(2));

                return jogador;

            }

        } catch (SQLException ex) {

            System.out.println(ex);
        }

        return null;

    }
    
    public void finalizaJogada() {

        try {

            String sql = "update jogador set aberto =1 ";

            PreparedStatement stmt = conn.prepareStatement(sql);

           

            stmt.execute();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }

}
