package it.blackhat.symposium.integration;

import it.blackhat.symposium.managers.TagManager;
import it.blackhat.symposium.managers.TagModelManager;
import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author SDelPiano
 */
public class TagManagerTest extends IntegrationTestCase {

    private TagManager tagManager;

    @Before
    public void setUp() {
        this.tagManager = new TagModelManager(IntegrationTestCase.mockDbDatasource);

    }


    @Test
    public void updateTagTest() throws SQLException {

        this.tagManager.updateTag("esame", 29, 177);
        List<Tag> actual = this.tagManager.retrieveQuestionTags(29);
        boolean b1 = actual.get(0).getId() == 21;
        boolean b2 = actual.get(1).getId() == 178;
        Assert.assertTrue(b1 && b2);
    }

    @Test
    public void deleteTagTest() throws SQLException {
        Assert.assertTrue(this.tagManager.deleteTag(22) == 1);
    }

    @Test
    public void testFindTag() throws SQLException {
        Optional<Tag> tag = this.tagManager.findTag("esame");
        Assert.assertTrue(tag.isPresent());
    }


    @Test
    public void testFindTag2() throws SQLException {
        Optional<Tag> tag = this.tagManager.findTag("cane");
        Assert.assertFalse(tag.isPresent());
    }


    @Test
    public void retrieveQuestionTagsTest() throws SQLException {
        List<Tag> actual = this.tagManager.retrieveQuestionTags(29);
        boolean b1 = actual.get(0).getId() == 177;
        boolean b2 = actual.get(1).getId() == 178;
        Assert.assertTrue(b1 && b2);

    }


    @Test
    public void mostUsedTagsTest() throws SQLException {

        Map<String, Integer> actual = this.tagManager.mostUsedTags(2019);
        Assert.assertEquals(6, actual.get("esame").intValue());
    }

    @Ignore
    public void insertTagTest() throws SQLException {
        Tag tag = new TagModel(21, "gatto");
        this.tagManager.insertTag(tag);
        Assert.assertTrue(tagManager.findTag("gatto").isPresent());
    }


}


