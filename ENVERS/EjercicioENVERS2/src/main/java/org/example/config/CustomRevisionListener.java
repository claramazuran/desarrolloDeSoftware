package config;
import audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    //este metodo lo que hace es recibir a la entidad para hacerle la revision
    public void newRevision (Object revisionEntity) {
        //creamos una revision, y transformamos el objeto en una revision
        final Revision revision = (Revision) revisionEntity;
    }
}