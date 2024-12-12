package social.media.platform.wordsCounter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class UniqueWordsCounter {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/java/social/media/platform/WordsCounter/input.txt");
        File outputFile = new File("src/main/java/social/media/platform/WordsCounter/output.txt");

       String content = FileUtils.readFileToString(inputFile, "UTF-8");

        String[] words = StringUtils.split(content, " \n\r\t.,!?;: ");
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        /*Set<String> uniqueWords = Arrays.stream(StringUtils.split(content, " \n\r\t.,!?;: "))
                .map(String::toLowerCase).collect(Collectors.toSet());*/

        FileUtils.writeStringToFile(outputFile, " Number of unique words: " + uniqueWords.size(), "UTF-8" );

        System.out.println("The result is written to a file: " + outputFile.getAbsolutePath());

    }
}
