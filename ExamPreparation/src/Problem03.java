import java.util.*;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] inputPieces = scanner.nextLine().split("\\|");
            String piece = inputPieces[0];
            String composer = inputPieces[1];
            String key = inputPieces[2];


            piecesMap.putIfAbsent(piece, new ArrayList<>());

            List<String> mapValue = Arrays.asList(composer, key);

            piecesMap.put(piece, mapValue);


        }


        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandLine = command.split("\\|");
            String commandType = commandLine[0];

            switch (commandType) {
                case "Add":
                    String pieceToAdd = commandLine[1];
                    String composerToAdd = commandLine[2];
                    String keyToAdd = commandLine[3];

                    if (piecesMap.containsKey(pieceToAdd)) {
                        System.out.printf("%s is already in the collection!%n", pieceToAdd);
                    } else {
                        List<String> valueToAdd = Arrays.asList(composerToAdd, keyToAdd);
                        piecesMap.put(pieceToAdd, valueToAdd);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceToAdd, composerToAdd, keyToAdd);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = commandLine[1];
                    if (!piecesMap.containsKey(pieceToRemove)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                    } else {
                        piecesMap.remove(pieceToRemove);
                        System.out.printf("Successfully removed %s!%n", pieceToRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceToChange = commandLine[1];
                    String newKey = commandLine[2];

                    if (!piecesMap.containsKey(pieceToChange)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToChange);
                    } else {
                        piecesMap.get(pieceToChange).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceToChange, newKey);
                    }

                    break;

            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : piecesMap.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }
    }
}
