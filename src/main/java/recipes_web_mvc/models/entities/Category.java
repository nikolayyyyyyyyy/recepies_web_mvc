package recipes_web_mvc.models.entities;
import jakarta.persistence.*;
import recipes_web_mvc.models.enums.CategoryType;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private CategoryType categoryType;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Recipe> recipes;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && categoryType == category.categoryType && Objects.equals(description, category.description) && Objects.equals(recipes, category.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryType, description, recipes);
    }
}
