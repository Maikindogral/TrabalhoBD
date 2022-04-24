
package Cesta;
import com.mycompany.cadastrodao.model.CestaDAO;
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
public class Cesta {
    public void inserirCesta(Cesta a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.aluno(estadio,timeVencedor) VALUES(?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getEstadio());
        comando.setString(2, a.getTimeVencedor());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Time Vencedor: "+a.getTimeVencedor()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Time Vencedor: "+a.getTimeVencedor()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List <Cesta> listaDeTimes(){
        try {
            String SQL="SELECT TimeVencedor  FROM michael_brendo.aluno";
            List <Cesta>listaDeTimesVenccedores = (List <Cesta>) new ArrayList<Cesta>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Cesta atual=new Cesta();
                atual=this.pegaDados(resultado);
                listaDeTimesVenccedores.add(atual);
            }

            return listaDeTimesVenccedores;
        } catch (SQLException ex) {
            Logger.getLogger(CestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Cesta pegaDados(ResultSet resultado){
        try {
            Cesta atual=new Cesta();
            atual.setTimeVencedor (resultado.getString ("timeVencedor"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(CestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private String getTimeVencedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTimeVencedor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getEstadio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
