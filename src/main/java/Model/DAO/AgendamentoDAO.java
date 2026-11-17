package Model.DAO;

import Model.Agendamento;
import java.util.ArrayList;
import org.hibernate.Session;

public class AgendamentoDAO extends GenericDAO<Agendamento> {

    public AgendamentoDAO() {
        super(Agendamento.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Agendamento> selectAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return new ArrayList<>(session.createQuery(
                    "from Agendamento a join fetch a.cliente join fetch a.servico order by a.id")
                    .list());
        } finally {
            session.close();
        }
    }
}
