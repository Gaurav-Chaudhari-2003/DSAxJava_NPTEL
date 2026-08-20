package nptel.W3_L2_ProgrammingForArrays;

class ArraysDemo {

    // 🔹 Generic method
    public static <T> void printArray(T[] arr) {
        for (T x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // 1️⃣ Declaration + Initialization
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Original 1D Array:");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();

        // 2️⃣ Insertion (insert 99 at index 2)
        int pos = 2;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == pos) newArr[i] = 99;
            else newArr[i] = arr[j++];
        }
        System.out.println("After Insertion:");
        for (int i : newArr) System.out.print(i + " ");
        System.out.println();

        // 3️⃣ Deletion (delete element at index
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == 3) continue;
            delArr[j++] = newArr[i];
        }
        System.out.println("Hello Neha");

        System.out.println("welcome to Main.java");
        
        
        for (int i : delArr) System.out.print(i + " ");
        System.out.println();

        // 4️⃣ Cloning
        int[] cloneArr = arr.clone();
        cloneArr[0] = 111; // change in clone won’t affect original
        System.out.println("Cloned Array:");
        for (int i : cloneArr) System.out.print(i + " ");
        System.out.println();

        // 5️⃣ 2D Array (Matrix) + Traversal
        int[][] matrix1 = { {1,2,3}, {4,5,6} };
        int[][] matrix2 = { {7,8,9}, {1,2,3} };
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] sum = new int[rows][cols];

        // Matrix Addition
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++)
                sum[i][j] = matrix1[i][j] + matrix2[i][j];

        System.out.println("Matrix Addition:");
        for (int[] row : sum) {
            for (int val : row) System.out.print(val+" ");
            System.out.println();
        }

        // 6️⃣ Jagged Array
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1,2};
        jagged[1] = new int[]{3,4,5};
        jagged[2] = new int[]{6};
        System.out.println("Jagged Array:");
        for (int[] row : jagged) {
            for (int val : row) System.out.print(val+" ");
            System.out.println();
        }

        // 7️⃣ Generic Array Example
        String[] names = {"Java", "Python", "C++"};
        System.out.println("Generic Array Print:");
        printArray(names);
    }
}
