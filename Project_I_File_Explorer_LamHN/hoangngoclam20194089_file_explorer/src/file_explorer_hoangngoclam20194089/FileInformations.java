/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file_explorer_hoangngoclam20194089;

import java.io.File;
import java.lang.StringBuilder;
import java.util.Date;

/**
 *
 * @author STD_DELL
 */
public class FileInformations {

    public FileInformations() {
    }
    
    public String ShowInfoFile(File file){
        StringBuilder sb = new StringBuilder("\n");

        if(file.isFile()) {  
            sb.append("     Đây là tập tin.\n\n");           
            sb.append("     Tên tập tin: " + file.getName() + "\n");
            sb.append("     Đường dẫn tập tin: " + file.getAbsolutePath() + "\n\n");

            if(file.isHidden()) sb.append("     Tập tin là tập tin ẩn\n");
            else sb.append("     Tập tin không là tập tin ẩn\n");
            sb.append("     Kích thước: " + file.length() + " bytes \n\n");
            Date lastTime = new Date(file.lastModified());
            sb.append("     Thời điểm sửa đổi cuối: " + lastTime + "\n\n");
        }
        if(file.isDirectory()){
            sb.append("     Đây là thư mục.\n\n");
            sb.append("     Tên thư mục: " + file.getName() + "\n");
            sb.append("     Đường dẫn thư mục: " + file.getAbsolutePath() + "\n\n");

            if(file.isHidden()) sb.append("     Thư mục là thư mục ẩn\n");
            else sb.append("     Thư mục không là thư mục ẩn\n");
            Date lastTime = new Date(file.lastModified());
            sb.append("     Thời điểm sửa đổi cuối: " + lastTime + "\n\n");

            File[] children = file.listFiles();
            if(children != null) {
                sb.append("     Các file con: \n");
                for (File child : children) {
                    sb.append("          " + child.getName());
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
