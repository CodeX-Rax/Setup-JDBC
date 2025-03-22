import java.io.*;
import java.sql.*;

public class IMAGE {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Rush@1311";
        //String image_path="D:\\20230506_154212.jpg";
        String folder_path="D:\\images\\";
        String query="SELECT image_data from image_table where image_id=(?) ";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("connection Established Successfully!!");
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                byte[] image_data=resultSet.getBytes("image_data");
                String image_path=folder_path+"ExtractedImage.jpg";
                OutputStream outputStream=new FileOutputStream(image_path);
                outputStream.write(image_data);
            }else{
                System.out.println("Image not found");
            }

            //used to insert image
            /*FileInputStream fileInputStream=new FileInputStream(image_path);
            byte[] imageData =new byte[fileInputStream.available()];
            fileInputStream.read(imageData);
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setBytes(1,imageData);
            int affectedRows=preparedStatement.executeUpdate();
            if (affectedRows>0){
                System.out.println("Image Inserted Successfully!!");
            }else{
                System.out.println("Image not Inserted!!");
            }*/

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
