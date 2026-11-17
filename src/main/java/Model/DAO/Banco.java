package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

public class Banco {

    public static void inicia() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (!usuarioDAO.selectAll().isEmpty()) {
            return;
        }

        ClienteDAO clienteDAO = new ClienteDAO();
        ServicoDAO servicoDAO = new ServicoDAO();
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        Usuario usuario1 = new Usuario(0, "barbeiro", 'M', "18/07/1990", "30212121", "rafael.novo@fmpsc.edu.br", "521454123", "barbeiro", "administrador");
        Usuario usuario2 = new Usuario(0, "estagiario", 'M', "09/05/1996", "30212122", "jefferson.silva@aluno.fmpsc.edu.br", "451244123", "estagiario", "funcionario");
        Usuario usuario3 = new Usuario(0, "jefferson", 'M', "18/07/1990", "4898823721", "barbeiro@barbershop.com", "12345", "12345", "proprietario");
        Usuario usuario4 = new Usuario(0, "rafaelprofessor", 'M', "18/07/1990", "4898823721", "barbeiro@barbershop.com", "521454123", "12345", "administrador");

        usuarioDAO.insert(usuario1);
        usuarioDAO.insert(usuario2);
        usuarioDAO.insert(usuario3);
        usuarioDAO.insert(usuario4);

        Cliente cliente1 = new Cliente(0, "Alan Figueiredo", 'M', "30/01/1995", "30212126", "rafael.novo@fmpsc.edu.br", "5142487", "Rua jaboti 35 Canudos NH", "93300012");
        Cliente cliente2 = new Cliente(0, "Judite Oliveira", 'F', "30/08/1994", "30212127", "jefferson.silva@aluno.fmpsc.edu.br", "5142487745", "Rua campo bom 78 Centro NH", "93300045");
        Cliente cliente3 = new Cliente(0, "Paulo Ricado", 'M', "24/04/1997", "30212128", "pauloricardopet@gmail.com", "78451458", "Rua Tres Irmaos 30 Vila Nova - NH", "933007496");
        Cliente cliente4 = new Cliente(0, "Neymar Santos", 'M', "20/08/1995", "30212130", "neymarsantospet@gmail.com", "2745487", "Rua Lombardi 40 Canudos NH", "93300748");
        Cliente cliente5 = new Cliente(0, "Debruine Pipoqueiro", 'M', "13/09/1992", "30212131", "debruinepet@gmail.com", "4742487", "Rua pedro quaresma 784 Canudos Belgica", "933000847");
        Cliente cliente6 = new Cliente(0, "Matuidi Pareira", 'M', "17/08/1994", "302122324", "matuidipet@gmail.com", "78512457", "Rua champions 10 Kephas Franca", "933000782");
        Cliente cliente7 = new Cliente(0, "Marta de Souza", 'F', "25/03/1993", "302121292", "martasouzapet@gmail.com", "4658237314", "Rua tesla 215 Canudos NH", "93352012");
        Cliente cliente8 = new Cliente(0, "Aline Ferrari", 'F', "04/03/1990", "302121451", "alineferraripet@gmail.com", "8475123687", "Rua hyrule 32 Canudos NH", "9334714747");
        Cliente cliente9 = new Cliente(0, "Samuel Coltinho", 'M', "09/02/1998", "302121189", "samuelcoltinhopet@gmail.com", "74595142487", "Rua floresta 12 Canudos NH", "9330046364");
        Cliente cliente10 = new Cliente(0, "Felipe Luis", 'M', "12/06/1999", "3021212478", "felipeluispet@gmail.com", "845713647", "Rua marechal 1023 Canudos NH", "933000874");

        clienteDAO.insert(cliente1);
        clienteDAO.insert(cliente2);
        clienteDAO.insert(cliente3);
        clienteDAO.insert(cliente4);
        clienteDAO.insert(cliente5);
        clienteDAO.insert(cliente6);
        clienteDAO.insert(cliente7);
        clienteDAO.insert(cliente8);
        clienteDAO.insert(cliente9);
        clienteDAO.insert(cliente10);

        Servico servico1 = new Servico(0, "Corte Simples", 18);
        Servico servico2 = new Servico(0, "Corte Degrade", 30);
        Servico servico3 = new Servico(0, "Barba Simples", 15);
        Servico servico4 = new Servico(0, "Barba Desenhada", 25);
        Servico servico5 = new Servico(0, "Sombrancelhas", 10);
        Servico servico6 = new Servico(0, "Penteados", 35);

        servicoDAO.insert(servico1);
        servicoDAO.insert(servico2);
        servicoDAO.insert(servico3);
        servicoDAO.insert(servico4);
        servicoDAO.insert(servico5);
        servicoDAO.insert(servico6);

        Agendamento agendamento1 = new Agendamento(0, cliente9, servico6, servico6.getValor(), "28/11/2023 14:00", "cliente vai atrasar");
        Agendamento agendamento2 = new Agendamento(0, cliente3, servico1, servico1.getValor(), "28/11/2023 15:00", "cliente vai atrasar");
        Agendamento agendamento3 = new Agendamento(0, cliente5, servico3, servico3.getValor(), "28/11/2023 16:00", "cliente vai atrasar");

        agendamentoDAO.insert(agendamento1);
        agendamentoDAO.insert(agendamento2);
        agendamentoDAO.insert(agendamento3);
    }
}
