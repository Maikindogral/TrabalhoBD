
package Cesta;
import com.mycompany.cadastrodao.Jogador;
import com.mycompany.cadastrodao.model.JogadorDAO;
import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class jogador {
    public void inserirJogador(jogador a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.aluno(nome_jogador, Ncamisa, altura, posicao) VALUES(?,?,?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getNome_jogador());
        comando.setString(2, a.getNcamisa());
        comando.setString(3, a.getAltura());
        comando.setString(4, a.getPosicao());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Nome do Jogador: "+a.getNome_jogador()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Nome do Jogador: "+a.getNome_jogador()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List <Jogador> listaDeJogadores(){
        try {
            String SQL="SELECT Ncamisa, nome_jogador  FROM michael_brendo.aluno";
            List <Jogador>listaDeJogadores = (List <Jogador>) new ArrayList<Jogador>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Jogador atual=new Jogador();
                atual=this.pegaDados(resultado);
                listaDeJogadores.add(atual);
            }

            return listaDeJogadores;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Jogador pegaDados(ResultSet resultado){
        try {
            Jogador atual=new Jogador();
            atual.setNome_jogador (resultado.getString ("nome_jogador"));
            atual.setNcamisa(resultado.getString("Ncamisa"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getNome_jogador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getNcamisa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getAltura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getPosicao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
