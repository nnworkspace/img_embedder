/**
 * 
 */
package nn.img_embedder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 
 * 
 * @author NN
 *
 */
public class ImageEmbedder {

	private String fileUri;
	private ImgCodeType icType;

	public ImageEmbedder(final String fileUri, final ImgCodeType icType) {
		this.fileUri = fileUri;
		this.icType = icType;
	}

	public void generateEmbeddingCode() {
		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileUri))) {
			if (icType.equals(ImgCodeType.MARK_DOWN_GITHUB)) {
				doMarkdownCode(stream);
			} else {
				doHtmlCode(stream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * [![image description](http://smallImg.url)](http://bigImg.url)
	 * 
	 * @param stream
	 */
	private void doMarkdownCode(final Stream<String> stream) {
		final String outUri = fileUri + ".md";

		try (PrintWriter pw = new PrintWriter(outUri, "UTF-8")) {
			stream.forEach((imgUrl) -> {
				StringBuilder url = new StringBuilder(imgUrl);
				StringBuilder sb = new StringBuilder("[![](");

				if ('s' != imgUrl.charAt(4)) {
					// not https, need to insert an s
					url = url.insert(4, 's');
				}

				int suffixBegin = url.lastIndexOf(".");

				sb.append(url.insert(suffixBegin, 'l'));
				sb.append(")](").append(url.deleteCharAt(url.lastIndexOf("l")));
				sb.append(")\n\n\n");

				System.out.println(sb.toString());
				pw.println(sb.toString());
			});
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <a href="bigImage.jpg"> <img src="smallImage.jpg" alt="text" style=
	 * "width:42px;height:42px;border:0;"> </a>
	 * 
	 * @param stream
	 */
	private void doHtmlCode(final Stream<String> stream) {
		final String outUri = fileUri + ".html";

		try (PrintWriter pw = new PrintWriter(outUri, "UTF-8")) {
			stream.forEach((imgUrl) -> {
				StringBuilder url = new StringBuilder(imgUrl);
				StringBuilder sb = new StringBuilder("<a href=\"");

				if ('s' != imgUrl.charAt(4)) {
					// not https, need to insert an s
					url = url.insert(4, 's');
				}
				
				sb.append(url).append("\"> <img src=\"");
				
				int suffixBegin = url.lastIndexOf(".");

				sb.append(url.insert(suffixBegin, 'l'));
				sb.append("\" alt=\"\" title=\"\" >");
				sb.append(" </a> <br />\n<br />\n<br />");

				System.out.println(sb.toString());
				pw.println(sb.toString());
			});
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
