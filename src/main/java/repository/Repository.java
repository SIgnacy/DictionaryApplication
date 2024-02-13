package repository;

import exceptions.CustomException;
import exceptions.repository.DeleteFailedException;
import exceptions.repository.ReadFailedException;
import exceptions.repository.SaveFailedException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T> extends Serializable {
    void save(T object) throws SaveFailedException;
    void delete(T object) throws DeleteFailedException;
    List<T> read() throws ReadFailedException;
    List<T> read(String category) throws ReadFailedException;
    List<T> findAll(String name) throws CustomException;
    Optional<T> findBy(String term, String category) throws CustomException;
    Optional<T> findBy(String category) throws CustomException;
}
