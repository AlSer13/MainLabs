public class test {
    public static void main(String[] args) {
        String FilePath = args[0].substring(0,args[0].lastIndexOf('\\')+1);
        String FileName = args[0].substring(args[0].lastIndexOf('\\')+1, args[0].length());
        System.out.println("Path: " + FilePath + " File: " + FileName);
    }
}
