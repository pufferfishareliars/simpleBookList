package elie.projects.bookList.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String title;
    private final String author;
    // TODO - tag should be own class
    private List<String> tags;

    // TODO - enforce non-null and non-empty required fieldsl
    private Book(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String toString() {
        return this.title + " by " + this.author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    public static class BookBuilder {
        // required parameters
        private String title;
        private String author;
        // optional parameters
        private List<String> tags = new ArrayList<String>(0);

        public BookBuilder(String title, String author) {
            if(title == null || title.length() == 0 || title.trim().length() == 0 ||
                    author == null || author.length() == 0 || author.trim().length() == 0) {
                throw new IllegalArgumentException("Title and author cannot be null or empty");
            }
        }
        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder addTag(String tag) {
            this.tags.add(tag);
            return this;
        }

        public Book build() {
            return new Book(title, author, tags);
        }
    }
}