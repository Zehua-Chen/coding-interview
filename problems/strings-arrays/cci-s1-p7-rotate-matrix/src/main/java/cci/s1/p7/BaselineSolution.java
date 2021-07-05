package cci.s1.p7;

public class BaselineSolution implements Solution {
    @Override
    public void rotate(int[][] image) {
        int[][] buffer = new int[image.length][];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = new int[image[i].length];
        }

        int readX = image[0].length - 1;
        int writeY = 0;

        while (readX >= 0) {
            int readY = 0;
            int writeX = 0;

            while (readY < image.length) {
                buffer[writeY][writeX] = image[readY][readX];
                writeX++;
                readY++;
            }

            writeY++;
            readX--;
        }

        for (int i = 0; i < buffer.length; i++) {
            System.arraycopy(buffer[i], 0, image[i], 0, buffer[i].length);
        }
    }
}
