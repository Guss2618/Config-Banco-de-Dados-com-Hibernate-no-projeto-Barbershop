package Model.DAO;

import Model.Usuario;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario selectPorNomeESenha(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Usuario> query = session.createQuery(
                    "from Usuario u where u.nome = :nome and u.senha = :senha",
                    Usuario.class);
            query.setParameter("nome", usuario.getNome());
            query.setParameter("senha", usuario.getSenha());
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public ArrayList<Usuario> selectAll() {
        return super.selectAll();
    }
}
