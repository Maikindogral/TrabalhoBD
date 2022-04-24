
package Cesta;
import com.mycompany.cadastrodao.Time;
import com.mycompany.cadastrodao.model.TimeDAO;
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
public class time {
    public void inserirTime(time a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.aluno(nome_time, Njogadores, nome_tecnico) VALUES(?,?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getNome_time());
        comando.setString(2, a.getNjogadores());
        comando.setString(4, a.getNome_tecnico());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Nome do time: "+a.getNome_time()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Nome do time: "+a.getNome_time()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List <Time> listaDeTimes(){
        try {
            String SQL="SELECT Njogadores, nome_time  FROM michael_brendo.aluno";
            List <Time>listaDeTimes = (List <Time>) new ArrayList<Time>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Time atual=new Time();
                atual=this.pegaDados(resultado);
                listaDeTimes.add(atual);
            }

            return listaDeTimes;
        } catch (SQLException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Time pegaDados(ResultSet resultado){
        try {
            Time atual=new Time();
            atual.setNome_time (resultado.getString ("nome_time"));
            atual.setNjogadores(resultado.getString("NJogadores"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private String getNome_time() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getNjogadores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getNome_tecnico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
