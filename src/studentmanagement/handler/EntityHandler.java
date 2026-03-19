package studentmanagement.handler;

public interface EntityHandler<T> {

 int fetchKey(T entity);

 T decodeRecord(String data);

 String composeRecord(T entity);

}
