package eu.ciechanowiec.htmltutorial;
import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
@Slf4j
class SamplePrinter {
    void performSamplePrint(String fileName) {
        InputStream fileFromResourcesAsStream = getFileFromResourcesAsStream(fileName);
        printInputStream(fileFromResourcesAsStream);
    }
    private InputStream getFileFromResourcesAsStream(String fileName) {
        Class<? extends SamplePrinter> samplePrinterClass = this.getClass();
        ClassLoader classLoader = samplePrinterClass.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException(String.format("File '%s' wasn't found!", fileName));
        } else {
            return inputStream;
        }
    }
    private static void printInputStream(InputStream inputStream) {
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException exception) {
            log.error("Failed to print input stream", exception);
        }
    }
}
