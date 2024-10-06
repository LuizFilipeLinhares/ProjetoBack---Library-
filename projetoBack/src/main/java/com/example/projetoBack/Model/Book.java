package com.example.projetoBack.Model;

import java.util.UUID;

public class Book {
    private UUID id;
    private DataBooks[] docs;

    public Book(DataBooks[] docs, UUID id) {
        this.docs = docs;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DataBooks[] getDocs() {
        return docs;
    }

    public void setDocs(DataBooks[] docs) {
        this.docs = docs;
    }
}
