class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            if ((data[i] & 0b1000_0000) == 0) {
                i += 1;
            } else if ((data[i] & 0b1110_0000) == 0b1100_0000) {
                if (i + 1 < data.length && hasSignificant10(data[i + 1])) {
                    i += 2;
                } else {
                    return false;
                }
            } else if ((data[i] & 0b1111_0000) == 0b1110_0000) {
                if (i + 2 < data.length && hasSignificant10(data[i + 1]) && hasSignificant10(data[i + 2])) {
                    i += 3;
                } else {
                    return false;
                }
            } else if ((data[i] & 0b1111_1000) == 0b1111_0000) {
                if (i + 3 < data.length && hasSignificant10(data[i + 1]) && hasSignificant10(data[i + 2]) && hasSignificant10(data[i + 3])) {
                    i += 4;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean hasSignificant10(int v) {
        return (v & 0b1100_0000) == 0b1000_0000;
    }
    }
