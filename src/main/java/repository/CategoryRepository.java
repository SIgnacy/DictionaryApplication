package repository;

import command.category.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository implements Repository<Category> {
    List<Category> categories;

    public CategoryRepository() {
        categories = new ArrayList<>();
    }
    @Override
    public void save(Category object){
        categories.add(object);
    }
    @Override
    public void delete(Category object){
        categories.remove(object);
    }
    @Override
    public List<Category> read(){
        return categories;
    }

    @Override
    public List<Category> read(String category) {
        return categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Category> findAll(String category) {
        return read(category);
    }

    @Override
    @Deprecated
    public Optional<Category> findBy(String term, String category) {
        return findBy(category);
    }
    @Override
    public Optional<Category> findBy(String category) {
        return categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(category))
                .findFirst();
    }
}
