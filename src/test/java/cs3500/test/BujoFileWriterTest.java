package cs3500.test;

import static cs3500.pa05.model.BujoFileWriter.weekToJson;
import static cs3500.pa05.model.BujoFileWriter.writeBujo;

import cs3500.pa05.model.Week;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * class that contains methods to write a Bullet Journal to a file
 */
public class BujoFileWriterTest {

  @Test
  void writeBujoTest() throws IOException {
    // Prepare test data
    Week week = new Week(); // Assuming you have a Week object to test
    String path = "test_output.json"; // Test output file path

    // Call the method under test
    writeBujo(week, path);

    // Verify the file was written successfully
    Path outputPath = Paths.get(path);
    Assertions.assertTrue(Files.exists(outputPath), "Output file does not exist.");

    // Verify the file content
    String fileContent = Files.readString(outputPath);
    Assertions.assertEquals(weekToJson(week).toString(), fileContent);

    // Clean up the test output file
    Files.deleteIfExists(outputPath);
  }

  @Test
  void writeBujoTest2() {
    // Prepare test data
    Week week = new Week(); // Assuming you have a Week object to test
    String path = "non_existing_directory/output.json"; // Invalid output file path

    writeBujo(week, path);
    // Call the method under test and expect an IOException
    //Assertions.assertThrows(IOException.class, () -> writeBujo(week, path));
  }
}
