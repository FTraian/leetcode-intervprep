package read4_version2;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/436/
 */
public  class SolutionRead4v2 {

    int fp =0;
    char[] lastBuf = new char[4];

    public int read(char[] buf, int n) {
        int copiedChars = 0, readChars;
        char[] buf4 = new char[4];

        while (copiedChars < n) {
            readChars = read4(buf4);

            for (int i = 0; i < readChars; ++i) {
                if (copiedChars == n)
                    return copiedChars;
                buf[copiedChars] = buf4[i];
                ++copiedChars;
            }

        }
        return copiedChars;
    }

    int readSafe(char[] buf, int n) {
        if (lastBuf != null) {
            int i;
            for (i = 0; i < 4 - fp; i++) {
                buf[i] = lastBuf[fp++ + i];
            }
            if (fp == 3) lastBuf = null;
            return i;
        } else {
            return read4(buf);
        }
    }

    int read4(char[] buf4) {
        return -1;
    }
}