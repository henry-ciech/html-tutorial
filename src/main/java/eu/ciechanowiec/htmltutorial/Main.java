package eu.ciechanowiec.htmltutorial;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class Main {
    public static void main(String[] args) {
        log.info("Application started");
        System.out.println("Hello, Universe!");
        log.info("Testing resource printing...");
        SamplePrinter samplePrinter = new SamplePrinter();
        samplePrinter.performSamplePrint("sampleLines.txt");
        log.info("Finished resource printing");
        log.info("Application ended");
    }
}
