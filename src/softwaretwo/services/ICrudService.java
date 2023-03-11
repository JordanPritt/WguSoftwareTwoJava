package softwaretwo.services;

import java.util.List;

/**
 * Generic interface for defining common CRUD operations.
 *
 * @param <T> the type the service will handle.
 */
public interface ICrudService<T> {
    /**
     * Gets T by and id.
     *
     * @param id the id used to retrieve a T by.
     * @throws Exception the exception caught.
     */
    public T get(int id) throws Exception;

    /**
     * Gets a list of T.
     *
     * @throws Exception the exception caught.
     */
    public List<T> getAll() throws Exception;

    /**
     * Creates a T.
     *
     * @param t the T to create.
     * @throws Exception the exception caught.
     */
    public void create(T t) throws Exception;

    /**
     * Updates a T.
     *
     * @param t the T to update.
     * @throws Exception the exception caught.
     */
    public void update(T t) throws Exception;

    /**
     * Deletes T.
     *
     * @param t the T to delete.
     * @throws Exception the exception caught.
     */
    public void delete(T t) throws Exception;
}
