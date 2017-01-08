package elie.projects.bookList.models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void cantCreateBookWithNullTitleAndAuthor() {
        try {
            Book noTitle = new Book.BookBuilder(null, null).build();
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Successfully instantiated a book without a title or author");
    }

    @Test
    public void cantCreateBookWithEmptyTitleAndAuthor() {
        try {
            Book noTitle = new Book.BookBuilder("", "").build();
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("Successfully instantiated a book with an empty title and author");
    }

    @Test
    public void canSetTagsOnBook() {
        final String tag1 = "politics";
        final String tag2 = "history";
        final String tagNotFound = "geography";
        final int numTags = 2;
        Book bookWithTags = new Book.BookBuilder("End of history: and the last man", "Francis Fukuyama")
                .addTag(tag1)
                .addTag(tag2)
                .build();
        List<String> tags = bookWithTags.getTags();
        assertEquals(numTags, tags.size());
        assertTrue(tags.contains(tag1));
        assertTrue(tags.contains(tag2));
        assertFalse(tags.contains(tagNotFound));
    }
}