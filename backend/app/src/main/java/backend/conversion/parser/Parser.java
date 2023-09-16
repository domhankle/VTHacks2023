package main.java.backend.conversion.parser;


public class Parser {
    public ArrayList<String> parse(String path) {
        try {

        }




    }

    public static String readFileToString(String filePath) {
        try {
            // Convert the file path string to a Path object
            Path path = Paths.get(filePath);

            // Use Files.readAllBytes to read the file content into a byte array
            byte[] fileBytes = Files.readAllBytes(path);

            // Convert the byte array to a String using UTF-8 encoding (adjust as needed)
            return new String(fileBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {

        }
    }

    private
}
