package Model.DAO;

import Model.Agendamento;
import Model.Usuario;
import java.util.ArrayList;

public class TesteHibernate {
    public static void main(String[] args) {
        Banco.inicia();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario busca = new Usuario(0, "barbeiro", "barbeiro");
        Usuario auth = usuarioDAO.selectPorNomeESenha(busca);
        System.out.println("LOGIN=" + (auth != null ? auth.getNome() : "FALHOU"));
        ArrayList<Agendamento> lista = new AgendamentoDAO().selectAll();
        System.out.println("AGENDAMENTOS=" + lista.size());
        for (Agendamento a : lista) {
            System.out.println(a.getId() + " | " + a.getCliente().getNome() + " | " + a.getServico().getDescricao() + " | " + a.getDataFormatada());
        }
        System.out.println("OK");
        HibernateUtil.getSessionFactory().close();
        System.exit(0);
    }
}
