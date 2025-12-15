package daoImp.Hib;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.INotasDAO;
import dto.NotaDTO;
import entities.AlumnoEntity;
import entities.AsignaturasEntity;
import entities.NotasEntity;
import utils.DBUtils;

public class NotasDAOImplHib implements INotasDAO {

    private SessionFactory factory;

    public NotasDAOImplHib() {
        this.factory = DBUtils.creadorSessionFactory(); 
    }

    @Override
    public ArrayList<NotaDTO> obtenerTodasNotas() {
        Session s = factory.openSession();
        Transaction tx = null;
        ArrayList<NotaDTO> lista = new ArrayList<>();

        try {
            tx = s.beginTransaction();
            String hql = "SELECT new dto.NotaDTO(n.id, n.nota, n.fecha, al.id, al.nombre, a.id, a.nombre) " +
                         "FROM NotasEntity n " +
                         "JOIN n.alumno al " +
                         "JOIN n.asignatura a";
            Query<NotaDTO> query = s.createQuery(hql, NotaDTO.class);
            lista = new ArrayList<>(query.getResultList());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return lista;
    }

    @Override
    public ArrayList<NotaDTO> obtenerNotasPorFiltros(
            String idAlumno, String nombreAlumno, String asignatura,
            String nota, String fecha, int activo) {

        Session s = factory.openSession();
        Transaction tx = null;
        ArrayList<NotaDTO> lista = new ArrayList<>();

        try {
            tx = s.beginTransaction();

            String hql =
                    "SELECT new dto.NotaDTO(n.id, n.nota, n.fecha, al.id, al.nombre, a.id, a.nombre) " +
                    "FROM NotasEntity n " +
                    "JOIN n.alumno al " +
                    "JOIN n.asignatura a " +
                    "WHERE (:idAlumno = '' OR str(al.id) LIKE :idAlumno) " +
                    "AND al.nombre LIKE :nombreAlumno " +
                    "AND a.nombre LIKE :asignatura " +
                    "AND n.nota LIKE :nota " +
                    "AND n.fecha >= :fecha " +
                    "AND al.activo = :activo";

            Query<NotaDTO> query = s.createQuery(hql, NotaDTO.class)
                    .setParameter("idAlumno", "%" + idAlumno + "%")
                    .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
                    .setParameter("asignatura", "%" + asignatura + "%")
                    .setParameter("nota", "%" + nota + "%")
                    .setParameter("fecha", fecha)
                    .setParameter("activo", activo);

            lista = new ArrayList<>(query.getResultList());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return lista;
    }

    @Override
    public ArrayList<NotaDTO> obtenerNotasPorFiltrosSinFecha(
            String idAlumno, String nombreAlumno, String asignatura,
            String nota, int activo) {

        Session s = factory.openSession();
        Transaction tx = null;
        ArrayList<NotaDTO> lista = new ArrayList<>();

        try {
            tx = s.beginTransaction();

            String hql =
            	    "SELECT new dto.NotaDTO(" +
            	    "n.id, n.nota, n.fecha, " +
            	    "al.id, al.nombre, " +
            	    "a.id, a.nombre) " +
            	    "FROM NotasEntity n " +
            	    "JOIN n.alumno al " +
            	    "JOIN n.asignatura a " +
            	    "WHERE (:idAlumno = '' OR str(al.id) LIKE :idAlumno) " +
            	    "AND al.nombre LIKE :nombreAlumno " +
            	    "AND a.nombre LIKE :asignatura " +
            	    "AND n.nota LIKE :nota " +
            	    "AND al.activo = :activo";

            Query<NotaDTO> query = s.createQuery(hql, NotaDTO.class)
                .setParameter("idAlumno", "%" + idAlumno + "%")
                .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
                .setParameter("asignatura", "%" + asignatura + "%")
                .setParameter("nota", "%" + nota + "%")
                .setParameter("activo", activo);

            lista = new ArrayList<>(query.getResultList());
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return lista;
    }


    @Override
    public int insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
        Session s = factory.openSession();
        Transaction tx = null;
        Integer idPk = null;

        try {
            tx = s.beginTransaction();

            AlumnoEntity alumno = s.get(AlumnoEntity.class, Integer.parseInt(idAlumno));
            AsignaturasEntity asignatura = s.get(AsignaturasEntity.class, Integer.parseInt(idAsignatura));

            if (alumno == null) throw new RuntimeException("Alumno con id " + idAlumno + " no encontrado");
            if (asignatura == null) throw new RuntimeException("Asignatura con id " + idAsignatura + " no encontrada");

            NotasEntity n = new NotasEntity(alumno, asignatura, nota, fecha);
            idPk = (Integer) s.save(n); 

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        if (idPk == null) {
            throw new RuntimeException("No se pudo insertar la nota");
        }
        return idPk;
    }

    @Override
    public int actualizarNota(String id, String idAlumno, String idAsignatura, String nota, String fecha) {
        Session s = factory.openSession();
        Transaction tx = null;
        int idReturn = 0;

        try {
            tx = s.beginTransaction();

            NotasEntity n = s.get(NotasEntity.class, Integer.parseInt(id));
            if (n == null) throw new RuntimeException("Nota con id " + id + " no encontrada");

            AlumnoEntity alumno = s.get(AlumnoEntity.class, Integer.parseInt(idAlumno));
            AsignaturasEntity asignatura = s.get(AsignaturasEntity.class, Integer.parseInt(idAsignatura));

            if (alumno == null) throw new RuntimeException("Alumno con id " + idAlumno + " no encontrado");
            if (asignatura == null) throw new RuntimeException("Asignatura con id " + idAsignatura + " no encontrada");

            n.setAlumno(alumno);
            n.setAsignatura(asignatura);
            n.setNota(nota);
            n.setFecha(fecha);

            s.update(n);
            tx.commit();
            idReturn = n.getId();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return idReturn;
    }

    @Override
    public int borrarNota(String id) {
        Session s = factory.openSession();
        Transaction tx = null;
        int idReturn = 0;

        try {
            tx = s.beginTransaction();

            NotasEntity n = s.get(NotasEntity.class, Integer.parseInt(id));
            if (n == null) throw new RuntimeException("Nota con id " + id + " no encontrada");

            s.delete(n);
            tx.commit();
            idReturn = n.getId(); 
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return idReturn;
    }

}
