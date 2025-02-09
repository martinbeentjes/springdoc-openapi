package org.springdoc.core.converters;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NotNull
public class Pageable {

    @NotNull
    @Min(0)
    private int page;

    @NotNull
    @Min(1)
    @Max(2000)
    private int size;

    private List<String> sort = new ArrayList<>() ;

    public Pageable(@NotNull @Min(0) int page, @NotNull @Min(1) @Max(2000) int size, List<String> sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        if (sort == null) {
            this.sort.clear();
        }
        this.sort = sort;
    }

    public void addSort(String sort) {
        this.sort.add(sort);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pageable pageable = (Pageable) o;
        return page == pageable.page &&
                size == pageable.size &&
                Objects.equals(sort, pageable.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size, sort);
    }

    @Override
    public String toString() {
        return "Pageable{" +
                "page=" + page +
                ", size=" + size +
                ", sort=" + sort +
                '}';
    }
}