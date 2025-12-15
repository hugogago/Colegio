package daoImp.Hib;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.IMatriculacionesDAO;
import dto.MatriculacionDTO;
import entities.AlumnoEntity;
import entities.AsignaturasEntity;
import entities.MatriculacionEntity;
import entities.CajaEntity;
import utils.DBUtils;

public class MatriculacionesDAOImplHib implements IMatriculacionesDAO {

    private final SessionFactory factory;

    public MatriculacionesDAOImplHib() {
        this.factory = DBUtils.creadorSessionFactory();
    }

    @Override
    public String obtenerTasaAsignatura(String idAsignatura) {
        Session s = factory.openSession();
        Transaction tx = null;
        String tasa = "";

        try {
            tx = s.beginTransaction();
            AsignaturasEntity asignatura = s.get(AsignaturasEntity.class, Integer.parseInt(idAsignatura));
            if (asignatura != null && asignatura.getActivo() == 1) {
                tasa = asignatura.getTasa();
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return (String) tasa;
    }

    @Override
    public int insertarMatriculacion(String idAsignatura, String idAlumno, String fecha, String tasa) {
        Session s = factory.openSession();
        Transaction tx = null;
        Integer idPk = null;

        try {
            tx = s.beginTransaction();

            AlumnoEntity alumno = s.get(AlumnoEntity.class, Integer.parseInt(idAlumno));
            AsignaturasEntity asignatura = s.get(AsignaturasEntity.class, Integer.parseInt(idAsignatura));

            MatriculacionEntity m = new MatriculacionEntity();
            m.setAlumno(alumno);
            m.setAsignatura(asignatura);
            m.setFecha(Integer.parseInt(fecha));
            m.setActivo(1);

            idPk = (Integer) s.save(m);

            CajaEntity caja = new CajaEntity();
            caja.setMatricula(m);
            caja.setImporte(Double.parseDouble(tasa));
            s.save(caja);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return idPk;
    }

    @Override
    public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltros(String nombreAsignatura, String nombreAlumno,
            String fecha, int activo) {

        Session s = factory.openSession();
        Transaction tx = null;
        ArrayList<MatriculacionDTO> lista = new ArrayList<>();

        try {
            tx = s.beginTransaction();

            String hql = "SELECT new dto.MatriculacionDTO("
                       + "m.id, m.asignatura.id, m.asignatura.nombre, "
                       + "m.alumno.id, m.alumno.nombre, "
                       + "m.fecha, m.activo, caja.importe) "
                       + "FROM MatriculacionEntity m "
                       + "LEFT JOIN m.caja caja "
                       + "WHERE m.asignatura.nombre LIKE :nombreAsignatura "
                       + "AND m.alumno.nombre LIKE :nombreAlumno "
                       + "AND m.fecha >= :fecha "
                       + "AND m.activo = :activo";

            Query<MatriculacionDTO> query = s.createQuery(hql, MatriculacionDTO.class)
                    .setParameter("nombreAsignatura", "%" + nombreAsignatura + "%")
                    .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
                    .setParameter("fecha", Integer.parseInt(fecha))
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
    public ArrayList<MatriculacionDTO> obtenerMatriculacionesPorFiltrosSinFecha(String nombreAsignatura,
            String nombreAlumno, int activo) {

        Session s = factory.openSession();
        Transaction tx = null;
        ArrayList<MatriculacionDTO> lista = new ArrayList<>();

        try {
            tx = s.beginTransaction();

            String hql = "SELECT new dto.MatriculacionDTO("
                       + "m.id, m.asignatura.id, m.asignatura.nombre, "
                       + "m.alumno.id, m.alumno.nombre, "
                       + "m.fecha, m.activo, caja.importe) "
                       + "FROM MatriculacionEntity m "
                       + "LEFT JOIN m.caja caja "
                       + "WHERE m.asignatura.nombre LIKE :nombreAsignatura "
                       + "AND m.alumno.nombre LIKE :nombreAlumno "
                       + "AND m.activo = :activo";

            Query<MatriculacionDTO> query = s.createQuery(hql, MatriculacionDTO.class)
                    .setParameter("nombreAsignatura", "%" + nombreAsignatura + "%")
                    .setParameter("nombreAlumno", "%" + nombreAlumno + "%")
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
    public int actualizarMatriculacion(String id, String idAsignatura, String idAlumno, String fecha, String tasa) {
        Session s = factory.openSession();
        Transaction tx = null;
        int idReturn = 0;

        try {
            tx = s.beginTransaction();

            MatriculacionEntity m = s.get(MatriculacionEntity.class, Integer.parseInt(id));
            if (m == null) throw new RuntimeException("Matriculación con id " + id + " no encontrada");

            AlumnoEntity alumno = s.get(AlumnoEntity.class, Integer.parseInt(idAlumno));
            AsignaturasEntity asignatura = s.get(AsignaturasEntity.class, Integer.parseInt(idAsignatura));

            m.setAlumno(alumno);
            m.setAsignatura(asignatura);
            m.setFecha(Integer.parseInt(fecha));

            CajaEntity caja = m.getCaja();
            if (caja != null) caja.setImporte(Double.parseDouble(tasa));

            s.update(m);
            if (caja != null) s.update(caja);

            tx.commit();
            idReturn = m.getId();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return idReturn;
    }

    @Override
    public int borrarMatriculacion(String id) {
        Session s = factory.openSession();
        Transaction tx = null;
        int idReturn = 0;

        try {
            tx = s.beginTransaction();

            MatriculacionEntity m = s.get(MatriculacionEntity.class, Integer.parseInt(id));
            if (m == null) throw new RuntimeException("Matriculación con id " + id + " no encontrada");

            CajaEntity caja = m.getCaja();
            if (caja != null) s.delete(caja);

            s.delete(m);

            tx.commit();
            idReturn = Integer.parseInt(id);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }

        return idReturn;
    }
}
