package nn.img_embedder.test;

import org.junit.Test;
import nn.img_embedder.ImageEmbedder;
import nn.img_embedder.ImgCodeType;

import static org.junit.Assert.*;

/*
 *
 * @author NN, @date 11/1/16 4:08 PM
 */
public class ImageEmbedderTest {
    @Test public void testInit() {
        ImageEmbedder ie = new ImageEmbedder("test_urls", ImgCodeType.MARK_DOWN_GITHUB);
        assertTrue("The embedder should be initialized", ie != null);
    }
}
