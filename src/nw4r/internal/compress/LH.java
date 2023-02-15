package nw4r.internal.compress;

import java.io.File;

/**
 * A utility-class providing the ability to
 * apply <b>LH compression</b>, a compression
 * format found in several <i>Nintendo Wii
 * Games</i>, to a file.
 * <p>
 * <b>LH</b> compression is a combination of
 * the <b>L</b>Z77 and <b>H</b>uffman compression
 * algorithms.
 * <p>
 * The algorithm will first compress the target
 * data using the <i>LZ77</i> algorithm.  Following
 * that, a <i>Huffman</i> compression algorithm
 * is applied to the LZ compressed data, by first
 * building a <i>Huffman Tree</i> for the data
 * and appending it to the head of the file.
 * Then the data is being compressed <b>two times
 * </b> with modified versions of the Huffman
 * algorithm.
 * @implNote
 *     The implementation details are <b>hidden</b>
 *     in the "compress.dll" library.  It is implemented
 *     in C and ported to Java using <b>JNI</b>.
 *     No native Java implementation is provided
 *     due to performance reasons.
 */
public final class LH {
    private static native void compress0(String filePath);
    static {
        System.loadLibrary("compress");
    }

    // No object for you.
    private LH() {}

    /**
     * Compresses the provided file located at the
     * <code>file path</code> with the <b>LH
     * compression</b>.
     *
     * @param filePath The path to compress.
     * @return the compressed file.
     */
    public static File compress(String filePath) {
        compress0(filePath);
        return new File(filePath + ".LH");
    }
}