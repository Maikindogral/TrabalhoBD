
package AlunoDAO;

import com.mycompany.atvbancod.cadastro.model.Professor;
import conexao.conexao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProfessorDAO {
    public void inserirProfessor(Professor a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.professor(nome_professor, email, cpf, telefone) VALUES(?,?,?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getNome_professor());
        comando.setString(2, a.getCpf());
        comando.setString(3, a.getEmail());
        comando.setString(4, a.getTelefone());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Professor: "+a.getNome_professor()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aluno: "+a.getNome_professor()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List <Professor> listaDeProfessores(){
        try {
            String SQL="SELECT cpf, email  FROM michael_brendo.professor";
            List <Professor>listaDeProfessores = new ArrayList<Professor>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Professor atual=new Professor();
                atual=this.pegaDados(resultado);
                listaDeProfessores.add(atual);
            }

            return listaDeProfessores;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private Professor pegaDados(ResultSet resultado){
        try {
            Professor atual=new Professor();
            atual.setCpf (resultado.getString ("cpf"));
            atual.setEmail(resultado.getString("email"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    


