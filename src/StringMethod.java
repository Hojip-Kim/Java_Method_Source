import java.util.Arrays;

public class StringMethod {

    private static final String stringArray = "[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]";

    // '['와, ']'와 같은 형태로 제공되는 이중배열 형태의 string값을 이중배열 int의 형태로 리턴합니다.
    private static int[][] SquareBracketToCurlyBrace(String squareBracketArray){
        String parsedStr = squareBracketArray.replace("[[", "").replace("]]", "").replaceAll("].\\[", "|");

        String[] parsedStringArray = parsedStr.split("\\|");

        int[][] intArray = new int[parsedStringArray.length][];

        for (int i = 0; i < parsedStringArray.length; i++) {

            String[] stringArray = parsedStringArray[i].split(",");

            int[] array = new int[stringArray.length];

            for(int j = 0; j < stringArray.length; j++){
                array[j] = Integer.parseInt(stringArray[j]);
            }
            intArray[i] = array;

        }
        return intArray;
    }

    public static void main(String[] args) {
        // SquareBracketToCurlyBrace 메소드 테스트
        int[][] intArray = SquareBracketToCurlyBrace(stringArray);

        StringBuilder sb = new StringBuilder();

        for(int[] intElemArr : intArray){
            sb.append(Arrays.toString(intElemArr) + "\n");
            /*
            * result
            * [4, 5]
            * [4, 8]
            * [10, 14]
            * [11, 13]
            * [5, 12]
            * [3, 7]
            * [1, 4]
            * */
        }

    }

}
