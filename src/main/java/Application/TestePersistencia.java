package Application;

import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.Banco;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.DAO.UsuarioDAO;
import Model.Servico;
import Model.Usuario;
import java.util.ArrayList;

public class TestePersistencia {

    public static void main(String[] args) {
        Banco.inicia();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario autenticado = usuarioDAO.selectPorNomeESenha(new Usuario(0, "barbeiro", "barbeiro"));
        System.out.println("Login: " + (autenticado != null ? autenticado.getNome() : "FALHOU"));

        ClienteDAO clienteDAO = new ClienteDAO();
        ServicoDAO servicoDAO = new ServicoDAO();
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        System.out.println("Clientes: " + clientes.size());
        System.out.println("Servicos: " + servicos.size());

        Agendamento novo = new Agendamento(0, clientes.get(0), servicos.get(0),
                servicos.get(0).getValor(), "16/11/2026 18:30", "teste hibernate");
        agendamentoDAO.insert(novo);

        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        System.out.println("Agendamentos: " + agendamentos.size());
        for (Agendamento a : agendamentos) {
            System.out.println(a.getId() + " | " + a.getCliente().getNome() + " | "
                    + a.getServico().getDescricao() + " | " + a.getDataFormatada() + " " + a.getHoraFormatada());
        }
        System.out.println("OK");
    }
}
