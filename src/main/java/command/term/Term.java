package command.term;

import command.category.Category;

import java.io.Serializable;
import java.util.Objects;

public class Term implements Serializable {
    public static final int TERM_MAX_SIZE = 100;
    public static final int DESCRIPTION_MAX_SIZE = 500;
    Category category;
    String term;
    String description;

    public Term(Category category, String term, String description) {
        this.category = category;
        this.term = term;
        this.description = description;
    }


    public void setTerm(String term) {
        this.term = term;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTerm() {
        return term;
    }

    public String getCategoryName() {
        return category.getName();
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term1 = (Term) o;
        return Objects.equals(category, term1.category) && Objects.equals(term, term1.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, term);
    }

    @Override
    public String toString() {
        String[] descriptionSplit = description.split(" ");
        StringBuilder descriptionStringBuilder = new StringBuilder();
        for(int i = 0; i < descriptionSplit.length; i++){
            descriptionStringBuilder.append(descriptionSplit[i]).append(" ");
            if(i % 15 == 0 && i != 0)
                descriptionStringBuilder.append("\n").append(descriptionSplit[i]);
        }
        return term + "\n" + descriptionStringBuilder.toString();
    }
}
