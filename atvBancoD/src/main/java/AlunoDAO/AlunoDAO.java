
package AlunoDAO;
import com.mycompany.atvbancod.cadastro.model.Aluno;
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
public class AlunoDAO {
    public void inserirAluno(Aluno a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.aluno(nome_aluno, email, disciplina, ano) VALUES(?,?,?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getNome_aluno());
        comando.setString(2, a.getEmail());
        comando.setString(3, a.getDisciplina());
        comando.setString(4, a.getAno());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Aluno: "+a.getNome_aluno()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aluno: "+a.getNome_aluno()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List <Aluno> listaDeAlunos(){
        try {
            String SQL="SELECT email, nome_aluno  FROM michael_brendo.aluno";
            List <Aluno>listaDeAlunos = new ArrayList<Aluno>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Aluno atual=new Aluno();
                atual=this.pegaDados(resultado);
                listaDeAlunos.add(atual);
            }

            return listaDeAlunos;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Aluno pegaDados(ResultSet resultado){
        try {
            Aluno atual=new Aluno();
            atual.setNome_aluno (resultado.getString ("nome_aluno"));
            atual.setEmail(resultado.getString("email"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
