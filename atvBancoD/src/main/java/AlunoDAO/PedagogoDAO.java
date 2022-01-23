
package AlunoDAO;
import com.mycompany.atvbancod.cadastro.model.Pedagogo;
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

public class PedagogoDAO {
    public void inserirPedagogo(Pedagogo a)
    {
        try{
        String SQL = "INSERT INTO michael_brendo.pedagogo(nome_pedagogo, email, cpf, telefone, senha) VALUES(?,?,?,?,?)";
        Connection minhaConexao = conexao.getConexao();
        PreparedStatement comando = minhaConexao.prepareStatement(SQL);
        comando.setString(1, a.getNome_pedagogo());
        comando.setString(2, a.getCpf());
        comando.setString(3, a.getEmail());
        comando.setString(4, a.getTelefone());
        comando.setInt(5,a.getSenha());
        int retorno = comando.executeUpdate();
        if(retorno>0)
        {
            JOptionPane.showMessageDialog(null, "Pedagogo: "+a.getNome_pedagogo()+" Cadastrado com Sucesso!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Aluno: "+a.getNome_pedagogo()+" Verifique os Logs");
        }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(PedagogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List <Pedagogo> listaDePedagogos(){
        try {
            String SQL="SELECT email, senha  FROM michael_brendo.pedagogo";
            List <Pedagogo>listaDePedagogos = new ArrayList<Pedagogo>();
            Connection c =conexao.getConexao();
            PreparedStatement ps=c.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Pedagogo atual=new Pedagogo();
                atual=this.pegaDados(resultado);
                listaDePedagogos.add(atual);
            }

            return listaDePedagogos;
        } catch (SQLException ex) {
            Logger.getLogger(PedagogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private Pedagogo pegaDados(ResultSet resultado){
        try {
            Pedagogo atual=new Pedagogo();
            atual.setEmail (resultado.getString ("email"));
            atual.setSenha(resultado.getInt("senha"));
            return atual;
        } catch (SQLException ex) {
            Logger.getLogger(PedagogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}