package methods_ex;

import java.util.Arrays;

import java.util.Scanner;

public class arrayManipulator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "exchange":

                    int indexEx = Integer.parseInt(commandParts[1]);
                    if (isValidIndex(indexEx, numbersArr.length)) {

                        numbersArr = exchangeArrayElements(numbersArr, indexEx);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;
                case "max":
                    String evenOrOdd = commandParts[1];
                    if (evenOrOdd.equals("even")) {

                        printIndexMaxEvenNumber(numbersArr);

                    } else if (evenOrOdd.equals("odd")) {

                        printIndexMaxOddNumber(numbersArr);
                    }

                    break;
                case "min":
                    String evenOrOddMin = commandParts[1];
                    if (evenOrOddMin.equals("even")) {

                        printIndexMinEvenNumber(numbersArr);

                    } else if (evenOrOddMin.equals("odd")) {

                        printIndexMinOddNumber(numbersArr);

                    }
                    break;
                case "first":
                    int countEvenOrOddElements = Integer.parseInt(commandParts[1]);
                    String evenOrOddElements = commandParts[2];

                    if (countEvenOrOddElements > numbersArr.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (evenOrOddElements.equals("even")) {

                            printFirstEvenElements(numbersArr, countEvenOrOddElements);

                        } else if (evenOrOddElements.equals("odd")) {

                            printFirstOddElements(numbersArr, countEvenOrOddElements);

                        }
                    }
                    break;
                case "last":
                    int countEvenOrOddLastElements = Integer.parseInt(commandParts[1]);
                    String evenOrOddLastElements = commandParts[2];

                    if (countEvenOrOddLastElements > numbersArr.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (evenOrOddLastElements.equals("even")) {

                            printLastEvenElements(numbersArr, countEvenOrOddLastElements);


                        } else if (evenOrOddLastElements.equals("odd")) {

                            printLastOddElements(numbersArr, countEvenOrOddLastElements);

                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }


        System.out.print("[");
        for (int i = 0; i <= numbersArr.length - 1; i++) {
            if (i != numbersArr.length - 1) {
                System.out.print(numbersArr[i] + ", ");
            } else {
                System.out.print(numbersArr[i] + "]");
            }
        }

    }

    private static void printLastOddElements(int[] numbersArr, int countEvenOrOddLastElements) {
        int count = 0;
        for (int i = numbersArr.length - 1; i >= 0; i--) {
            if (numbersArr[i] % 2 != 0) {
                count++;
            }
            if (count == countEvenOrOddLastElements) {
                break;
            }
        }

        if (count != 0) {
            int[] lastOddArr = new int[count];
            int index = lastOddArr.length - 1;

            for (int i = numbersArr.length - 1; i >= 0; i--) {
                if (numbersArr[i] % 2 != 0) {
                    lastOddArr[index] = numbersArr[i];
                    index--;
                }
                if (index == -1) {
                    break;
                }
            }
            System.out.println(String.join(", ", Arrays.toString(lastOddArr)));
        } else {
            System.out.println("[]");
        }
    }



    private static void printLastEvenElements(int[] numbersArr, int countEvenOrOddLastElements) {


        int count = 0;
        for (int i = numbersArr.length - 1; i >= 0; i--) {
            if (numbersArr[i] % 2 == 0) {
                count++;
            }
            if (count == countEvenOrOddLastElements) {
                break;
            }
        }

        if (count != 0) {
            int[] lastEvenArr = new int[count];
            int index = lastEvenArr.length - 1;

            for (int i = numbersArr.length - 1; i >= 0; i--) {
                if (numbersArr[i] % 2 == 0) {
                    lastEvenArr[index] = numbersArr[i];
                    index--;
                }
                if (index == -1) {
                    break;
                }
            }

            System.out.println(String.join(", ", Arrays.toString(lastEvenArr)));
        } else {
            System.out.println("[]");
        }
    }

    private static void printFirstOddElements(int[] numbersArr, int countEvenOrOddElements) {

        int count = 0;
        for (int element : numbersArr) {
            if (element % 2 != 0) {
                count++;
            }
            if (count == countEvenOrOddElements) {
                break;
            }
        }

        if (count != 0) {
            int[] firstOddArr = new int[count];
            int index = 0;

            for (int i = 0; i < numbersArr.length; i++) {
                if (numbersArr[i] % 2 != 0) {
                    firstOddArr[index] = numbersArr[i];
                    index++;
                }
                if (index == firstOddArr.length) {
                    break;
                }
            }
            System.out.println(String.join(", ", Arrays.toString(firstOddArr)));
        } else {
            System.out.println("[]");
        }
    }

    private static void printFirstEvenElements(int[] numbersArr, int countEvenOrOddElements) {

        int count = 0;
        for (int element : numbersArr) {
            if (element % 2 == 0) {
                count++;
            }
            if (count == countEvenOrOddElements) {
                break;
            }
        }

        if (count != 0) {
            int[] firstEvenArr = new int[count];
            int index = 0;
            for (int i = 0; i <= numbersArr.length - 1; i++) {
                if (numbersArr[i] % 2 == 0) {
                    firstEvenArr[index] = numbersArr[i];
                    index++;
                }
                if (index == firstEvenArr.length) {
                    break;
                }
            }
            System.out.println(String.join(", ", Arrays.toString(firstEvenArr)));
        } else {
            System.out.println("[]");
        }
    }

    private static void printIndexMinOddNumber(int[] numbersArr) {
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = -1;
        for (int i = 0; i <= numbersArr.length - 1; i++) {
            int currentNum = numbersArr[i];
            if (currentNum % 2 != 0 && currentNum <= minOdd) {
                minOdd = currentNum;
                minOddIndex = i;
            }
        }
        if (minOddIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minOddIndex);
        }
    }

    private static void printIndexMinEvenNumber(int[] numbersArr) {
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = -1;
        for (int i = 0; i <= numbersArr.length - 1; i++) {
            int currentNum = numbersArr[i];
            if (currentNum % 2 == 0 && currentNum <= minEven) {
                minEven = currentNum;
                minEvenIndex = i;
            }
        }
        if (minEvenIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenIndex);
        }
    }

    private static void printIndexMaxOddNumber(int[] numbersArr) {

        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = -1;
        for (int i = 0; i <= numbersArr.length - 1; i++) {
            int currentNum = numbersArr[i];
            if (currentNum % 2 != 0 && currentNum >= maxOdd) {
                maxOdd = currentNum;
                maxOddIndex = i;
            }
        }
        if (maxOddIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxOddIndex);
        }
    }

    private static void printIndexMaxEvenNumber(int[] numbersArr) {
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        for (int i = 0; i <= numbersArr.length - 1; i++) {
            int currentNum = numbersArr[i];
            if (currentNum % 2 == 0 && currentNum >= maxEven) {
                maxEven = currentNum;
                maxEvenIndex = i;
            }
        }
        if (maxEvenIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenIndex);
        }
    }

    private static boolean isValidIndex(int index, int length) {
        return index >= 0 && index <= length - 1;
    }

    private static int[] exchangeArrayElements(int[] numbers, int index) {

        int[] numbersToIndex = new int[index + 1];
        int[] numbersAfterIndex = new int[numbers.length - index - 1];

        for (int i = 0; i <= index; i++) {
            int currentElement = numbers[i];
            numbersToIndex[i] = currentElement;
        }
        for (int i = index + 1; i <= numbers.length - 1; i++) {
            int currentElement = numbers[i];
            numbersAfterIndex[i - index - 1] = currentElement;
        }
        int[] exchangedNumbers = new int[numbers.length];

        for (int i = 0; i <= numbersAfterIndex.length - 1; i++) {
            exchangedNumbers[i] = numbersAfterIndex[i];
        }
        for (int i = numbersAfterIndex.length; i <= exchangedNumbers.length - 1; i++) {
            exchangedNumbers[i] = numbersToIndex[i - numbersAfterIndex.length];
        }

        numbers = exchangedNumbers;
        return numbers;

    }

}
