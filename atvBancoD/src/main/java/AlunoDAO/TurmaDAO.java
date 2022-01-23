
package AlunoDAO;

import com.mycompany.atvbancod.cadastro.model.Pedagogo;
import com.mycompany.atvbancod.cadastro.model.Turma;
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

public class TurmaDAO {
    public void inserirTurma(Turma a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.turma(disciplina, ano) VALUES(?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getAno());
        comando.setString(2, a.getDisciplina());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Turma: "+a.getAno()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a Turma: "+a.getAno()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List <Turma> listaDeTurma(){
        try {
            String SQL="SELECT disciplina, ano  FROM michael_brendo.turma";
            List <Turma>listaDeTurma = new ArrayList<Turma>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Turma atual=new Turma();
                atual=this.pegaDados(resultado);
                listaDeTurma.add(atual);
            }

            return listaDeTurma;
        } catch (SQLException ex) {
            Logger.getLogger(PedagogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private Turma pegaDados(ResultSet resultado){
        try {
            Turma atual=new Turma();
            atual.setDisciplina (resultado.getString ("disciplina"));
            atual.setAno(resultado.getString("ano"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}
