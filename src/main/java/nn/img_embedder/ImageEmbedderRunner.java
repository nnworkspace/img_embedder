/**
 * 
 */
package nn.img_embedder;

/**
 * @author NN
 *
 */
public class ImageEmbedderRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String fileUri = args[0];

		ImgCodeType icType;

		System.out.println("args_1 is: " + (args.length > 1 ? args[1] : "null"));
		
		final String format = args.length > 1 ? args[1] : "md";

		switch (format) {
		case "md":
			icType = ImgCodeType.MARK_DOWN_GITHUB;
			break;
		case "html":
			icType = ImgCodeType.HTML;
			break;
		default:
			icType = ImgCodeType.MARK_DOWN_GITHUB;
		}

		// boolean clickable = args[3].equalsIgnoreCase("true") ? true : false;

		ImageEmbedder ie = new ImageEmbedder(fileUri, icType);

		ie.generateEmbeddingCode();
	}

}
